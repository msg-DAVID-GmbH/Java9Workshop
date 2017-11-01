package de.msg.java9features.api;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class shows the new Collections possibilities.
 *
 * @author henself
 * @since 26.09.2017
 */
class CollectionApi {

	/**
	 * Creation of List by the List Interface.
	 */
	@Test
	void getList() {
		List<Character> aList = List.of('a', 'b', 'c');

		//the List is unmodifiable
		assertThrows(UnsupportedOperationException.class, () -> aList.add('d'));
		assertThrows(UnsupportedOperationException.class, () -> aList.remove('a'));
	}

	/**
	 * Creation of Set by the Set Interface.
	 */
	@Test
	void getSet() {
		Set<Character> aSet = Set.of('a', 'b', 'c');

		//the Set is unmodifiable
		assertThrows(UnsupportedOperationException.class, () -> aSet.add('d'));
		assertThrows(UnsupportedOperationException.class, () -> aSet.remove('a'));
	}

	/**
	 * Creation of Map by the Map Interface.
	 */
	@Test
	void getMap() {
		Map<Integer, String> aMap = Map.of(1, "1", 2, "2", 3, "3");

		//the Map is unmodifiable
		assertThrows(UnsupportedOperationException.class, () -> aMap.put(4, "4"));
		assertThrows(UnsupportedOperationException.class, () -> aMap.remove(1));
	}

	/**
	 * Creation of Map by the Map Interface with more than 10 Values.
	 */
	@Test
	void getMapMoreValuesThan10() {
		Map<Integer, String> aMap = Map.ofEntries(Map.entry(1, "1"), Map.entry(2, "3"), Map.entry(3, "3"),
				Map.entry(4, "4"), Map.entry(5, "5"), Map.entry(6, "6"), Map.entry(7, "7"), Map.entry(8, "8"),
				Map.entry(9, "9"), Map.entry(10, "10"), Map.entry(11, "11"));

		//the Map is unmodifiable
		assertThrows(UnsupportedOperationException.class, () -> aMap.put(4, "4"));
		assertThrows(UnsupportedOperationException.class, () -> aMap.remove(1));
	}

	@Test
	void getStream() {
		Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
		List<Integer> r = List.of(1, 2, 3, 4, 5);
		assertEquals(r, s.collect(Collectors.toList()));
	}
}
