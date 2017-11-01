package de.msg.java9features.languagechange;

import java.util.List;

/**
 * Interfaces could now have a private Methods.
 *
 * @author henself
 * @since 27.09.2017
 */
public interface InterfaceChange {

	default int getAverage() {
		return getSum() / getCount();
	}

	private int getSum() {
		return getValues().stream().reduce(0, (i, j) -> i + j);
	}

	private int getCount() {
		return getValues().size();
	}

	List<Integer> getValues();

	void setValues(List<Integer> v);
}
