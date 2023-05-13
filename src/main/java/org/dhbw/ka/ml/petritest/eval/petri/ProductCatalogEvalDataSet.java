package org.dhbw.ka.ml.petritest.eval.petri;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum ProductCatalogEvalDataSet {

    IMAGINARY;

    private ProductOrders productCatalog;

    static {
        // IMAGINARY

        var productOrders = new ProductOrders();

        var productSmartPhoneA = new Product();
        productSmartPhoneA.setAmount(5);
        productSmartPhoneA.setName("Smartphone A");
        productSmartPhoneA.setPrice(999);
        productSmartPhoneA.setWeight(0.5);
        productSmartPhoneA.setBrand("Brand X");
        productSmartPhoneA.setColors(List.of("Black", "White", "Blue"));

        var productSmartphoneB = new Product();
        productSmartphoneB.setColors(List.of("Red", "White", "Black"));
        productSmartphoneB.setWeight(0.6);
        productSmartphoneB.setPrice(800);
        productSmartphoneB.setBrand("Brand Y");
        productSmartphoneB.setName("Smartphone B");
        productSmartphoneB.setAmount(10);

        var productLaptopA = new Product();
        productLaptopA.setColors(List.of("Black", "Silver"));
        productLaptopA.setWeight(2.5);
        productLaptopA.setBrand("Brand X");
        productLaptopA.setPrice(1200.99);
        productLaptopA.setAmount(1);
        productLaptopA.setName("Laptop A");

        var productEarplug = new Product();
        productEarplug.setName("Earplugs Deluxe");
        productEarplug.setAmount(200);
        productEarplug.setBrand("The Earplug Company");
        productEarplug.setPrice(1.99);
        productEarplug.setWeight(0.01);
        productEarplug.setColors(List.of("White"));

        productOrders.setProducts(List.of(productSmartPhoneA, productSmartphoneB, productLaptopA, productEarplug));

        IMAGINARY.productCatalog = productOrders;
    }

}
