package Solidprinciples;

public class Liskov_Substitution_Principle {
	public static void main(String[] args) {
		Bird bird = new Duck();
		bird.makeSound(); // Output: Duck quacks
	}
}

class Bird {
	public void makeSound() {
		System.out.println("Bird makes sound");
	}
}

class Duck extends Bird {
	@Override
	public void makeSound() {
		System.out.println("Duck quacks");
	}
}
