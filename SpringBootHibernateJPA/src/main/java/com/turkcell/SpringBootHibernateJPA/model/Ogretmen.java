package com.turkcell.SpringBootHibernateJPA.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@javax.persistence.Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor 
public class Ogretmen
{
	// bigint
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@Column(length = 100)
	private String NAME;

	private boolean ISGICIK;

	// mvc uygulamasında kullanılabilir
	// mappedBy olmazsa N-N ilişkisi ile yeni tablo oluşturur
	// fetch default olarak lazy 'dir
	// @JsonIgnore
	//@JsonBackReference
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "ogretmen")
	//private List<Ders> dersler;

	public Ogretmen(String nAME, boolean iS_GICIK)
	{
		NAME = nAME;
		ISGICIK = iS_GICIK;
	}
}