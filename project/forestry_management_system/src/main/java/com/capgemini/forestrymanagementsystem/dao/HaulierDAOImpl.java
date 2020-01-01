package com.capgemini.forestrymanagementsystem.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.bean.HaulierBean;
import com.capgemini.forestrymanagementsystem.exception.HaulierIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;

public class HaulierDAOImpl implements HaulierDAO{

	Set<HaulierBean> s;

	@Override
	public boolean deleteHaulier(int hid, Map<Integer, Set<HaulierBean>> haul) throws HaulierIdNotFoundException {
		if(hid < 0)
		{
			throw new HaulierIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Entry<Integer,Set<HaulierBean>>> s1 = haul.entrySet();
		for(Entry<Integer,Set<HaulierBean>> e1:s1) {
			if(e1.getKey()==hid) {

				return true;
			}
		}
		}
		return false;
	}

	@Override
	public Set<HaulierBean> getAllHaulier() {
		
		return s; 
	}

	
	@Override
	public boolean addHaulier(HaulierBean haul) {
		s= new HashSet<HaulierBean>();
		s.add(haul);
		return true;
		
	}

	@Override
	public boolean updateHaulier(int hid, Map<Integer, Set<HaulierBean>> haul) throws HaulierIdNotFoundException {
		if(hid < 0)
		{
			throw new HaulierIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Entry<Integer,Set<HaulierBean>>> s1 = haul.entrySet();
		for(Entry<Integer,Set<HaulierBean>> e1:s1) {
			if(e1.getKey()==hid) {

				return true;
			}
		}
	}
		return false;
		
	}

	@Override
	public boolean searchHaulier(int hid, Map<Integer, Set<HaulierBean>> haul) throws HaulierIdNotFoundException {
		if(hid < 0)
		{
			throw new HaulierIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Entry<Integer,Set<HaulierBean>>> s1 = haul.entrySet();
		for(Entry<Integer,Set<HaulierBean>> e1:s1) {
			if(e1.getKey()==hid) {

				return true;
			}
		}
	}
		return false;
		
	}

}
