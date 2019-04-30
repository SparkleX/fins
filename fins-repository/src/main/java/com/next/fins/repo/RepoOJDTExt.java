package com.next.fins.repo;

import java.util.List;

import com.next.fins.domain.entity.BmoOJDT;


public interface RepoOJDTExt
{
	List<BmoOJDT> findAllWithLines();
}
