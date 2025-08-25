package Solidprinciples;

public class Single_Responsibility_Principle {
	public static void main(String[] args) {
		Employee employee = new Employee("John", 50000);
		EmployeeRepository repository = new EmployeeRepository();
		repository.save(employee);
	}
}

class Employee {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
}

class EmployeeRepository {
	public void save(Employee employee) {
		System.out.println("Saving employee data to database...");
	}
}
