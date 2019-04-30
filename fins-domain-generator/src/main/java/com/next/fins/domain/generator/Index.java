package com.next.fins.domain.generator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Index 
{
	@Autowired
	TableGenerator genTable;

	public static void main(String[] args) throws Exception 
	{
		ApplicationContext appContext = SpringApplication.run(Index.class, args);
		Index instance = appContext.getBean(Index.class);
		instance.genTable.execute();
	}
}
