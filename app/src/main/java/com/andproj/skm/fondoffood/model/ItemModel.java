package com.andproj.skm.fondoffood.model;

/**
 * Created by skumarmanda on 2/4/2018.
 */

public class ItemModel {

    private String item_name;
    private String item_price;
    private String item_Desc;
    private int item_image_id;

    public ItemModel()
    {    }
    public ItemModel(String item_name, String item_price, String item_Desc, int item_image_id) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_Desc = item_Desc;
        this.item_image_id = item_image_id;
    }


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_Desc() {
        return item_Desc;
    }

    public void setItem_Desc(String item_Desc) {
        this.item_Desc = item_Desc;
    }

    public int getItem_image_id() {
        return item_image_id;
    }

    public void setItem_image_id(int item_image) {
        this.item_image_id = item_image;
    }

}
