package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {

	private String name;
	private Integer age;
	private Integer salary;
	private String email;

	public Employee(String name, Integer age, Integer salary, String email) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", salary=" + salary + ", email='" + email + '\''
				+ '}';
	}

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();

		list.add(new Employee("John", 25, 50000, "a@gmail.com"));
		list.add(new Employee("Sam", 30, 60000, "b@gmail.com"));
		list.add(new Employee("Alex", 22, 40000, "c@gmail.com"));

//		Collections.sort(list); // uses compareTo()

		for (Employee e : list) {
			System.out.println(e);
		}

		list.forEach(e -> System.out.println(e.getName() + " - " + e.getSalary()));

		list.sort(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName));

		for (Employee e : list) {
			System.out.println(e);
		}

	}

//	@Override
//	public int compareTo(Employee e) {
//		// TODO Auto-generated method stub
//		return this.age - e.age; //
//	}

}
