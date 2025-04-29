package com.example.spring_demo_jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class SpringDemoJdbcApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoJdbcApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		showConnection();
	}

	private void showConnection() throws SQLException {
//		log.info(dataSource.toString());
		System.out.println(dataSource.getClass());
		Connection conn = dataSource.getConnection();
//		log.info(conn.toString());
		System.out.println(conn);
		conn.close();
	}
}
