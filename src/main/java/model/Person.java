package model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
	@NotNull
	@Size(min=2, max=20)
	private String name;
	
	@NotNull
	@Min(18)
	private int age;
	private String param;	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParam() {
		return param;
	}

	public Person setParam(String param) {
		this.param = param;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person()
	{
		
	}
}
