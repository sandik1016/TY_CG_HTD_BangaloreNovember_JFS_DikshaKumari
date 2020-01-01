package com.capgemini.forestrymanagementsystem.dao;

import java.util.Map;

import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.ContractBean;
import com.capgemini.forestrymanagementsystem.bean.LandBean;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;

public interface LandDAO {
	public Set<LandBean> getAllLand();
	public boolean updateLand(int lid, Map<Integer,Set<LandBean>> landBean) throws LandIdNotFoundException;
	public boolean deleteLand(int lid, Map<Integer,Set<LandBean>> landBean) throws LandIdNotFoundException;
	public boolean addLand(LandBean land);
	public boolean searchLand(int lid, Map<Integer,Set<LandBean>> landBean) throws LandIdNotFoundException;

}
