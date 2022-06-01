package com.android.greenfoodfireb.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.greenfoodfireb.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PizzaRepo {

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
        productList.add(new Product( UUID.randomUUID().toString(), "Stuffed Crust Pizza", 699, true, "https://i.ibb.co/ZYnwkvJ/pizza-m.png" ));
        productList.add(new Product( UUID.randomUUID().toString(), "Pan Pizza", 799, true, "https://i.ibb.co/7ycZMMX/pizza-2.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Cheesy Blast", 899, true, "https://i.ibb.co/J5rRVgz/pizza-3.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Pepperoni Pizza", 699, false, "https://i.ibb.co/rMzGxcb/pizza-4.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Devil Chicken Pizza", 599, true, "https://i.ibb.co/LgDqY5j/pizza-l.png"));
        productList.add(new Product( UUID.randomUUID().toString(), "Thanduri Chicken Pizza", 589, true, "https://i.ibb.co/R7LDGHb/pizza-q.png"));
        mutableProductList.setValue(productList);
    }
}
