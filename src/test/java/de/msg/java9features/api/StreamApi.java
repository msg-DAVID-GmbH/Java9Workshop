package de.msg.java9features.api;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This Class shows the new methods of the <code>{@link java.util.stream.Stream}</code>. This API-Change has a strong
 * correlation to <code>{@link java.util.Optional}</code>
 *
 * @author henself
 * @since 26.09.2017
 */
class StreamApi {

	private static IntStream getIntStreamFrom0To100TwoTimes() {
		return IntStream.concat(IntStream.range(1, 100), IntStream.range(1, 100));
	}

	/**
	 * Takes the first values which matches the given predicate and stops at the first which does not match.
	 */
	@Test
	void streamApiTakeWhile() {
		assertEquals(9, getIntStreamFrom0To100TwoTimes().takeWhile(j -> j < 10).count());
		Stream.of('a', 'b', '1', 'c').takeWhile(Character::isAlphabetic).forEach(System.out::println);
	}

	/**
	 * It is the opposite of <code>{@link Stream}.takeWhile</code>
	 */
	@Test
	void streamApiDropWhile() {
		assertEquals(10, getIntStreamFrom0To100TwoTimes().dropWhile(j -> j < 10).findFirst().orElse(-1));
		Stream.of('a', 'b', '1', 'c').dropWhile(Character::isAlphabetic).forEach(System.out::println);
	}

	/**
	 * There is no need to use a for Iteration, because you can now use a Iteration on Stream.
	 * <p>
	 * :)  for everybody, who hates java-Keywords :)
	 */
	@Test
	void avoidForIterations() {
		Stream.iterate(0, i -> i < 10, i -> i + 1).forEach(System.out::println);
	}

	@Test
	void streamOfNullable() {
		assertEquals(0, Stream.ofNullable(null).count());
		assertEquals(1, Stream.ofNullable(1).count());
	}

}
