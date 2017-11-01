package de.msg.java9features.exceptions;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the Usage of the new Stacktrace-Walker.
 *
 * @author henself
 * @since 12.10.2017
 */
class Exceptions {

	private static StackTraceElement[] throwException() {
		throw new UnsupportedOperationException("Unsupported");
	}

	private static StackTraceElement[] catchException() {
		try {
			return throwException();
		} catch (UnsupportedOperationException ignored) {
			return ignored.getStackTrace();
		}
	}

	/**
	 * Getting only Relevant Stacktrace Elements... for example only these which are from the own project
	 */
	@Test
	void gettingOnlyOwnStackTrace() {
		StackTraceElement[] stackTrace = catchException();
		assertEquals(3, Stream.of(stackTrace)
				.filter(stackTraceElement -> stackTraceElement.getClassName().startsWith("de.msg.java9features"))
				.count());
	}

	/**
	 * looking for elements which are native implemented or not
	 */
	@Test
	void nativeMethods() {
		StackTraceElement[] stackTrace = catchException();
		assertEquals(1, Stream.of(stackTrace).filter(StackTraceElement::isNativeMethod).count());
	}

	/**
	 * Get the line number of the error -> maybe to jump to the source direct?
	 */
	@Test
	void gettingLineNumber() {
		StackTraceElement[] stackTrace = catchException();
		assertTrue(30 > Stream.of(stackTrace)
				.map(StackTraceElement::getLineNumber)
				.filter(line -> line > 100)
				.count());
	}
}
