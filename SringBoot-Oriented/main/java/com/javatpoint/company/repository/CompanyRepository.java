package com.javatpoint.company.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javatpoint.company.model.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>
{
	
	
	@Query(value = "SELECT * FROM company_details",nativeQuery=true)
	public List<Company> allCompany();
	
	
	@Query(value = "SELECT * FROM company_details WHERE id = :id",nativeQuery=true)
	public List<Company> getIdUsingQuery(int id);
	
	
	@Query(value = "SELECT * FROM company_details WHERE company_name =:name ",nativeQuery = true)
	public List<Company> getAllCompanyWithNAme(String name);
	
	@Query(value = "SELECT * FROM company_details where company_name=:name AND address=:address and id=:id",nativeQuery = true)
	public List<Company> getCompanyByNameAndByAddress(String name,String address,int id);
	
	
	@Query(value = "select * from company_details WHERE address like %:address%",nativeQuery = true)
	public List<Company>  companyAddressLike(@Param("address") String address);
	
	
	
	
}
