package com.next.fins.repo;

import com.next.fins.domain.entity.BmoJDT1;
import com.next.fins.domain.entity.BmoOACT;
import com.next.fins.domain.entity.BmoOJDT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaEntityManagerTest
{
	@Autowired
	EntityManager em;


	@Test
	public void arrayTable() throws Exception
	{
		//BmoOJDT ojdt = em.find(BmoOJDT.class, 1);
		//System.out.println(ojdt.getJDT1().size());

		BmoOJDT o = new BmoOJDT();
		o.setId(100);
		BmoJDT1 o1 = new BmoJDT1();
		o1.setId(100);
		o1.setParentId(1);
		//o.getJDT1().add(o1);
		//o1.setParentId(o1.getId());
		em.persist(o);

		em.persist(o1);
		em.flush();
	}


	@Test
	public void test() throws Exception 
	{
		/*BmoOACT oOACT = em.find(BmoOACT.class, 1);
		em.detach(oOACT);
		em.remove(oOACT);
		System.out.println(oOACT.getAcctCode());*/
	}

	@Test
	public void persistRemoved() throws Exception
	{
		BmoOACT oOACT = em.find(BmoOACT.class, 1);
		em.remove(oOACT);
	}
	@Test
	public void loadLines() throws Exception
	{
		BmoOJDT ojdt = em.find(BmoOJDT.class, 1);
		System.out.println(ojdt.getJDT1().get(0).getAccountId());
	}
	@Test
	public void persistRemoved1() throws Exception
	{
		/*BmoOACT oOACT = em.find(BmoOACT.class, 1);
		em.remove(oOACT);
		oOACT.setAcctCode("A001-Updated");
		em.persist(oOACT);
		BmoOACT oACT1 = em.find(BmoOACT.class, 1);

		System.out.println(oACT1.getAcctCode());
		em.flush();*/
	}
}