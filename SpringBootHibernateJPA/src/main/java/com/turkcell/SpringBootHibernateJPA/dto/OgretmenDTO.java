package com.turkcell.SpringBootHibernateJPA.dto;

import java.util.List;

import com.turkcell.SpringBootHibernateJPA.model.Ders;

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
public class OgretmenDTO
{
	private String NAME;

	private boolean ISGICIK;
	
	private List<Ders> dersler;
}