package de.msg.java9features.api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Show the APi extension of the Util-Classes.
 *
 * @author henself
 * @since 27.09.2017
 */
class UtilApi {

	/**
	 * Tests where to arrays mismatch.
	 */
	@Test
	void mismatch() {
		int[] first = { 1, 2, 3 };
		int[] second = { 1, 4, 3 };
		assertEquals(1, Arrays.mismatch(first, second));

		assertEquals(-1, Arrays.mismatch(first, first));
	}

	@Test
	void mathMultiply() {
		assertEquals(5000000000L, Math.multiplyExact(5000000L, 1000));
		assertThrows(ArithmeticException.class, () -> Math.multiplyExact(Long.MAX_VALUE, 1000));
	}
}
