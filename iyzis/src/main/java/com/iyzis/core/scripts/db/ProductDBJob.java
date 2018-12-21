package com.iyzis.core.scripts.db;

import com.iyzis.apps.product.domain.ProductEntityBuilder;
import com.iyzis.apps.product.domain.entity.Product;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.List;

public class ProductDBJob implements DBJob {

    private List<Product> products = new ArrayList<>();
    MongoOperations dbOperation;

    public ProductDBJob(MongoOperations dbOperation) {
        this.dbOperation = dbOperation;

        dbOperation.dropCollection(Product.class);

        ProductEntityBuilder entityBuilder = ProductEntityBuilder.newInstance();
        Product product1 = entityBuilder
                .id("1")
                .name("Product 1")
                .description("Standard Package")
                .price(360.0)
                .build();

        Product product2 = entityBuilder
                .id("2")
                .name("Product 2")
                .description("Advanced Package")
                .price(480.0)
                .build();

        Product product3 = entityBuilder
                .id("3")
                .name("Product 3")
                .description("Enterprise Package")
                .price(600.0)
                .build();

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }


    @Override
    public void run() {
        this.products.forEach(product -> {
            this.dbOperation.insert(product);
            System.out.println(product.toString());
        });
    }
}
