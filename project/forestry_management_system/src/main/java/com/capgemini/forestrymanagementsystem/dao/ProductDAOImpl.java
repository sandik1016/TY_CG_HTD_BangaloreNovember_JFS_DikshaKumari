package com.capgemini.forestrymanagementsystem.dao;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.ProductBean;
import com.capgemini.forestrymanagementsystem.exception.HaulierIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;

import java.util.Map.Entry;



public class ProductDAOImpl implements ProductDAO {
	
	Set<ProductBean> s;
	ProductBean bean =new ProductBean();
	
		@Override
		public Set<ProductBean> getAllProduct() {
			return s;
		}

		@Override
		public boolean updateProduct(int pid, Map<Integer, Set<ProductBean>> productBean) throws ProductIdNotFoundException {
			if(pid < 0)
			{
				throw new ProductIdNotFoundException(" inserted id is invalid");
			}else {
			Set<Entry<Integer,Set<ProductBean>>> s1 = productBean.entrySet();
			for(Entry<Integer,Set<ProductBean>> e1:s1) {
				if(e1.getKey()==pid) {
			
			return true;
		}
		}}
			return false;
		}

		@Override
		public boolean deleteProduct(int pid, Map<Integer, Set<ProductBean>> productBean) throws ProductIdNotFoundException {
			if(pid < 0)
			{
				throw new ProductIdNotFoundException(" inserted id is invalid");
			}else {
			Set<Entry<Integer,Set<ProductBean>>> s1 = productBean.entrySet();
			for(Entry<Integer,Set<ProductBean>> e1:s1) {
				if(e1.getKey()==pid) {
			
			return true;
		}
			}
			}
			return false;
		}

		@Override
		public boolean addProduct(ProductBean product) {
			s= new HashSet<ProductBean>();
			if(product.getPid()==bean.getPid()) {
			return false;
			}
			s.add(product);
			return true;
		}

		@Override
		public boolean searchProduct(int pid, Map<Integer, Set<ProductBean>> productBean) throws ProductIdNotFoundException {
			if(pid < 0)
			{
				throw new ProductIdNotFoundException(" inserted id is invalid");
			}else {
			Set<Entry<Integer,Set<ProductBean>>> s1 = productBean.entrySet();
			for(Entry<Integer,Set<ProductBean>> e1:s1) {
				if(e1.getKey()==pid) {
			
			return true;
		}
			}
			}
			return false;
		}

	
		
			}


