package com.next.fins.repo;

import com.next.fins.domain.entity.BmoOACT;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackageClasses= BmoOACT.class)
public class AppTest {

}
