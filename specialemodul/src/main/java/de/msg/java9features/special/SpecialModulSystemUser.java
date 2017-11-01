package de.msg.java9features.special;

import de.msg.java9features.modulesystem.exported.PublicClass;
import de.msg.java9features.modulesystem.exported.special.SpecialClass;

/**
 * This Module has more access rights, so it is possible to call <code>SpecialClass</code> too.
 *
 * @author henself
 * @see PublicClass
 * @see de.msg.java9features.modulesystem.PrivateClass
 * @see SpecialClass
 * @since 26.09.2017
 */
public class SpecialModulSystemUser {

	public static void main(String[] args) {
		//Because of the explicit given rights this module can call both
		System.out.println(new PublicClass().getDoubleNumber());
		System.out.println(new SpecialClass().canUse());

		//But the call to the PrivateClassed is not allowed
		//System.out.println(new PrivateClass().getNumber());
	}
}
