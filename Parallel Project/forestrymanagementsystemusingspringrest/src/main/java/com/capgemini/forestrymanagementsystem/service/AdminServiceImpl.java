
package com.capgemini.forestrymanagementsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.forestrymanagementsystem.dao.AdminDAO;
import com.capgemini.forestrymanagementsystem.dto.UserBean;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
    private AdminDAO userDao;
	
	@Override
	public boolean clientRegister(UserBean clientBean) {

		return userDao.clientRegister(clientBean);
	}

	@Override
	public boolean schedulerRegister(UserBean schedulerBean) {

		return userDao.schedulerRegister(schedulerBean);
	}

	@Override
	public boolean removeClient(int id) {
		
		return userDao.removeClient(id);
	}

	@Override
	public List<UserBean> showClients() {
		
		return userDao.showClients();
	}

	@Override
	public boolean removeScheduler(int id) {
		
		return userDao.removeScheduler(id);
	}

	@Override
	public List<UserBean> showScheduler() {
		
		return userDao.showScheduler();
	}

	@Override
	public boolean changePassword(int id, String password) {
		
		return userDao.changePassword(id, password);
	}

}
