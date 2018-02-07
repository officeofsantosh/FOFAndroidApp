package com.andproj.skm.fondoffood.model;

import java.util.List;

/**
 * Created by skumarmanda on 2/6/2018.
 */

public class CheckoutItem {

    private ItemModel item;
    private int quantity=1;

    public CheckoutItem(ItemModel item) {

        this.item = item;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

 }
