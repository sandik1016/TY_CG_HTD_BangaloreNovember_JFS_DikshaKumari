package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import com.capgemini.forestrymanagementsystem.bean.ContractorBean;

public interface ContractorServices {
	public List<ContractorBean> getAllContractor();
	public boolean updateContractor(int cid,ContractorBean contractorupdate);
	public boolean deleteContractor(int contractorDelete);
	public boolean addContractor(ContractorBean contractor);
	public ContractorBean searchContractor(int cid);

}
