package de.msg.java9features.languagechange;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

/**
 * A simple Implementation to show the new possibilities with Interfaces.
 *
 * @author henself
 * @since 27.09.2017
 */
public class SimpleInterfaceIpl implements InterfaceChange {
	private List<Integer> values = List.of(1, 2, 3);

	public static void main(String[] args) {
		new SimpleInterfaceIpl().callSum();
	}

	@Override
	public List<Integer> getValues() {
		return values;
	}

	@Override
	public void setValues(List<Integer> v) {
		values = v;
	}

	private void callSum() {
		// There is no possibility for the Implementing class
//		this.getSum();
//		super.getSum();
//		InterfaceChange.getSum();
//		new InterfaceChange().getSum();

		Stream.concat(Stream.of(InterfaceChange.class.getMethods()), Stream.of(this.getClass().getMethods()))
				.filter(method -> method.getName().contains("getSum"))
				.findFirst()
				.ifPresentOrElse(method -> {
					method.setAccessible(true);
					try {
						System.out.println(method.invoke(this));
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}, () -> System.out.print("Not Found"));
	}

}
