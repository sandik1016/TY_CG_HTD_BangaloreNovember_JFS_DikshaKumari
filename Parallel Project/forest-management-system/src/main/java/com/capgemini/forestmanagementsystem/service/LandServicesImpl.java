package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.LandBean;
import com.capgemini.forestmanagementsystem.dao.LandDAO;
import com.capgemini.forestmanagementsystem.exception.LandException;

public class LandServicesImpl implements LandServices{
LandDAO dao=Factory.landDAOInstance();

	
	public boolean deleteLandDetails(int landId) throws LandException {
		
		return dao.deleteLandDetails(landId);
	}

	@Override
	public boolean addLandDetails(LandBean land) {
	
		return dao.addLandDetails(land);
	}

	@Override
	public List<LandBean> getAllLandDetails() {
		
		return dao.getAllLandDetails();
	}

	@Override
	public boolean updateLandDetails(int landId, int landValue) throws LandException {
		
		return dao.updateLandDetails(landId, landValue);
	}

	@Override
	public List<LandBean> searchLandDetails(int landId) throws LandException {
		
		return dao.searchLandDetails(landId);
	}

}
