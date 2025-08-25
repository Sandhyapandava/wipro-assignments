package java8;

import java.util.ArrayList;

//lambda Expression 1
interface Greeting {
	void greet();
}

public class WithLambdaExpression {

	public static void main(String[] args) {

		Greeting g = () -> System.out.println("Hello Good MRng");
		g.greet();

		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("rk");
		arrayList.add("rk1");
		arrayList.add("rk2");

		for (String n : arrayList) {
			System.out.println(n);
		}

		// with lamdaExpression
		arrayList.forEach(n -> System.out.println(n));

	}

}