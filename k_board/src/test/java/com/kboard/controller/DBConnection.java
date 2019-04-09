package com.kboard.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kboard.domain.BoardVO;
import com.kboard.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DBConnection {

	final String DRIVER = "org.mariadb.jdbc.Driver";
	final String URL = "jdbc:mariadb://127.0.0.1:3306";
	final String USER = "kuzuro";
	final String PASSWORD = "1111";
	
	@Test
	public void connectionTest() throws Exception {

		Class.forName(DRIVER);

		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // connectionTest end  
	
	
	@Inject
	private BoardService service;
		
	@Test
	public void writeTest() throws Exception{
		BoardVO vo = new BoardVO();
		
		vo.setTitle("제목 테스트");
		vo.setContent("내용 테스트");
		vo.setWriter("작성자 테스트");
		
		service.write(vo);
	}
	
}







