package com.turkcell.SpringBootRestJDBC.model;


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