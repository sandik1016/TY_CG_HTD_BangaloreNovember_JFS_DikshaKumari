package com.capgemini.forestrymanagementsystem.service;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.forestrymanagementsystem.dao.LandDAO;
import com.capgemini.forestrymanagementsystem.dto.LandBean;
import com.capgemini.forestrymanagementsystem.exception.LandException;
import com.capgemini.forestrymanagementsystem.util.Validation;
@Service
public class LandServiceImpl implements LandService{
	@Autowired
    private LandDAO landDao;
	@Override
	public boolean addLand(LandBean land) {
		Validation v = new Validation();
		String location = land.getLandLocation();
			if(v.addressValidation(location)) {
				land.setLandLocation(location);
			}else{
				throw new LandException("Enter valid address");
			}
			String date = land.getAcquiredDate();
			try {
				if(v.dateValidation(date)) {
					land.setAcquiredDate(date);
				}else{
					throw new LandException("Enter valid date.. only present and future date allowed");
				}
			} catch (ParseException e) {
				throw new LandException("Enter valid date.. only present and future date allowed");
			}
		
		return landDao.addLand(land);
	}

	@Override
	public boolean deleteLand(int landId) {
	
		return landDao.deleteLand(landId);
	}

	@Override
	public List<LandBean> getAllLand() {
		
		return landDao.getAllLand();
	}

	@Override
	public boolean modifyLand(int landId, LandBean land) {
		Validation v = new Validation();
		String location = land.getLandLocation();
		
			if(v.addressValidation(location)) {
				land.setLandLocation(location);
			}else{
				throw new LandException("Enter valid address");
			}
			String date = land.getAcquiredDate();
			try {
				if(v.dateValidation(date)) {
					land.setAcquiredDate(date);
				}else{
					throw new LandException("Enter valid date.. only present and future date allowed");
				}
			} catch (ParseException e) {
				throw new LandException("Enter valid date.. only present and future date allowed");
			}
		return landDao.modifyLand(landId, land);
	}

	@Override
	public LandBean getLand(int landId) {
		
		return landDao.getLand(landId);
	}

}
