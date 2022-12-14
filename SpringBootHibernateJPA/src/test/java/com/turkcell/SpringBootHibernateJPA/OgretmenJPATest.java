package com.turkcell.SpringBootHibernateJPA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.repo.OgretmenRepository;

//jdbc kullanılıyorsa aşağıdaki denenebilir
//@JdbcTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OgretmenJPATest
{
	@Autowired
	public OgretmenRepository ogretmenRepository;

	@Test
	// rollback olmazsa otomatik rollback yapıyor, default
	// @Rollback(value = false)
	public void saveTest()
	{
		Ogretmen ogr = new Ogretmen("test user 2", true);
		ogr = ogretmenRepository.save(ogr);
		Ogretmen result = ogretmenRepository.findById(ogr.getID()).get();
		Assertions.assertEquals(result, ogr);
	}
}





