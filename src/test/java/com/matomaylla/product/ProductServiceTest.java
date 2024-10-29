package com.matomaylla.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.matomaylla.product.Entity.Product;
import com.matomaylla.product.Repository.ProductRepository;
import com.matomaylla.product.Service.ProductService;

public class ProductServiceTest {
    
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        productService.getAllProducts();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testCreateProduct() {
        Product product = new Product("Laptop", 1000.0);
        when(productRepository.save(product)).thenReturn(product);
        Product createdProduct = productService.createProduct(product);
        assertEquals("Laptop", createdProduct.getName());
    }

    @Test
    void testUpdateProduct() {
        Product existingProduct = new Product("Laptop", 1000.0);
        existingProduct.setId(1L);

        Product updatedDetails = new Product("Gaming Laptop", 1200.0);
        when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(existingProduct);

        Product updatedProduct = productService.updateProduct(1L, updatedDetails);
        assertEquals("Gaming Laptop", updatedProduct.getName());
    }


}
