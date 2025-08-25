package Solidprinciples;

public class Interface_Segregation_Principle {
	public static void main(String[] args) {
		Printer printer = new HP_Printer();
		printer.print();
	}
}

interface Printer {
	void print();
}

interface Scanner {
	void scan();
}

class HP_Printer implements Printer {
	@Override
	public void print() {
		System.out.println("Printing...");
	}
}

class Canon_MFP implements Printer, Scanner {
	@Override
	public void print() {
		System.out.println("Printing...");
	}

	@Override
	public void scan() {
		System.out.println("Scanning...");
	}
}