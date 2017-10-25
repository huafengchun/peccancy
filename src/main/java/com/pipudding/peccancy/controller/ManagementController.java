package com.pipudding.peccancy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pipudding.peccancy.service.WeixinService;
import com.pipudding.peccancy.utils.EventListType;
import com.pipudding.peccancy.utils.EventShowType;
import com.pipudding.peccancy.utils.UserInfoType;

@Controller
@RequestMapping("/manage") 
public class ManagementController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	WeixinService weixinService;
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)  
    public String login() {
        return "login"; 
    }
	
	@RequestMapping(value = "/event_detail/{eventId}",method=RequestMethod.GET)  
    public String eventDetail(@PathVariable String eventId, Model model) { 
		EventShowType eventShow = weixinService.getEvent(eventId);
		model.addAttribute("event", eventShow);
        return "event_detail";  
    }
	
	@RequestMapping(value = "/event_table",method=RequestMethod.GET)  
    public String eventTable(Model model) { 
		List<EventListType> eventList = weixinService.getEventList();
		model.addAttribute("eventList", eventList);
        return "event_table";  
    }
	
	@RequestMapping(value = "/type_management",method=RequestMethod.GET)  
    public String typeManagerment() {  
        return "type_management";  
    }
	
	@RequestMapping(value = "/flow_management",method=RequestMethod.GET)  
    public String flowManagement(Model model) { 
		List<String> flowInfos = weixinService.getFlowInfo();
		model.addAttribute("flows", flowInfos);
        return "flow_management";  
    }
	
	@RequestMapping(value = "/user_table",method=RequestMethod.GET)  
    public String userTable(Model model) {
		List<UserInfoType> userList = weixinService.getUser();
		model.addAttribute("userList", userList);
        return "user_table";  
    }
}