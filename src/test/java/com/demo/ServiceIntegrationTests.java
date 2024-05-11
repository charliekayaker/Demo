package com.demo;

import com.demo.infraestructure.adapter.ProductRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest(classes = DemoApplication.class)
class ServiceIntegrationTests {

    private ProductRepositoryTest productRepositoryTest;

    public ServiceIntegrationTests(ProductRepositoryTest productRepositoryTest){
        this.productRepositoryTest = productRepositoryTest;
    }

    @Test
    void contextLoads() {
        assertNotNull("ProductRepositoryTest is not null", productRepositoryTest);
    }
}
