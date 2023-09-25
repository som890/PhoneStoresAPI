package com.phonestore.phone_store.controller;

import com.phonestore.phone_store.entity.ImageModel;
import com.phonestore.phone_store.entity.Product;
import com.phonestore.phone_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile") MultipartFile[] file) {

        try {
            Set<ImageModel> images = uploadImage(file);
            product.setProductImage((images));
            return productService.addNewProduct(product);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<ImageModel>();
        for (MultipartFile file: multipartFiles) {
            ImageModel imageModel = new ImageModel(
                 file.getOriginalFilename(),
                 file.getContentType(),
                 file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return  imageModels;
    }
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }
    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/getProductDetailsById/{productId}")
    public Product getProductDetailsById(@PathVariable("productId") Integer productId) {
        return productService.getProductDetailsById(productId);
    }
    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/deleteProductsDetails/{productId}")
    public void deleteProductDetails(@PathVariable("productId") Integer productId) {
        productService.deleteProductDetails(productId);
    }

}
