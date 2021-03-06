package com.cniao.bean;

import java.io.Serializable;

/**
 * Created by 高磊华
 * Time  2017/8/9
 * Describe:  购物车商品信息.数据来源于商品数据.但多了数量、是否选中两个 属性
 */

public class ShoppingCart extends HotGoods.ListEntity implements Serializable {

    private int count;
    private boolean isChecked = true;
    private boolean isNumberAddSubVisible = false;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isNumberAddSubVisible() {
        return isNumberAddSubVisible;
    }

    public void setIsNumberAddSubVisible(boolean isNumberAddSubVisible) {
        this.isNumberAddSubVisible = isNumberAddSubVisible;
    }

    private Float totalPrice = Float.valueOf(0);

    public Float getTotalPrice() {
        if(count == 0){
            count = 1;
        }
        totalPrice = (float) getPrice() * count;
        return totalPrice;
    }


}
