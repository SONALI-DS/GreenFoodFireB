package com.android.greenfoodfireb.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.greenfoodfireb.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DessertRepo {

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
        productList.add(new Product( UUID.randomUUID().toString(), "Choco Cake", 699, true, "https://i.ibb.co/X5K08fR/d-2.png" ));
        productList.add(new Product( UUID.randomUUID().toString(), "Macaron", 799, true, "https://i.ibb.co/v3Zfx5k/d-3.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Cheese Cake", 899, true, "https://i.ibb.co/DwqL3Fr/d-4.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Ice Wffle", 699, false, "https://i.ibb.co/4fNj4YJ/d-5.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Pancake", 599, true, "https://i.ibb.co/WGMPwyc/d-6.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Chocolate Cake", 589, true, "https://i.ibb.co/bP8hF3w/d-1.png"));

        mutableProductList.setValue(productList);
    }
}
