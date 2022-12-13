package com.turkcell.SpringWebwithJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
public class Person
{
	// pojo (plain old java object)

	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Person()
	{
	}

	public Person(String name)
	{
		this.name = name;
	}
}
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	private int personId;

	private String  personName;
	
}