package com.turkcell.SpringBootRestJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ogrenci {

	private long ID;
	private String NAME;
	private long OGRNUMBER;
	private long YEAR;
	
	
}