package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceImplJunitTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Test
    @Order(1)
    void shouldAddProduct() {
        Stock stock = stockRepository.save(new Stock());
        Product result = productService.addProduct(new Product(), stock.getIdStock());
        assertNotNull(result);
        assertEquals(stock, result.getStock());
    }

    @Test
    @Order(2)
    void shouldRetrieveProduct() {
        Product product = productRepository.save(new Product());
        assertNotNull(productService.retrieveProduct(product.getIdProduct()));
    }

    @Test
    @Order(3)
    void shouldRetrieveAllProducts() {
        List<Product> result = productService.retreiveAllProduct();
        assertNotNull(result);
    }

    @Test
    @Order(4)
    void shouldRetrieveProductByCategory() {
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> result = productService.retrieveProductByCategory(category);
        assertNotNull(result);
    }

    @Test
    @Order(5)
    void shouldDeleteProduct() {
        Product product = productRepository.save(new Product());
        productService.deleteProduct(product.getIdProduct());
        assertNull(productRepository.findById(product.getIdProduct()).orElse(null));
    }

    @Test
    @Order(6)
    void shouldRetrieveProductStock() {
        Stock stock = stockRepository.save(new Stock());
        productService.addProduct(new Product(), stock.getIdStock());
        List<Product> result = productService.retreiveProductStock(stock.getIdStock());
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}
