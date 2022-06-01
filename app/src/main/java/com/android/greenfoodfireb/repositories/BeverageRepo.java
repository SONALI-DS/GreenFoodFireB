package com.android.greenfoodfireb.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.greenfoodfireb.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BeverageRepo {

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
        productList.add(new Product( UUID.randomUUID().toString(), "Watermelon Mojito", 699, true, "https://i.ibb.co/wh62t1s/j-1.png" ));
        productList.add(new Product( UUID.randomUUID().toString(), "Hot Chocolate", 799, true, "https://i.ibb.co/sWM0yVH/j-2.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Lemon Mojito", 899, true, "https://i.ibb.co/3TrsNJT/j-5.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Cocacola", 699, false, "https://i.ibb.co/0YTbPYN/j-6.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Orange Mojito", 599, true, "https://i.ibb.co/fC2J8Pf/j-7.png"));
        mutableProductList.setValue(productList);
    }
}
