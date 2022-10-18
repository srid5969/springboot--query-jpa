package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.company.model.Company;
import com.javatpoint.company.repository.CompanyRepository;
import com.javatpoint.user.model.User;
import com.javatpoint.user.repository.UserRepository;

@Service
public class CommonService {
	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	private UserRepository userRepository;

	public List<Company> queryList() {
		return companyRepository.allCompany();
	}

	public List<Company> getIdUsingQuery(int id) {
		return companyRepository.getIdUsingQuery(id);
	}

	public List<Company> getCampanyDetailsUsingComapyName(String name) {
		return companyRepository.getAllCompanyWithNAme(name);
	}

	public List<Company> getCompanyBYNAmeAndAddress(String name, String Address, int id) {
		return companyRepository.getCompanyByNameAndByAddress(name, Address, id);
	}

	public List<Company> companyAddressLikeA(String address) {
		return companyRepository.companyAddressLike(address);
	}

//	transaction
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List getAllUserAndCompany() {
		List newlist = new ArrayList<>();
		newlist.add(getAllCompany());
		newlist.add(getAllUsers());
		return newlist;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List getUserAndCompanyById(int id) {
		List list = new ArrayList<>();
		list.add(getCompanyById(id));
		list.add(getUserById(id));
		return list;
	}

	@Transactional
	public String updateTwoDb(Company company, User user) {
		updateCompany(company);
		updateUser(user);
		return "Successfully added";
	}

	public String deleteCompanyAndUserById(int id) {
		deleteCompany(id);
		deleteUserById(id);
		return "Successfully deleted ";
	}

	public List<Company> getAllCompany() {
		List<Company> company = new ArrayList<Company>();
		companyRepository.findAll().forEach(company1 -> company.add(company1));
		return company;
	}

	public Company getCompanyById(int id) {
		return companyRepository.findById(id).get();
	}

	public void saveOrUpdateCompany(Company company) {
		companyRepository.save(company);
	}

	public void deleteCompany(int id) {
		companyRepository.deleteById(id);
	}

	public void updateCompany(Company company) {
		companyRepository.save(company);
	}

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public void saveOrUpdateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

}
