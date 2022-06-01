package com.android.greenfoodfireb.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.greenfoodfireb.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData< List<Product> > mutableProductList;

    public LiveData< List<Product> > getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product( UUID.randomUUID().toString(), "iBurger", 699, true, "https://i.ibb.co/Chk8sLj/burger-l.png" ));
        productList.add(new Product( UUID.randomUUID().toString(), "Chicken Burger", 799, true, "https://i.ibb.co/6gDYkjR/burger-a.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Zinger Burger", 899, true, "https://i.ibb.co/gSKpNXF/burger-b.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Cheese Burger", 699, false, "https://i.ibb.co/Yhxv1SQ/burger-c.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Double Burger", 599, true, "https://i.ibb.co/YdM19TT/burger-d.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Hamburger", 589, true, "https://i.ibb.co/R0rC2sW/burger-e.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Crispy Chicken Burger", 999, true, "https://i.ibb.co/P402Jsb/burger-f.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Mac Burger", 899, true, "https://i.ibb.co/N3ZNRBf/burger-g.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Cheesy Lover Burger", 699, true, "https://i.ibb.co/gSyMHWL/burger-h.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Magic Burger", 799, true, "https://i.ibb.co/YLbmkcK/burger-i.png"));
        mutableProductList.setValue(productList);
    }
}
