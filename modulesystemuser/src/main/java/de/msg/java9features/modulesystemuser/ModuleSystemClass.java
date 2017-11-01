package de.msg.java9features.modulesystemuser;

import de.msg.java9features.modulesystem.exported.PublicClass;

/**
 * This Class try to use the both classes of the Module <code>ModuleSystem</code>.
 *
 * @author henself
 * @see PublicClass
 * @see de.msg.java9features.modulesystem.PrivateClass
 * @see de.msg.java9features.modulesystem.exported.special.SpecialClass
 * @since 26.09.2017
 */
public class ModuleSystemClass {

	public static void main(String[] args) {
		//Can be used because its provide by the module
		System.out.println(new PublicClass().getDoubleNumber());

		//only the package is provide not the whole package structure,
		// so a call to the SpecialeClass of the package special is not possible
//        System.out.println(new SpecialClass().canUse());

		//Can not be used, because its not provide by the module
		//System.out.println(new PrivateClass().getNumber());
	}
}
