package com.fsb.docview;


import java.sql.SQLException;
// java 8
//import java.time.LocalDateTime;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController
{


    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    
    // private LocalDateTime cachedDate = LocalDateTime.now();

    public TestController()
    {
        logger.info("Starting Task Controller");
    }

    // this is get to load the initial page for user to entery parameters
    @GetMapping("/taskslist2")
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

        model.addAttribute("loanNumber", "123");
        return "dashboard";
    }

    /*-

    // this is the post to get the params and
    @PostMapping("/taskslist")
    public String postTaskslist(
            @RequestParam(value = "loanNumber", required = false, defaultValue = "602794985") final String loanNumber,
            final Model model)
    {
        List<WorkItemVO> wvos = vwProcessor.getListOfTasks(loanNumber, peComponent, ceComponent, tasksListProperties);
        logger.info("there are " + wvos.size() + " tasks returned");
        model.addAttribute("workitems", wvos);
        model.addAttribute("taskrequest", new TasksListRequestVO(loanNumber.trim()));
        return "taskslist";
    }  
    */

}