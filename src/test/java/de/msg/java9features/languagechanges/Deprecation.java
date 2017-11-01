package de.msg.java9features.languagechanges;

import org.junit.jupiter.api.Test;

import java.applet.Applet;
import java.util.Observable;
import java.util.Observer;

/**
 * Deprecated can be written to the hole class to avoid warnings from imports. It also shows the Apis which are now
 * deprecated.
 *
 * @author henself
 * @since 27.09.2017
 */

class Deprecation {

	@Test
	void useDeprecatedClassInAMethod() {
		new Applet();//here deprecated it is deprecated, but not in the import section.
	}

	void deprecatedClasses() {
		new Integer(5);
		new Integer("5");
		new Long(5);
		new Long("5");
		//... for all primitive Wrapper Constructors

		Observable k;
		Observer o;
	}

	@Test
	void naming() {
		// a single _ is not a valid identifier
		// int _ = 5;
	}
}

