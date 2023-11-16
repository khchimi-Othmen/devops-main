package tn.esprit.devops_project.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceImplTest {

    @Autowired
    private SupplierServiceImpl supplierService;

    @Autowired
    private SupplierRepository supplierRepository;

    private Supplier supplier;

    @BeforeEach
    void setUp() {
        supplier = new Supplier();
        supplier.setCode("TestCode");
        supplier.setLabel("TestLabel");
        supplier.setSupplierCategory(SupplierCategory.ORDINAIRE);
    }

    @AfterEach
    void tearDown() {
        if (supplier != null && supplier.getIdSupplier() != null) {
            supplierRepository.deleteById(supplier.getIdSupplier());
        }
    }

    @Test
    @Order(1)
    void shouldRetrieveAllSuppliersWhenEmpty() {
        List<Supplier> suppliers = supplierService.retrieveAllSuppliers();

        assertNotNull(suppliers, "Returned list should not be null");
        assertTrue(suppliers.isEmpty(), "Expected an empty list");
    }

    @Test
    @Order(2)
    void shouldAddSupplier() {
        Supplier savedSupplier = supplierService.addSupplier(supplier);

        assertNotNull(savedSupplier, "Added supplier should not be null");
        assertEquals(supplier, savedSupplier, "Added supplier should match the input supplier");
    }

    @Test
    @Order(3)
    void shouldUpdateSupplier() {
        Supplier savedSupplier = supplierService.addSupplier(supplier);
        savedSupplier.setCode("UpdatedCode");

        Supplier updatedSupplier = supplierService.updateSupplier(savedSupplier);

        assertNotNull(updatedSupplier, "Updated supplier should not be null");
        assertEquals(savedSupplier, updatedSupplier, "Updated supplier should match the input supplier");
        assertEquals("UpdatedCode", updatedSupplier.getCode(), "Supplier code should be updated");
    }

    @Test
    @Order(4)
    void shouldDeleteSupplier() {
        Supplier savedSupplier = supplierService.addSupplier(supplier);

        supplierService.deleteSupplier(savedSupplier.getIdSupplier());

        assertNull(supplierService.retrieveSupplier(savedSupplier.getIdSupplier()), "Supplier should be deleted");
    }

    @Test
    @Order(5)
    void shouldRetrieveSupplier() {
        Supplier savedSupplier = supplierService.addSupplier(supplier);

        Supplier retrievedSupplier = supplierService.retrieveSupplier(savedSupplier.getIdSupplier());

        assertNotNull(retrievedSupplier, "Retrieved supplier should not be null");
        assertEquals(savedSupplier, retrievedSupplier, "Retrieved supplier should match the saved supplier");
    }
}
