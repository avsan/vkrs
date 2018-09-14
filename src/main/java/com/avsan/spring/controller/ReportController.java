package com.avsan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avsan.spring.bean.ReportBean;

@Controller
public class ReportController {

	@GetMapping("report")
	public ModelAndView createUserView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("report");
	    mav.addObject("report", new ReportBean());
	    //mav.addObject("allProfiles", getProfiles());
	    return mav;
    }
}
