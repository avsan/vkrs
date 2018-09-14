package com.avsan.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avsan.spring.bean.DailyTripDetailsBean;
import com.avsan.spring.bean.InsuranceBean;
import com.avsan.spring.pojo.InsurancePojo;
import com.avsan.spring.service.InsurenceService;

@Controller
@RequestMapping(value = { "/insurence" })
public class InsurenceController {
	@Autowired
	private InsurenceService insurenceService;
	@GetMapping("addInsurence")
	public ModelAndView createUserView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("createInsurence");
		mav.addObject("insuranceBean", new InsuranceBean());
		// mav.addObject("allProfiles", getProfiles());
		return mav;
	}

	@PostMapping("addInsurence")
	public ModelAndView createUser(@Valid InsuranceBean insuranceBean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		/*if (result.hasErrors()) {

			mav.setViewName("insuranceBean");
			// mav.addObject("dailyTripDetailsBean", new DailyTripDetailsBean());
			return mav;
		}*/
		InsurancePojo insurencePojo=new InsurancePojo();
		insurencePojo.setCertificateNumber(insuranceBean.getCertificateNumber());
		insurencePojo.setCertificateType(insuranceBean.getCertificateType());
		insurencePojo.setInsuranceCompany(insuranceBean.getInsuranceCompany());
		insurencePojo.setInsuranceId(insuranceBean.getInsuranceId());
		insurencePojo.setPremiumPaid(insuranceBean.getPremiumPaid());
		insurencePojo.setRenewalDate(insuranceBean.getRenewalDate());
		insurencePojo.setValidFrom(insuranceBean.getValidFrom());
		insurencePojo.setValidTo(insuranceBean.getValidTo());
		insurenceService.createInsurence(insurencePojo);
		mav.setViewName("user-info");
		return mav;
	}

	
}
