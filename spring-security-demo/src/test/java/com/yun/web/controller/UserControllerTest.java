package com.yun.web.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void whenQuerySuccess(){
		try {
			String result= mockMvc.perform(MockMvcRequestBuilders.get("/user").
					//param("username", "yby").
					param("username","yby").
					param("age","18").
					param("ageTo","60").
/*					param("size","315").
					param("page","3").
					param("sort","age,desc").*/
					contentType(MediaType.APPLICATION_JSON_UTF8)).
					andExpect(MockMvcResultMatchers.status().isOk()).
					andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
					.andReturn().getResponse().getContentAsString();
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void whenGetInfoSuccess()throws Exception{
		String result= mockMvc.perform(MockMvcRequestBuilders.get("/user/1").
				contentType(MediaType.APPLICATION_JSON_UTF8)).
				andExpect(MockMvcResultMatchers.status().isOk()).
				andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void whenUpdateSuccess()throws Exception{
		Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		String content= "{\"id\" :\"1\",\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
		String result= mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void whenDeleteSuccess() throws Exception{
		mockMvc.perform( MockMvcRequestBuilders.delete("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
