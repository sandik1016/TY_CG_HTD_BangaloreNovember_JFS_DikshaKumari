package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.bean.LandBean;
import com.capgemini.forestmanagementsystem.exception.LandException;

public interface LandDAO {
	public boolean deleteLandDetails(int landId) throws LandException;	
	public boolean addLandDetails(LandBean land);
	public List<LandBean> getAllLandDetails();	
	public List<LandBean> searchLandDetails(int landId)throws LandException;		
	public boolean updateLandDetails(int landId,int landValue)throws LandException;

}
