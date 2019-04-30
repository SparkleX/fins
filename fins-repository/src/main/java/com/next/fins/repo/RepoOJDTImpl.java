package com.next.fins.repo;

import java.util.List;

import com.next.fins.domain.entity.BmoJDT1;
import com.next.fins.domain.entity.BmoOJDT;
import org.springframework.beans.factory.annotation.Autowired;


public class RepoOJDTImpl implements RepoOJDTExt
{
	@Autowired
    RepoOJDT repoOJDT;

	@Override
	public List<BmoOJDT> findAllWithLines() {
		List<BmoOJDT> list = repoOJDT.findAll();
		for(BmoOJDT o:list)
		{
			List<BmoJDT1> jdt1 = o.getJDT1();
			for(BmoJDT1 a:jdt1)
			{
				System.out.println(a.getAccountId());
			}
		}
		return list;
	}
}
