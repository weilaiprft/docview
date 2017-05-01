package com.fsb.docview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fsb.docview.model.DocView;

@RepositoryRestResource(collectionResourceRel = "docview", path = "docview")
public interface DocViewRepository extends PagingAndSortingRepository<DocView, Long> {
	
	List<DocView> findByUserName(@Param("name") String name);
	
	List<DocView> findByLoanNumber(@Param("loannumber") String loannumber);
	
	List<DocView> findByUserNameAndLoanNumber(@Param("username") String username, @Param("loannumber") String loannumber);
	
	@Query("Select d from DocView d where d.userName = 'ivan'")
    public List<DocView> findUsersList();

	List<DocView> findDistinctDocViewByUserNameNotIn(@Param("name") String names);
		
}