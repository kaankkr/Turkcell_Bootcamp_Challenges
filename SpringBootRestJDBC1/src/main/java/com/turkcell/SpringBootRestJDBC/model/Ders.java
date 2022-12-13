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
public class Ders
{
	private long ID;

	private long OGR_ID;

	private long KONU_ID;

	public Ders(long oGR_ID, long kONU_ID)
	{
		OGR_ID = oGR_ID;
		KONU_ID = kONU_ID;
	}
}
