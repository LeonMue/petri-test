package org.dhbw.ka.ml.petritest.eval.protobuf;

import lombok.Getter;

@Getter
public enum ProductCatalogEvalDataSet {

    IMAGINARY,
    IMAGINARY_WITH_UNSET_FIELDS;

    private ProductCatalog productCatalog;

    static {
        {
            var productCatalogBuilder = ProductCatalog.newBuilder();

            productCatalogBuilder.setName("Electronics");
            productCatalogBuilder.setDescription("A catalog of electronic products");

            var computersCategoryBuilder = Category.newBuilder();
            computersCategoryBuilder.setName("Computers");
            computersCategoryBuilder.setDescription("Computing devices");

            var mobilePhonesCategoryBuilder = Category.newBuilder();
            mobilePhonesCategoryBuilder.setName("Mobile Phones");
            mobilePhonesCategoryBuilder.setDescription("Smartphones and cell phones");

            var laptopProductBuilder = Product.newBuilder();
            laptopProductBuilder.setName("Laptop");
            laptopProductBuilder.setBrand("Brand X");
            laptopProductBuilder.setPrice(999);
            laptopProductBuilder.setWeight(2.5);
            laptopProductBuilder.setAvailable(true);
            laptopProductBuilder.addColors("Silver");
            laptopProductBuilder.addColors("Black");

            var desktopProductBuilder = Product.newBuilder();
            desktopProductBuilder.setName("Desktop");
            desktopProductBuilder.setBrand("Brand Y");
            desktopProductBuilder.setPrice(899);
            desktopProductBuilder.setWeight(8.2);
            desktopProductBuilder.setAvailable(false);
            desktopProductBuilder.addColors("White");

            computersCategoryBuilder.addProducts(laptopProductBuilder);
            computersCategoryBuilder.addProducts(desktopProductBuilder);

            var smartphoneAProductBuilder = Product.newBuilder();
            smartphoneAProductBuilder.setName("Smartphone A");
            smartphoneAProductBuilder.setBrand("Brand Z");
            smartphoneAProductBuilder.setPrice(699);
            smartphoneAProductBuilder.setWeight(0.4);
            smartphoneAProductBuilder.setAvailable(true);
            smartphoneAProductBuilder.addColors("Black");
            smartphoneAProductBuilder.addColors("Blue");

            var smartphoneBProductBuilder = Product.newBuilder();
            smartphoneBProductBuilder.setName("Smartphone B");
            smartphoneBProductBuilder.setBrand("Brand X");
            smartphoneBProductBuilder.setPrice(799);
            smartphoneBProductBuilder.setWeight(0.5);
            smartphoneBProductBuilder.setAvailable(true);
            smartphoneBProductBuilder.addColors("Silver");
            smartphoneBProductBuilder.addColors("Gold");

            mobilePhonesCategoryBuilder.addProducts(smartphoneAProductBuilder);
            mobilePhonesCategoryBuilder.addProducts(smartphoneBProductBuilder);

            productCatalogBuilder.addCategories(computersCategoryBuilder);
            productCatalogBuilder.addCategories(mobilePhonesCategoryBuilder);

            IMAGINARY.productCatalog = productCatalogBuilder.build();
        }

        {
            var productCatalogBuilder = ProductCatalog.newBuilder();

            productCatalogBuilder.setName("Electronics");
            // productCatalogBuilder.setDescription("A catalog of electronic products");

            var computersCategoryBuilder = Category.newBuilder();
            computersCategoryBuilder.setName("Computers");
            // computersCategoryBuilder.setDescription("Computing devices");

            var mobilePhonesCategoryBuilder = Category.newBuilder();
            mobilePhonesCategoryBuilder.setName("Mobile Phones");
            // mobilePhonesCategoryBuilder.setDescription("Smartphones and cell phones");

            var laptopProductBuilder = Product.newBuilder();
            laptopProductBuilder.setName("Laptop");
            // laptopProductBuilder.setBrand("Brand X");
            laptopProductBuilder.setPrice(999);
            // laptopProductBuilder.setWeight(2.5);
            laptopProductBuilder.setAvailable(true);
            // laptopProductBuilder.addColors("Silver");
            // laptopProductBuilder.addColors("Black");

            var desktopProductBuilder = Product.newBuilder();
            desktopProductBuilder.setName("Desktop");
            // desktopProductBuilder.setBrand("Brand Y");
            desktopProductBuilder.setPrice(899);
            // desktopProductBuilder.setWeight(8.2);
            desktopProductBuilder.setAvailable(false);
            // desktopProductBuilder.addColors("White");

            computersCategoryBuilder.addProducts(laptopProductBuilder);
            computersCategoryBuilder.addProducts(desktopProductBuilder);

            var smartphoneAProductBuilder = Product.newBuilder();
            //  smartphoneAProductBuilder.setName("Smartphone A");
            smartphoneAProductBuilder.setBrand("Brand Z");
            // smartphoneAProductBuilder.setPrice(699);
            smartphoneAProductBuilder.setWeight(0.4);
            // smartphoneAProductBuilder.setAvailable(true);
            smartphoneAProductBuilder.addColors("Black");
            smartphoneAProductBuilder.addColors("Blue");

            var smartphoneBProductBuilder = Product.newBuilder();
            // smartphoneBProductBuilder.setName("Smartphone B");
            smartphoneBProductBuilder.setBrand("Brand X");
            smartphoneBProductBuilder.setPrice(799);
            // smartphoneBProductBuilder.setWeight(0.5);
            smartphoneBProductBuilder.setAvailable(true);
            smartphoneBProductBuilder.addColors("Silver");
            smartphoneBProductBuilder.addColors("Gold");

            mobilePhonesCategoryBuilder.addProducts(smartphoneAProductBuilder);
            mobilePhonesCategoryBuilder.addProducts(smartphoneBProductBuilder);

            productCatalogBuilder.addCategories(computersCategoryBuilder);
            productCatalogBuilder.addCategories(mobilePhonesCategoryBuilder);

            IMAGINARY_WITH_UNSET_FIELDS.productCatalog = productCatalogBuilder.build();
        }
    }

}
