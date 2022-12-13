package com.turkcell.SpringBootRestJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DersDTO
{
	private long id;
	
	private String ogretmen;
	
	private String konu;
}