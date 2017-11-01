module de.msg.java9features.modulesystem {

	// This Package is the open API of this Module
	exports de.msg.java9features.modulesystem.exported;

	// This Package is only available for the de.msg.java9features.special module and not for other modules
	exports de.msg.java9features.modulesystem.exported.special to de.msg.java9features.special;
}
