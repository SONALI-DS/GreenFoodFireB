package com.android.greenfoodfireb;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.greenfoodfireb.models.CartItem;
import com.android.greenfoodfireb.models.Product;
import com.android.greenfoodfireb.repositories.CartRepo;
import com.android.greenfoodfireb.repositories.PastaRepo;

import java.util.List;

public class testModel extends ViewModel {


    PastaRepo shopRepo = new PastaRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData< Product > mutableProduct = new MutableLiveData<>();

    public LiveData< List<Product> > getProducts() {
        return shopRepo.getProducts();
    }

    public void setProduct(Product product) {
        mutableProduct.setValue(product);
    }

    public LiveData<Product> getProduct() {
        return mutableProduct;
    }

    public LiveData< List< CartItem > > getCart() {
        return cartRepo.getCart();
    }

    public boolean addItemToCart(Product product) {
        return cartRepo.addItemToCart(product);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData< Double > getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }
}
