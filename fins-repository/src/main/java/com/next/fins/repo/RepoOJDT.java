package com.next.fins.repo;

import com.next.fins.domain.entity.BmoOJDT;
import org.springframework.stereotype.Repository;



@Repository
public interface RepoOJDT extends RepositoryBase<BmoOJDT, Integer>,RepoOJDTExt//, QuerydslBinderCustomizer<QBmoORDR>
{

//	@Query("from BmoODT")
//	List<BmoOJDT> findOpenDocument();

//	@Query(value = "select * from ORDR")
//	List<BmoOJDT> findWithUDF();
   /* @Override
    default public void customize(QuerydslBindings bindings, QBmoORDR root) {
        bindings.bind(String.class)
        .first((StringPath path, String  value) -> path.containsIgnoreCase(value));
    }*/
}
