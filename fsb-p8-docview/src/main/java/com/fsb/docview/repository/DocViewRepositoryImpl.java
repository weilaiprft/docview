package com.fsb.docview.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fsb.docview.DocViewController;
import com.fsb.docview.model.DocView;

@EnableAutoConfiguration
public class DocViewRepositoryImpl implements MyCustomRepository {

	@Autowired
	private EntityManager em;
	
	private static final Logger logger = LoggerFactory.getLogger(DocViewRepositoryImpl.class);
	
	@Override
	public List<String> getDistinctUsers() {
		// TODO Auto-generated method stub
		logger.info("here's my custom imp");
		
		try {
			Query query = em.createQuery("Select DISTINCT(d.userName) from DocView d");
			List<String> list = query.getResultList();
			
			List<DocView> userList = new ArrayList<DocView>();
												
			for (String e : list) {
				logger.info("user = " + e);
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}		
	}

}
