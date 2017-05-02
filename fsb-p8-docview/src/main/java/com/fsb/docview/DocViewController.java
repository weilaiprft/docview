package com.fsb.docview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsb.docview.model.DocView;
import com.fsb.docview.repository.PersonRepository;

//@RestController
//@EnableAutoConfiguration
@Controller
public class DocViewController {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(DocViewController.class);

	@RequestMapping(value = "/keepalive.jsp", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String keepAlive() {
		return "keep alive page";
	}

	@RequestMapping(value = "/service/getuniqueusers", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DocView> getUniqueUsers() {
		logger.info("dash/service/getuniqueusers API request received");


		try {
			Query query = em.createQuery("Select DISTINCT(d.userName) from DocView d");
			List<String> list = query.getResultList();
			
			List<DocView> userList = new ArrayList<DocView>();
												
			for (String e : list) {
				DocView dv = new DocView();
				dv.setUserName(e);
				userList.add(dv);
			}
			return userList;
		} catch (Exception e) {
			return null;
		}
	}

	
	@RequestMapping(value = "/service/getuniqueuloans", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getUniqueLoans() {
		logger.info("dash/service/getuniqueusers API request received");


		try {
			Query query = em.createQuery("Select DISTINCT(d.loanNumber) from DocView d");
			List<String> list = query.getResultList();
			
			
			for (String e : list) {
				System.out.println("user name :" + e);
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@RequestMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> getHome() {
		logger.info("Api request received");

		Map<String, String> response = new HashMap<String, String>();
		try {
			response.put("count", String.valueOf(personRepository.count()));
		} catch (Exception e) {
			logger.error("Error occurred while trying to process api request", e);
			response.put("status", "fail");
		}

		return response;
	}

}
