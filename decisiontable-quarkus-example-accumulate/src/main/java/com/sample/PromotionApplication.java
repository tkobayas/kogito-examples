package com.sample;

import java.util.List;

public class PromotionApplication {

    private String promotionCode;

    List<LineItem> cart;

    public PromotionApplication() {}

    public PromotionApplication(String promotionCode, List<LineItem> cart) {
        this.promotionCode = promotionCode;
        this.cart = cart;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public List<LineItem> getCart() {
        return cart;
    }

    public void setCart(List<LineItem> cart) {
        this.cart = cart;
    }

}
