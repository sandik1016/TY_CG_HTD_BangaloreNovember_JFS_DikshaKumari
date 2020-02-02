package com.capgemini.stockmanagement.dao;

import java.util.List;

import com.capgemini.stockmanagement.dto.Company;

public interface CompanyDAO {

	boolean addCompany(Company company);

	boolean deleteCompany(String companyId);

	boolean updateCompany(String companyId, Company company);

	List<Company> getAllCompanies();

	Company getCompany(String companyId);
}
