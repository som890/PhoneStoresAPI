package com.phonestore.phone_store.service;

import com.phonestore.phone_store.dao.ProductDAO;
import com.phonestore.phone_store.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;
    public Product addNewProduct(Product product) {
        return productDAO.save(product);
    }
    public List<Product> getAllProduct() {
        return  (List<Product>) productDAO.findAll();
    }
    public void deleteProductDetails(Integer productId) {
        productDAO.deleteById(productId);
    }
    public Product getProductDetailsById(Integer productId) {
        return productDAO.findById(productId).get();
    }

}
