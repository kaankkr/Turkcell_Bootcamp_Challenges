package com.turkcell.SpringBootHibernateJPA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;

import javax.persistence.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// note 100 'den büyük olamaz
@Check(constraints = "NOTE < 101")
public class DersOgrenci
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@ManyToOne
	// foreign key 'e isim vermek için
	@JoinColumn(foreignKey = @ForeignKey(name = "OGRENCI_FK"))
	private Ogrenci ogrenci;

	@ManyToOne
	// foreign key 'e isim vermek için
	@JoinColumn(foreignKey = @ForeignKey(name = "DERS_FK"))
	private Ders ders;
	
	private int DEVAMSIZLIK;

	private long NOTE;
}
