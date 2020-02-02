package com.capgemini.forestrymanagementsystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.dto.ProductBean;
import com.capgemini.forestrymanagementsystem.exception.ProductException;
import com.capgemini.forestrymanagementsystem.util.Validation;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    private ProductDAO productDao;
	@Override
	public boolean addProduct(ProductBean product) {
		Validation v = new Validation();
		String name = product.getProductName();
			if(v.nameValidation(name)) {
				product.setProductName(name);
			}else{
				throw new ProductException("Only alphabets allowed..enter valid one");
			}			
		return productDao.addProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		
		return productDao.deleteProduct(productId);
	}

	@Override
	public List<ProductBean> getAllProduct() {
		
		return productDao.getAllProduct();
	}

	@Override
	public boolean modifyProduct(int productId, ProductBean product) {
		Validation v = new Validation();
		String name = product.getProductName();
			if(v.nameValidation(name)) {
				product.setProductName(name);
			}else{
				throw new ProductException("Only alphabets allowed..enter valid one");
			}	
		return productDao.modifyProduct(productId, product);
	}

	@Override
	public ProductBean getProduct(int productId) {
	
		return productDao.getProduct(productId);
	}

}
