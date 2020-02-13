package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.Company;

import junit.framework.TestCase;

@SpringBootTest
class CompanyDAOTest {

	@Autowired
	private CompanyDAO dao;
	private Company company = new Company();

	@Test
	void testAddCompany() {
		try {
			Company company = new Company();
			company.setCompanyId("1");
			company.setCompanyName("CapGemini");
			company.setTotalQuantity(10000);
			company.setStockAvailability(5000);
			boolean result = dao.addCompany(company);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addCompany(company);
			});
		}
	}

	

	

	@Test
	void testGetAllCompanies() {
		List<Company> companies = dao.getAllCompanies();
		TestCase.assertNotNull(companies);
	}

	
}
