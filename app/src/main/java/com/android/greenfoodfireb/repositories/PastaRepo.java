package com.android.greenfoodfireb.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.greenfoodfireb.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PastaRepo {

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
        productList.add(new Product( UUID.randomUUID().toString(), "Sweet Pasta", 699, true, "https://i.ibb.co/F7qgSPq/pasta-1.png" ));
        productList.add(new Product( UUID.randomUUID().toString(), "Peperoni Pasta", 799, true, "https://i.ibb.co/dKKSGDJ/pasta-2.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Supper Spicy Pasta", 899, true, "https://i.ibb.co/L87bjZg/pasta-3.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Cheesy Pasta", 699, false, "https://i.ibb.co/kQQ1rn6/pasta-4.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Devil Pasta", 599, true, "https://i.ibb.co/9Y9vcwX/pasta-5.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Spicy Pasta", 589, true, "https://i.ibb.co/FwQF26V/pasta-7.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Mac & Cheese", 589, true, "https://i.ibb.co/kDDmWpQ/macaroni-and-cheese-pasta-cream-vegetarian-cuisine-pasta-noodles-af5aea572c67d4a375f5801137fd07cc.png"));
        mutableProductList.setValue(productList);
    }
}
