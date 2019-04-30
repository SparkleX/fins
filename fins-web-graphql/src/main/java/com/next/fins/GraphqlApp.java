package com.next.fins;


import com.next.fins.domain.entity.BmoOACT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EntityScan(basePackageClasses= BmoOACT.class)
@Component
public class GraphqlApp {

	public static void main(String[] args) 
	{
		SpringApplication.run(GraphqlApp.class, args);
	}
}
