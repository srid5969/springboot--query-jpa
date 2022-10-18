package com.javatpoint.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javatpoint.company.model.Company;
import com.javatpoint.company.service.CompanyService;

@Controller
@RequestMapping("/normal")
/*
==========================================================================================


@Controller is used to mark classes as Spring MVC Controller.

It is a specialized version of @Component annotation.

In @Controller, we can return a view in Spring Web MVC.

@Controller annotation indicates that the class is a “controller” like a web controller.

In @Controller, we need to use @ResponseBody on every handler method.

It was added to Spring 2.5 version.

==========================================================================================
*/

public class NormalController {

	@Autowired
	CompanyService companyService;

	@GetMapping("/sample")
	@ResponseBody
	public String returnFrom() {
		return "The normal controllers formate";
	}

	@RequestMapping(value = "/responce", method = RequestMethod.GET)
	@ResponseBody
	public List<Company> sd() {
		return companyService.getAllCompany();
	}

	@RequestMapping(value = "/company/id/value", method = RequestMethod.GET)
	@ResponseBody
	public Company getByCompanyIdInNormalcontroller(@RequestParam(name = "id") int id) {
		return companyService.getCompanyById(id);
	}

}
