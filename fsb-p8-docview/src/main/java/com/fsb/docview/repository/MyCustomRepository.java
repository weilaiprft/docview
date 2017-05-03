package com.fsb.docview.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.fsb.docview.model.DocView;

@NoRepositoryBean
public interface MyCustomRepository extends Repository<DocView, Long> {
	
	List<String> getDistinctUsers();

}
