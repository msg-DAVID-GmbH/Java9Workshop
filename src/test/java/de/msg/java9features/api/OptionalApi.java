package de.msg.java9features.api;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The new <code>{@link java.util.Optional}</code> API is shown in this Class. This API has a strong correlation to
 * <code>{@link java.util.stream.Stream}</code>
 *
 * @author henself
 * @since 26.09.2017
 */
class OptionalApi {

	@Test
	void optionalToStream() {
		assertEquals(1, Stream.concat(Optional.empty().stream(), Optional.of(1).stream()).count());
	}

	/**
	 * Use an Optional if Present or another one if not. It is very close to <code>orElse</code> only that an optional
	 * is returned which could be not present too and so it can be go on...
	 */
	@Test
	void optionalOr() {
		assertEquals(Optional.of(1), Optional.of(1).or(() -> Optional.of(2)));
		assertEquals(Optional.of(2), Optional.empty().or(() -> Optional.of(2)));
		assertEquals(Optional.of(3), Optional.empty().or(Optional::empty).or(() -> Optional.of(3)));
		//...
	}

	/**
	 * Finally Optional as Api for ifPresentOrElse.
	 */
	@Test
	void optionalIfPresentOrElse() {
		Optional.of(1).ifPresentOrElse(System.out::println, () -> System.out.println("There is no int."));
		Optional.empty().ifPresentOrElse(System.out::println, () -> System.out.println("There is no int."));
	}

}
