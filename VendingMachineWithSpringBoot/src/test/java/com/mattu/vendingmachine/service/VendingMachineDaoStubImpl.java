package com.mattu.vendingmachine.service;

import com.tania.vendingmachine.dao.VendingMachineDao;
import com.tania.vendingmachine.dto.Product;
import com.tania.vendingmachine.service.VendingMachinePersistenceException;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachineDaoStubImpl implements VendingMachineDao {
   
	public final String PRODUCTS_FILE;
    public Product testProduct; 
    public Product testProduct2; 
    private Map<String, Product> products = new HashMap<>();

    public VendingMachineDaoStubImpl() {
        PRODUCTS_FILE = "testitems.txt";
        testProduct = new Product("1", "Snickers Bar",new BigDecimal("0.99"), 12);
        products.put("1",testProduct);
        testProduct2= new Product("2","CocaCola",new BigDecimal("1.99"), 14 ); 
        products.put("2", testProduct2);

    }
    
    public VendingMachineDaoStubImpl(Product testProduct) {
        this.PRODUCTS_FILE = "testitems.txt";
		this.testProduct= testProduct; 
	

    }

    public VendingMachineDaoStubImpl(String productsTextFile) {
        PRODUCTS_FILE = productsTextFile;

    }
    @Override
    public Map<String, Product> loadProductsFromFile() throws VendingMachinePersistenceException {
		
        return products;
    }

    @Override
    public void writeProductsToFile() throws VendingMachinePersistenceException {
		
    }
       


    @Override
    public Product addProduct(String productId, Product testProduct) {
    	 if (productId.equals(testProduct.getProductId())) {
             return testProduct;
         } else {
             return null;
         }
    }

    @Override
    public List<Product> getAllProducts() {

    	 List<Product> productList = new ArrayList<>();
         productList.add(testProduct);
         return productList;
     }
    

    @Override
    public Product getProduct(String productId) {
    	if (productId.equals(testProduct.getProductId())) {
            return testProduct;
        } else {
            return null;
        }  
    }

    @Override
    public Product removeProduct(String productId) {
    	if (productId.equals(testProduct.getProductId())) {
            return testProduct;
        } else {
            return null;
        }
    }

    @Override
    public List<String> getAllProductIds() {

        return new ArrayList<>(products.keySet());
    }


    @Override
    public Product updateProduct(String productId, Product product) {

        return products.replace(productId, product);
    }


}

