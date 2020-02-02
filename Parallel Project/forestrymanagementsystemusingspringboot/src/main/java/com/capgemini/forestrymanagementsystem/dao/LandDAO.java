package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;
import com.capgemini.forestrymanagementsystem.dto.LandBean;

public interface LandDAO {
	public boolean addLand(LandBean land);
	public boolean deleteLand(int landId);
	public List<LandBean> getAllLand();
	public boolean modifyLand(int landId,LandBean land);
	public LandBean getLand(int landId);
}
