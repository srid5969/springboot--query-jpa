package com.javatpoint.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.company.model.Company;
import com.javatpoint.service.CommonService;

@RestController
@RequestMapping("/query")

public class CompanysQueryController {
	@Autowired
	CommonService service;

	@GetMapping("/get")
	public List<Company> listQuery() {
		return service.queryList();
	}

	@GetMapping("/get/id")
	public List<Company> getCompanyBYIdUsingParams(@RequestParam(name = "id") int id) {
		return service.getIdUsingQuery(id);
	}

	@GetMapping("/get/name")
	public List<Company> getCompanyByName(@RequestParam(name = "name") String name) {
		return service.getCampanyDetailsUsingComapyName(name);
	}
	
	
	@GetMapping("/get/by")
	public List<Company> getCompanyBYNAmeAndAddress
			(@RequestParam(value = "name") String name
			,@RequestParam(value = "address") String address,
			 @RequestParam(value = "id") int id){
		return service.getCompanyBYNAmeAndAddress(name, address,id);
	}
	
	
	@GetMapping("/get/address/like")
	public List<Company> companyAddressLike(@RequestParam(value = "address") String address){
		return service.companyAddressLikeA(address);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
