package tn.esprit.devops_project.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    public void setUp() {
        // Any common setup tasks can be performed here.
    }

    @Test
    public void testAddStock() {
        // Mock behavior of the repository method
        Stock newStock = new Stock();
        when(stockRepository.save(any(Stock.class))).thenReturn(newStock);

        Stock addedStock = stockService.addStock(newStock);

        assertNotNull(addedStock);
        assertEquals(newStock, addedStock);
    }

    @Test
    public void testRetrieveStock() {
        // Mock behavior of the repository method
        Long stockId = 1L;
        Stock sampleStock = new Stock();
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(sampleStock));

        Stock retrievedStock = stockService.retrieveStock(stockId);

        assertNotNull(retrievedStock);
        assertEquals(sampleStock, retrievedStock);
    }

    @Test
    public void testRetrieveAllStock() {
        // Mock behavior of the repository method
        List<Stock> sampleStocks = new ArrayList<>();
        when(stockRepository.findAll()).thenReturn(sampleStocks);

        List<Stock> retrievedStocks = stockService.retrieveAllStock();

        assertNotNull(retrievedStocks);
        assertEquals(sampleStocks, retrievedStocks);
    }

    // Add more test methods as needed for other functionalities.

}
