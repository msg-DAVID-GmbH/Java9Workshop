package de.msg.java9features.languagechanges;

import de.msg.java9features.languagechange.InterfaceChange;
import de.msg.java9features.languagechange.SimpleInterfaceIpl;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests the Private methods in Interfaces.
 *
 * @author henself
 * @version $Id$
 * @since 27.09.2017
 */
class LanguangeChanges {

	/**
	 * The AverageFunction uses 2 private Methods. {@link InterfaceChange}
	 */
	@Test
	void testAverageFunction() {
		InterfaceChange inter = new SimpleInterfaceIpl();
		inter.setValues(List.of(1, 2, 3));
		assertEquals(List.of(1, 2, 3), inter.getValues());

		assertEquals(2, inter.getAverage());
	}

	@Test
	void tryWithRessources() {
		try {
			final URL url = getClass().getClassLoader().getResource("file.txt");
			FileReader fileReader = new FileReader(url == null ? "" : url.getFile());
			try (fileReader) {//can use the implicit final variable fileReader.
				System.out.println(fileReader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void useDimondOperatorForAnonymusClassesMethod() {
		assertNotNull(useDimondOperatorForAnonymusClasses());
	}

	/**
	 * Dimamondoperator at anonymous classes can now be used if the Typ is denotable.
	 */
	private <T> Generic<T> useDimondOperatorForAnonymusClasses() {
		return new Generic<>() {
		};
	}

	private interface Generic<T> {
	}
}
