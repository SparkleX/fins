package com.next.fins.graphql.resolver;


import java.util.List;
import java.util.Optional;

import com.next.fins.domain.entity.BmoJDT1;
import com.next.fins.repo.RepoOJDT;
import com.next.fins.domain.entity.BmoOJDT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.transaction.annotation.Transactional;


@Component
public class Query implements GraphQLQueryResolver 
{
	@Autowired
    private RepoOJDT repoOJDT;
	@Transactional
    public Iterable<BmoOJDT> findAllOJDT() {
        List<BmoOJDT> rt = repoOJDT.findAllWithLines();
        return rt;
    }
    public BmoOJDT findOneOJDT(Integer id) {
        Optional<BmoOJDT> opt = repoOJDT.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }
}