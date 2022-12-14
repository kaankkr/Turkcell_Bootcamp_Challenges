package com.turkcell.SpringBootHibernateJPA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ogrenci
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	private String NAME;

	//Ogrenci nosunun unique olduğunu belirtmek için bunu ekleriz.
	@Column(unique = true)
	private long OGRNUMBER;

	private long YEAR;

	public Ogrenci(String nAME, long oGRNUMBER, long yEAR)
	{
		NAME = nAME;
		OGRNUMBER = oGRNUMBER;
		YEAR = yEAR;
	}
	
}
