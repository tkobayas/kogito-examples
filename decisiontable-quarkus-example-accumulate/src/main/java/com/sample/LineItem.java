package com.sample;

public class LineItem {

    private String skuId;
    private int qty;

    public LineItem() {

    }

    public LineItem(String skuId, int qty) {
        this.skuId = skuId;
        this.qty = qty;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
