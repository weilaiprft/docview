package com.fsb.docview.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.fsb.docview.model.DocView;

@NoRepositoryBean
public interface MyCustomRepository extends Repository<DocView, Long> {
	
	// NOTE: this was added as a custom interface was because DocViewRepo returns DocView entities
	// we just want a list of userid in this case
	List<String> getDistinctUsers();

}
