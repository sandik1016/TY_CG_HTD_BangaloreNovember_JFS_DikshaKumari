package com.capgemini.forestrymanagementsystem.dao;
import java.util.List;

import com.capgemini.forestrymanagementsystem.bean.ContractorBean;
public interface ContractorDAO {
	public List<ContractorBean> getAllContractor();
	public boolean updateContractor(int cid,ContractorBean contractorUpdate);
	public boolean deleteContractor(int contractorDelete);
	public boolean addContractor(ContractorBean contractor);
	public ContractorBean searchContractor(int cid);

}

//public boolean updateUser(int userid,String password,String email);
//public boolean insertUser(UserBean user);
//public boolean deleteUser(int userid,String password);
