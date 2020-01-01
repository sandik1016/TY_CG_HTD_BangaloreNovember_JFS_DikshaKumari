package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import com.capgemini.forestrymanagementsystem.bean.ContractorBean;
import com.capgemini.forestrymanagementsystem.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystem.factory.Factory;



public class ContractorServicesImpl implements ContractorServices {
	ContractorDAO dao1 = Factory.instanceOfContractorDAOImpl();
	@Override
	public List<ContractorBean> getAllContractor() {
		return dao1.getAllContractor();
	}

	@Override
	public boolean updateContractor(int cid, ContractorBean contractorUpdate) {
		return dao1.updateContractor(cid, contractorUpdate);
	}

	@Override
	public boolean deleteContractor(int contractorDelete) {
		return dao1.deleteContractor(contractorDelete); 
	}

	@Override
	public boolean addContractor(ContractorBean contractor) {
		return dao1.addContractor(contractor);
	}

	@Override
	public ContractorBean searchContractor(int cid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
