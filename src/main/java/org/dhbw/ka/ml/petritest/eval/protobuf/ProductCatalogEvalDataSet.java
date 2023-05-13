package org.dhbw.ka.ml.petritest.eval.protobuf;

import lombok.Getter;

@Getter
public enum ProductCatalogEvalDataSet {

    IMAGINARY;

    private ProductOrders productOrders;

    static {

        var productOrdersBuilder = ProductOrders.newBuilder();

        var productSmartPhoneA = Product.newBuilder()
                .addColors("Black")
                .addColors("White")
                .addColors("Blue")
                .setPrice(999)
                .setBrand("Brand X")
                .setName("Smartphone A")
                .setWeight(0.5)
                .setAmount(5)
                .build();

        var productSmartPhoneB = Product.newBuilder()
                .addColors("Red")
                .addColors("White")
                .addColors("Black")
                .setWeight(0.6)
                .setPrice(800)
                .setBrand("Brand Y")
                .setName("Smartphone B")
                .setAmount(10)
                .build();

        var productLaptopA = Product.newBuilder()
                .addColors("Black")
                .addColors("Silver")
                .setWeight(2.5)
                .setBrand("Brand X")
                .setPrice(1200.99)
                .setAmount(1)
                .setName("Laptop A")
                .build();

        var productEarplug = Product.newBuilder()
                .setName("Earplugs Deluxe")
                .setAmount(200)
                .setBrand("The Earplug company")
                .setPrice(1.99)
                .setWeight(0.01)
                .addColors("White")
                .build();

        productOrdersBuilder.addProducts(productSmartPhoneA);
        productOrdersBuilder.addProducts(productSmartPhoneB);
        productOrdersBuilder.addProducts(productLaptopA);
        productOrdersBuilder.addProducts(productEarplug);

        var productOrders = productOrdersBuilder.build();

        IMAGINARY.productOrders = productOrders;

    }

}
