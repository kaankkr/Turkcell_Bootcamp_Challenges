package com.turkcell.SpringBootHibernateJPA;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.turkcell.SpringBootHibernateJPA.controller.OgretmenController;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;
import com.turkcell.SpringBootHibernateJPA.service.OgretmenDTOService;
import com.turkcell.SpringBootHibernateJPA.service.OgretmenService;

@WebMvcTest(controllers = OgretmenController.class)
// service katmanını mock 'lamadan repo 'ya da ulaşabilmek için deneyebilirsiniz
//@org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
//junit4 kullanıyorsanız
//@RunWith(SpringRunner.class)
public class OgretmenMVCTest
{
	@Autowired
	public MockMvc mock;

	@MockBean
	public OgretmenService ogretmenService;
	
	@MockBean
	public OgretmenDTOService ogretmenDTOService;
	
	// @BeforeAll
	//public void initizlizeMyBeans()
	//{
		//burada service katmanını initilize et falan filan
	    //ogretmenService = new ogretmenService(ogretmenRepo);
	//}

	@Test
	public void getOgretmenByID() throws Exception
	{
		// { "id": 1, "name": "numan", "isgicik": false }
		Ogretmen ogr = new Ogretmen(1, "numan", false);
		// 1 id 'li öğretmen service katmanından getirildiği zaman farz et ki.....
		Mockito.when(ogretmenService.getByID(1L)).thenReturn(ogr);
		RequestBuilder request = MockMvcRequestBuilders.get("/ogretmen/getById/1");
		// assertion gibi expectation yazabilirim
		ResultMatcher gicikMatcher = MockMvcResultMatchers.jsonPath("$.isgicik").value(false);
		ResultMatcher nameMatcher = MockMvcResultMatchers.jsonPath("$.name").value("numan");
		ResultMatcher idMatcher = MockMvcResultMatchers.jsonPath("$.id").value("1");
		ResultMatcher okMatcer = MockMvcResultMatchers.status().isOk();
		//mock.perform(request).andExpect(gicikMatcher).andExpect(nameMatcher).andExpect(idMatcher).andExpect(okMatcer);
		mock.perform(request).andExpectAll(gicikMatcher, nameMatcher, idMatcher, okMatcer);
	}
}