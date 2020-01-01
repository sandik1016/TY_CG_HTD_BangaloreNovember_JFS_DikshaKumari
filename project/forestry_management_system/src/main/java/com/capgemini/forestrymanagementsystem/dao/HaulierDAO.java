package com.capgemini.forestrymanagementsystem.dao;

import java.util.Map;
import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.HaulierBean;
import com.capgemini.forestrymanagementsystem.bean.LandBean;
import com.capgemini.forestrymanagementsystem.exception.HaulierIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;

public interface HaulierDAO {
	public boolean addHaulier(HaulierBean haul);
	public boolean deleteHaulier(int hid, Map<Integer,Set<HaulierBean>> haul) throws HaulierIdNotFoundException;
    public Set<HaulierBean> getAllHaulier();
	public boolean updateHaulier(int hid, Map<Integer,Set<HaulierBean>> haul) throws HaulierIdNotFoundException;
	public boolean searchHaulier(int hid, Map<Integer,Set<HaulierBean>> haul) throws HaulierIdNotFoundException;
	
}
