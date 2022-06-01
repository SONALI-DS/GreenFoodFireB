package com.android.greenfoodfireb.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.greenfoodfireb.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SandwichRepo {

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
        productList.add(new Product( UUID.randomUUID().toString(), "Grilled Sandwich", 699, true, "https://i.ibb.co/9Wjwxkw/s-2.png" ));productList.add(new Product( UUID.randomUUID().toString(), "Egg Sandwich", 799, true, "https://i.ibb.co/3WnmLHP/s-1.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Cheese Sandwich", 899, true, "https://i.ibb.co/VwYfLdj/s-3.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Chicken Sandwich", 699, false, "https://i.ibb.co/02BccMr/s-4.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Spicy Sandwich", 699, false, "https://i.ibb.co/2n3Vv81/s-5.png"));
        mutableProductList.setValue(productList);
    }
}
