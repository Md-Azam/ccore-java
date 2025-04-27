package streams;

import java.util.Arrays;
import java.util.Objects;

public class Student {
	
	
	int id;
	int age;
	String name;
	int roll ;
	int[] marks;
	
	//Constructor with field
	 public Student(int id, int age, String name, int roll, int[] marks) {
	        this.id = id;
	        this.age = age;
	        this.name = name;
	        this.roll = roll;
	        this.marks = marks;
	    }
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", roll=" + roll + ", marks="
				+ Arrays.toString(marks) + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(marks);
		result = prime * result + Objects.hash(age, id, name, roll);
		return result;
	}



	
	
	
	

}
