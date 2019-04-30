package com.next.fins.web;

import com.next.fins.domain.entity.BmoOACT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;



@SpringBootApplication
@ServletComponentScan
@EntityScan(basePackageClasses = BmoOACT.class)
public class AppOData2
{

	public static void main(String[] args)
	{
		SpringApplication.run(AppOData2.class, args);
	}
}
