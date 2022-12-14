package com.turkcell.SpringBootHibernateJPA;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turkcell.SpringBootHibernateJPA.model.Ogretmen;

//test paketine yazdığım için maven ile otomatik entegre oldu
@SpringBootTest
@DisplayName(value = "Spring boot test")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class DemoApplicationTests
{
	@Autowired
	public MockMvc mock;
	
	@Test
	@Order(value = 2)
	public void getOgretmenTest() throws Exception
	{
		// { "id": 1, "name": "numan", "isgicik": false }
		RequestBuilder request = MockMvcRequestBuilders.get("/ogretmen/getById/1");
		// assertion gibi expectation yazabilirim
		// assertThat() gibi
		ResultMatcher gicikMatcher = MockMvcResultMatchers.jsonPath("$.isgicik").value(false);
		ResultMatcher nameMatcher = MockMvcResultMatchers.jsonPath("$.name").value("numan");
		ResultMatcher idMatcher = MockMvcResultMatchers.jsonPath("$.id").value("1");
		ResultMatcher okMatcer = MockMvcResultMatchers.status().isOk();
		//mock.perform(request).andExpect(gicikMatcher).andExpect(nameMatcher).andExpect(idMatcher).andExpect(okMatcer);
		mock.perform(request).andExpectAll(gicikMatcher, nameMatcher, idMatcher, okMatcer);
	}

	@Test
	@Order(value = 1)
	public void saveOgretmen() throws Exception
	{
		// { "name": "numan", "isgicik": false }
		String ogretmen = new ObjectMapper().writeValueAsString(new Ogretmen("recep", false));
		RequestBuilder request = MockMvcRequestBuilders.post("/ogretmen/save").content(ogretmen).contentType(MediaType.APPLICATION_JSON);
		String result = mock.perform(request).andReturn().getResponse().getContentAsString();
		Assertions.assertEquals("recep isimli öğrenci başarıyla eklendi", result);
		// aspect oriented içinde de assertioın 'lar var, kafanız karışmasın
	}
	
	
	// denenebilir
	// @Autowired
	// TestRestTemplate templateRestTemplate;
	
//	@Before
//	public void setUp()
//	{
//		this.restTemplate = new TestRestTemplate();
//	}

//	@Test
//	public void testGet() throws Exception
//	{
//		String body = restTemplate.getForEntity("http://localhost:8080/person/getByName/osman", String.class).getBody();
//		Person person = new ObjectMapper().readValue(body, Person.class);
//		Assert.assertEquals(new Person("osman", 45), person);
//	}

//	@Test
//	public void testSave()
//	{
//		Ogrenci person = new Ogrenci("Pelin", 123, 3);
//		ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/ogrenci/save", HttpMethod.POST, new HttpEntity<>(person), String.class);
//		System.out.println(result.getStatusCode() + " - " + result.getBody());
//	}
}
