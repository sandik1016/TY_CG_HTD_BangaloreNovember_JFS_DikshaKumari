package com.capgemini.retailermaintenancesystemapplicationdevelopment.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.dao.OrderDAO;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.OrderBean;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDao;

	@Override
	public boolean addOrder(OrderBean orderBean) {
		return orderDao.addOrder(orderBean);
	}

	@Override
	public OrderBean getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	@Override
	public List<OrderBean> getAllOrders() {
		return orderDao.getAllOrders();
	}

}
