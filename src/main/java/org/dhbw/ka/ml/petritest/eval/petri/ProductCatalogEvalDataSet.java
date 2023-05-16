package org.dhbw.ka.ml.petritest.eval.petri;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum ProductCatalogEvalDataSet {

    IMAGINARY,
    IMAGINARY_WITH_UNSET_FIELDS;

    private ProductCatalog productCatalog;

    static {
        // IMAGINARY
        {
            var productCatalog = new ProductCatalog();
            productCatalog.setName("Electronics");
            productCatalog.setDescription("A catalog of electronic products");

            List<Category> categories = new ArrayList<>();

            var computersCategory = new Category();
            computersCategory.setName("Computers");
            computersCategory.setDescription("Computing devices");

            List<Product> computerProducts = new ArrayList<>();

            var laptopProduct = new Product();
            laptopProduct.setName("Laptop");
            laptopProduct.setBrand("Brand X");
            laptopProduct.setPrice(999);
            laptopProduct.setWeight(2.5);
            laptopProduct.setAvailable(true);
            List<String> laptopColors = new ArrayList<>();
            laptopColors.add("Silver");
            laptopColors.add("Black");
            laptopProduct.setColors(laptopColors);

            var desktopProduct = new Product();
            desktopProduct.setName("Desktop");
            desktopProduct.setBrand("Brand Y");
            desktopProduct.setPrice(899);
            desktopProduct.setWeight(8.2);
            desktopProduct.setAvailable(false);
            List<String> desktopColors = new ArrayList<>();
            desktopColors.add("White");
            desktopProduct.setColors(desktopColors);

            computerProducts.add(laptopProduct);
            computerProducts.add(desktopProduct);

            computersCategory.setProducts(computerProducts);

            var mobilePhonesCategory = new Category();
            mobilePhonesCategory.setName("Mobile Phones");
            mobilePhonesCategory.setDescription("Smartphones and cell phones");

            List<Product> mobilePhoneProducts = new ArrayList<>();

            var smartphoneAProduct = new Product();
            smartphoneAProduct.setName("Smartphone A");
            smartphoneAProduct.setBrand("Brand Z");
            smartphoneAProduct.setPrice(699);
            smartphoneAProduct.setWeight(0.4);
            smartphoneAProduct.setAvailable(true);
            List<String> smartphoneAColors = new ArrayList<>();
            smartphoneAColors.add("Black");
            smartphoneAColors.add("Blue");
            smartphoneAProduct.setColors(smartphoneAColors);

            var smartphoneBProduct = new Product();
            smartphoneBProduct.setName("Smartphone B");
            smartphoneBProduct.setBrand("Brand X");
            smartphoneBProduct.setPrice(799);
            smartphoneBProduct.setWeight(0.5);
            smartphoneBProduct.setAvailable(true);
            List<String> smartphoneBColors = new ArrayList<>();
            smartphoneBColors.add("Silver");
            smartphoneBColors.add("Gold");
            smartphoneBProduct.setColors(smartphoneBColors);

            mobilePhoneProducts.add(smartphoneAProduct);
            mobilePhoneProducts.add(smartphoneBProduct);

            mobilePhonesCategory.setProducts(mobilePhoneProducts);

            categories.add(computersCategory);
            categories.add(mobilePhonesCategory);

            productCatalog.setCategories(categories);

            IMAGINARY.productCatalog = productCatalog;
        }

        {
            var productCatalog = new ProductCatalog();

            productCatalog.setName("Electronics");
            // productCatalog.setDescription("A catalog of electronic products");

            List<Category> categories = new ArrayList<>();

            var computersCategory = new Category();
            computersCategory.setName("Computers");
            // computersCategory.setDescription("Computing devices");

            List<Product> computerProducts = new ArrayList<>();

            var laptopProduct = new Product();
            laptopProduct.setName("Laptop");
            // laptopProduct.setBrand("Brand X");
            laptopProduct.setPrice(999);
            // laptopProduct.setWeight(2.5);
            laptopProduct.setAvailable(true);
            // List<String> laptopColors = new ArrayList<>();
            // laptopColors.add("Silver");
            // laptopColors.add("Black");
            // laptopProduct.setColors(laptopColors);

            var desktopProduct = new Product();
            desktopProduct.setName("Desktop");
            // desktopProduct.setBrand("Brand Y");
            desktopProduct.setPrice(899);
            // desktopProduct.setWeight(8.2);
            desktopProduct.setAvailable(false);
            // List<String> desktopColors = new ArrayList<>();
            // desktopColors.add("White");
            // desktopProduct.setColors(desktopColors);

            computerProducts.add(laptopProduct);
            computerProducts.add(desktopProduct);

            computersCategory.setProducts(computerProducts);

            var mobilePhonesCategory = new Category();
            // mobilePhonesCategory.setName("Mobile Phones");
            mobilePhonesCategory.setDescription("Smartphones and cell phones");

            List<Product> mobilePhoneProducts = new ArrayList<>();

            var smartphoneAProduct = new Product();
            // smartphoneAProduct.setName("Smartphone A");
            smartphoneAProduct.setBrand("Brand Z");
            // smartphoneAProduct.setPrice(699);
            smartphoneAProduct.setWeight(0.4);
            // smartphoneAProduct.setAvailable(true);
            List<String> smartphoneAColors = new ArrayList<>();
            smartphoneAColors.add("Black");
            smartphoneAColors.add("Blue");
            smartphoneAProduct.setColors(smartphoneAColors);

            var smartphoneBProduct = new Product();
            // smartphoneBProduct.setName("Smartphone B");
            smartphoneBProduct.setBrand("Brand X");
            smartphoneBProduct.setPrice(799);
            // smartphoneBProduct.setWeight(0.5);
            smartphoneBProduct.setAvailable(true);
            List<String> smartphoneBColors = new ArrayList<>();
            smartphoneBColors.add("Silver");
            smartphoneBColors.add("Gold");
            smartphoneBProduct.setColors(smartphoneBColors);

            mobilePhoneProducts.add(smartphoneAProduct);
            mobilePhoneProducts.add(smartphoneBProduct);

            mobilePhonesCategory.setProducts(mobilePhoneProducts);

            categories.add(computersCategory);
            categories.add(mobilePhonesCategory);

            productCatalog.setCategories(categories);

            IMAGINARY_WITH_UNSET_FIELDS.productCatalog = productCatalog;
        }
    }

}
