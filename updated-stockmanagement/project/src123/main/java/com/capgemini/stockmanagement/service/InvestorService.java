package com.capgemini.stockmanagement.service;

import java.util.List;

import com.capgemini.stockmanagement.dto.InvestorRequestObject;
import com.capgemini.stockmanagement.dto.Investor_Share;

public interface InvestorService {
	boolean addShare(InvestorRequestObject investor);

	boolean buyShare(InvestorRequestObject investor);

	boolean sellShare(InvestorRequestObject investor);

	boolean updateStockAvailability(InvestorRequestObject investor, boolean flag);

	List<Investor_Share> getAllInvestors(int userId);
}
