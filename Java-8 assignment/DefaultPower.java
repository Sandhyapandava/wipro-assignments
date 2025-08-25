package java8;

interface PowerCalculator {
    double calculatePower(double base, double exponent);

    default double calculateSquare(double number) {
        return number * number;
    }
}

public class DefaultPower implements PowerCalculator {
    @Override
    public double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        DefaultPower calculator = new DefaultPower();
        double power = calculator.calculatePower(2, 3);
        double square = calculator.calculateSquare(4);

        System.out.println("2^3 = " + power); // Output: 2^3 = 8.0
        System.out.println("4^2 = " + square); // Output: 4^2 = 16.0
    }
}