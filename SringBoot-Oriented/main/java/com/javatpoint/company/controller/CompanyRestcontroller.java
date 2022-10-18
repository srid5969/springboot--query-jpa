package com.javatpoint.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.company.model.Company;
import com.javatpoint.company.service.CompanyService;

@RestController
/*
===============================================================================
@RestController annotation is a special controller used in RESTful Web services,
 	and it’s the combination of @Controller and @ResponseBody annotation.
 	
It is a specialized version of @Controller annotation.

In @RestController, we can not return a view.

@RestController annotation indicates that class is a controller
 	where @RequestMapping methods assume @ResponseBody semantics by default.
 	
In @RestController, we don’t need to use @ResponseBody on every handler method.

It was added to Spring 4.0 version.
================================================================================
*/

public class CompanyRestcontroller {

	@Autowired
	CompanyService companyService;
	
	

	@GetMapping("/company")
	private List<Company> getAllCompany() {
		return companyService.getAllCompany();
	}

	@GetMapping("/company/{companyid}")
	public Company getCompanys(@PathVariable("companyid") int companyid) {
		return companyService.getCompanyById(companyid);
	}

	@DeleteMapping("/company/{companyid}")
	public void deleteCompany(@PathVariable("companyid") int companyid) {
		companyService.delete(companyid);
	}

	@PostMapping("/company/post")
	public int saveCompany(@RequestBody Company company) {
		companyService.saveOrUpdate(company);
		return company.getId();
	}

	@PutMapping("/company/put")
	public Company update(@RequestBody Company company) {
		companyService.saveOrUpdate(company);
		return company;
	}

}