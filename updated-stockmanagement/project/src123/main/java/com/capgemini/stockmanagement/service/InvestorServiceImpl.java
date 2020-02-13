package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.CompanyDAO;
import com.capgemini.stockmanagement.dao.InvestorDAO;
import com.capgemini.stockmanagement.dao.UserDAO;
import com.capgemini.stockmanagement.dto.InvestorRequestObject;
import com.capgemini.stockmanagement.dto.Investor_Share;
import com.capgemini.stockmanagement.exception.ValidationException;
import com.capgemini.stockmanagement.util.Validation;

@Service
public class InvestorServiceImpl implements InvestorService{
	@Autowired
	InvestorDAO dao;
	@Autowired
	UserDAO userDao;
	@Autowired
	CompanyDAO companyDao;

	@Override
	public boolean addShare(InvestorRequestObject investor) {
		Validation v = new Validation();
		String companyId = investor.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			investor.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
//		if(userDao.getUser(investor.getUserId()) != null ||
//	    		 companyDao.getCompany(investor.getCompanyId()) != null){
//	     }
//		 else {
//			 throw new ValidationException("This id doesn't exists");
//		 }
			 return dao.addShare(investor);
	}

	@Override
	public boolean buyShare(InvestorRequestObject investor) {

		return dao.buyShare(investor);
	}
	@Override
	public boolean sellShare(InvestorRequestObject investor) {

		return dao.sellShare(investor);
	}

	@Override
	public boolean updateStockAvailability(InvestorRequestObject investor, boolean flag) {
		Validation v = new Validation();
		String companyId = investor.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			investor.setCompanyId(companyId);
		}
		else {
			throw new ValidationException("Enter id in this format (example :TS-01)");
		}
		return dao.updateStockAvailability(investor, flag);
	}

	@Override
	public List<Investor_Share> getAllInvestors(int userId) {
		
		return dao.getAllInvestors(userId);
	}

}

