package de.msg.java9features.modulesystem.exported;

import de.msg.java9features.modulesystem.PrivateClass;

/**
 * This class can be accessed from outside of the Module.
 *
 * @author henself
 * @since 26.09.2017
 */
public class PublicClass {

    public int getDoubleNumber() {
        return new PrivateClass().getNumber() * 2;
    }
}
