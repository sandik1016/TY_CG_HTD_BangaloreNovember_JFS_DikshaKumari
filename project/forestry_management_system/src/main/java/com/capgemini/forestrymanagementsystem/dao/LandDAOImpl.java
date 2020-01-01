package com.capgemini.forestrymanagementsystem.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.capgemini.forestrymanagementsystem.bean.ContractBean;
import com.capgemini.forestrymanagementsystem.bean.LandBean;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;

public class LandDAOImpl implements LandDAO{
	Set<LandBean> s;
	LandBean bean =new LandBean();
	@Override
	public Set<LandBean> getAllLand() {
		
		return s;
	}

	@Override
	public boolean updateLand(int lid, Map<Integer, Set<LandBean>> landBean) throws LandIdNotFoundException {
		if(lid < 0)
		{
			throw new LandIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Entry<Integer,Set<LandBean>>> s1 = landBean.entrySet();
		for(Entry<Integer,Set<LandBean>> e1:s1) {
			if(e1.getKey()==lid) {
		
		return true;
	}
	}
		}
		return false;
	}

	@Override
	public boolean deleteLand(int lid, Map<Integer, Set<LandBean>> landBean) throws LandIdNotFoundException {
		if(lid < 0)
		{
			throw new LandIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Entry<Integer,Set<LandBean>>> s1 = landBean.entrySet();
		for(Entry<Integer,Set<LandBean>> e1:s1) {
			if(e1.getKey()==lid) {
		
		return true;
	}
		}
		}
		return false;
		
	}

	@Override
	public boolean addLand(LandBean land) {
		s= new HashSet<LandBean>();
		s.add(land);
		return true;
	}

	@Override
	public boolean searchLand(int lid, Map<Integer, Set<LandBean>> landBean) throws LandIdNotFoundException {
		if(lid < 0)
		{
			throw new LandIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Entry<Integer,Set<LandBean>>> s1 = landBean.entrySet();
		for(Entry<Integer,Set<LandBean>> e1:s1) {
			if(e1.getKey()==lid) {
		
		return true;
	}
		}
	}
	return false;
	}

}
