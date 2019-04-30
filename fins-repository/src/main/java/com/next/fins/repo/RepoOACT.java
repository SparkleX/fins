package com.next.fins.repo;

import com.next.fins.domain.entity.BmoOACT;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoOACT extends RepositoryBase<BmoOACT, Integer>//, QuerydslBinderCustomizer<QBmoORDR>
{
	
//	@Query("select * from OCRD where CardType='C'")
//	List<BmoOACT> findCustomers();
   /* @Override
    default public void customize(QuerydslBindings bindings, QBmoORDR root) {
        bindings.bind(String.class)
        .first((StringPath path, String  value) -> path.containsIgnoreCase(value));
    }*/
	
	
}
