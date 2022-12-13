package com.turkcell.SpringBootRestJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DersOgrenci {

	private long ID;
	private int DEVAMSIZLIK;
	private long NOTE;
	private long ders_id;
	private long ogrenci_id;
}