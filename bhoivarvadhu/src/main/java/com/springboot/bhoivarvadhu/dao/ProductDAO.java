package com.springboot.bhoivarvadhu.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dto.ClientProducts;
import com.springboot.bhoivarvadhu.dto.OurProducts;

@Service
public interface ProductDAO {

	// Our Product 
	
	OurProducts getid(int id);

	boolean addOurProducts(OurProducts ourProducts);

	boolean update(OurProducts ourProducts);

	 
	boolean deleteOurProducts(int id);

	List<OurProducts> getAllOurProducts(int start);

//	List<OurProducts> getAllOurProducts();
//	List<OurProducts> getAllOurProducts1();
	
	long getOurProductCount();
	

	List<OurProducts> getOurProductbyID(int id);
 
 
	// Client Products
	
	ClientProducts getbyId(int id);

	boolean addClientProducts(ClientProducts clientProducts);

	boolean updateClientProducts(ClientProducts clientProducts);

	boolean deleteClientProducts(ClientProducts clientProducts);

	List<ClientProducts> getAllCLientproducts();

	List<ClientProducts> getClientproductbyID(int id);

 	
}
