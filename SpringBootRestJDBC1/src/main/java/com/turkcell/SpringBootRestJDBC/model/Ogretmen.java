package com.turkcell.SpringBootRestJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ogretmen
{
	// bigint
	private long ID;

	private String NAME;

	private boolean IS_GICIK;

	public Ogretmen(String nAME, boolean iS_GICIK)
	{
		NAME = nAME;
		IS_GICIK = iS_GICIK;
	}
}