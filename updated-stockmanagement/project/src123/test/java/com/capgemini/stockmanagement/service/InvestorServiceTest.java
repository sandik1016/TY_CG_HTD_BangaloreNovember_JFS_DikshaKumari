package com.capgemini.stockmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.InvestorRequestObject;
import com.capgemini.stockmanagement.dto.Investor_Share;

@SpringBootTest
public class InvestorServiceTest {

	@Autowired
	private InvestorService service;
	private InvestorRequestObject req;
	
	@Test
	void testAddShare() {
		try {
			Investor_Share share = new Investor_Share();
			share.setUserId(1);
			share.setCompanyId("HU-87");
			share.setShareId(2);
			share.setAvailableAmount(45876);
			share.setAvailableShares(5442);
			share.setTotalAmountBought(3000);
			share.setTotalAmountSold(235.50);
			share.setTotalSharesBought(2500);
			boolean result = service.addShare(req);
	        assertEquals(result, true);
		}catch(Exception e) {
			assertThrows(Exception.class, () -> {
				service.addShare(req);
			});
		}
	}
	
}
