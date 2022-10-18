package com.javatpoint.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.company.model.Company;
import com.javatpoint.service.CommonService;
import com.javatpoint.user.model.User;

@RestController
@RequestMapping("/test")
public class TransactionController {
	@Autowired
	private CommonService service;

	@PostMapping("/post")
	public String postTwoDatas(@RequestParam(name = "cid") int cid, @RequestParam(name = "uid") int uid) {
		Company company = new Company();
		company.setId(cid);

		User user = new User();
		user.setId(uid);
		long a = 90643500000l;
		company.setPhone(a);
		company.setAddress("Chennai");
		company.setComapny_name("innovix");
		company.setEmail_id("demo" + "@gmail.com");
		System.out.println(company.toString());
		user.setPhone(a);
		user.setAddress("Chennai");
		user.setEmail_id("demo@innovix.com");
		user.setUser_name("demo");
		System.out.println(user.toString());
		return service.updateTwoDb(company, user);
	}

	@GetMapping("/get/id{id}")
	public List getDetailsByid(@PathVariable("id") int id) {
		return service.getUserAndCompanyById(id);
	}

	@DeleteMapping("/delete/id{id}")
	public String deleteComUser(@PathVariable("id") int id) {
		Company company = new Company();
		System.out.println(company.toString());
		return service.deleteCompanyAndUserById(id);
	}

}
