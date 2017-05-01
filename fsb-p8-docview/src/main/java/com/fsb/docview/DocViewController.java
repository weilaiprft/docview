package com.fsb.docview;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fsb.docview.repository.PersonRepository;

//@RestController
//@EnableAutoConfiguration
@Controller
public class DocViewController {
	@Autowired
	private PersonRepository personRepository;

	private static final Logger logger = LoggerFactory.getLogger(DocViewController.class);

	@RequestMapping("/greeting")
	public ModelAndView greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		ModelAndView modelAndView = new ModelAndView("greeting");
		modelAndView.addObject("name", name);

		return modelAndView;
	}
	
	@GetMapping("/dvdashboard")
	public ModelAndView getDVDashboard(){
		logger.info("dv dashboard...");
		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("loanNumber", "");
		return modelAndView;
	}

	@RequestMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getHome() {
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

	// this is get to load the initial page for user to entery parameters
    @GetMapping("/taskslist")
    public String getTaskslist(final Model model)
    {
        // check the cache date, refresh stored cached value if it's > 1 day
        /*
         * web server gets rebooted every night, so this is prob not necessary if
         * (LocalDateTime.now().isAfter(cachedDate.plusDays(1))) { logger.info("reset cached wob");
         * vwp.setCachedWorkItemVObyFolderGUID(new HashMap<String, WorkItemVO>()); this.cachedDate =
         * LocalDateTime.now(); }
         */

        // initialize param from CM_PROPERTIES, pull DS from jboss

        //logger.info("do we have url? " + tasksListProperties.getUri());
    	logger.info("get task list");
        /*-
        if (tasksListProperties.getUri().equals(""))
        {
            try
            {
                logger.info("do db lookup for param values");
                tasksListProperties = dataSourceHelper.doDataSourceLookup(tasksListProperties);
            }
            catch (SQLException e)
            { // TODO Auto-generated catch block
                logger.error(e.getMessage());
                // TODO: need to return an error page
            }
        }
        */

        model.addAttribute("loanNumber", "12345");
        return "dashboard";
    }
	
}
