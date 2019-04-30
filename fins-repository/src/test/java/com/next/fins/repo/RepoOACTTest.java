package com.next.fins.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RepoOACTTest
{
	@Autowired
	private RepoOJDT repoOJDT;
	@Autowired
	EntityManager em;

	
	@Test
	public void test() throws Exception 
	{
		//em.merge();
		repoOJDT.getOne(1);
	}
	@Test
	public void testExample() throws Exception 
	{
		/*List<BmoORDR> data = repoORDR.findOpenDocument();
		System.out.println(data.size());*/
	}
	@Test
	public void testUDF() throws Exception 
	{
		/*List<BmoORDR> oOrderList = repository.findWithUDF();
		String color = (String) oOrderList.get(0).getUserFields().get("U_Color");
		System.out.println(color);*/
	}
}