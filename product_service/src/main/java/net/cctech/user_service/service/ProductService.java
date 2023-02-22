package net.cctech.user_service.service;

import net.cctech.user_service.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product findById(int id);


}
