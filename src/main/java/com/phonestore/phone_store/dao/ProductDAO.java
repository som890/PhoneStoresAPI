package com.phonestore.phone_store.dao;

import com.phonestore.phone_store.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {
}
