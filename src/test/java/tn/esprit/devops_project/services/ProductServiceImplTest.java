package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;


    @Test
    void shouldRetrieveProduct() {
        // Arrange
        Long productId = 1L;
        Product mockProduct = new Product(); // You can set properties as needed

        // Mock behavior of repository
        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));

        // Act
        Product retrievedProduct = productService.retrieveProduct(productId);

        // Assert
        assertNotNull(retrievedProduct);
        assertEquals(mockProduct, retrievedProduct);
        // Add more assertions based on your requirements
    }

    // Similar test methods for other service methods

    @Test
    void shouldRetrieveProductByCategory() {
        // Arrange
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> mockProducts = new ArrayList<>(); // You can set properties as needed

        // Mock behavior of repository
        when(productRepository.findByCategory(category)).thenReturn(mockProducts);

        // Act
        List<Product> retrievedProducts = productService.retrieveProductByCategory(category);

        // Assert
        assertNotNull(retrievedProducts);
        assertEquals(mockProducts, retrievedProducts);
        // Add more assertions based on your requirements
    }

    @Test
    void shouldDeleteProduct() {
        // Arrange
        Long productId = 1L;

        // Act
        productService.deleteProduct(productId);

        // Assert
        // Use Mockito.verify to check if the delete method on the repository is called
        Mockito.verify(productRepository).deleteById(productId);
    }

    @Test
    void shouldRetrieveProductStock() {
        // Arrange
        Long stockId = 1L;
        List<Product> mockProducts = new ArrayList<>(); // You can set properties as needed

        // Mock behavior of repository
        when(productRepository.findByStockIdStock(stockId)).thenReturn(mockProducts);

        // Act
        List<Product> retrievedProducts = productService.retreiveProductStock(stockId);

        // Assert
        assertNotNull(retrievedProducts);
        assertEquals(mockProducts, retrievedProducts);
        // Add more assertions based on your requirements
    }
}
