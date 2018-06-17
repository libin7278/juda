package com.cniao.bean;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/6/14
 *     email : 524607562@qq.com
 *     desc  : XXX
 * </pre>
 */
public class HotGoodsBean implements Serializable{


    private List<ListEntity> list;

    public List<ListEntity> getList() {
        return list;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public static class ListEntity implements Serializable{
        /**
         * repertory : 3000
         * allsales : 24321
         * name : 美发师夏季个性两件套嘻哈宽松套装夜店DJ韩版潮流时尚服装街舞男
         * imgUrl : https://gd4.alicdn.com/imgextra/i2/2121202225/TB2tW8Ok5CYBuNkSnaVXXcMsVXa_!!2121202225.jpg
         * price : 299
         * sale : 89
         * detailimageOne : https://img.alicdn.com/imgextra/i3/2121202225/TB2nZ1ltgmTBuNjy1XbXXaMrVXa_!!2121202225.jpg
         * detailimageTwo : https://img.alicdn.com/imgextra/i4/2121202225/TB2.njmtb5YBuNjSspoXXbeNFXa_!!2121202225.jpg
         * detailimageThree : https://img.alicdn.com/imgextra/i4/2121202225/TB27_nmtb5YBuNjSspoXXbeNFXa_!!2121202225.jpg
         */
        private int id;
        private int repertory;
        private int allsales;
        private String name;
        private String imgUrl;
        private int price;
        private int sale;
        private String detailimageOne;
        private String detailimageTwo;
        private String detailimageThree;

        public ListEntity(int id, int repertory, int allsales, String name, String imgUrl, int price, int sale, String detailimageOne, String detailimageTwo, String detailimageThree) {
            this.id = id;
            this.repertory = repertory;
            this.allsales = allsales;
            this.name = name;
            this.imgUrl = imgUrl;
            this.price = price;
            this.sale = sale;
            this.detailimageOne = detailimageOne;
            this.detailimageTwo = detailimageTwo;
            this.detailimageThree = detailimageThree;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        public int getRepertory() {
            return repertory;
        }

        public void setRepertory(int repertory) {
            this.repertory = repertory;
        }

        public int getAllsales() {
            return allsales;
        }

        public void setAllsales(int allsales) {
            this.allsales = allsales;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }

        public String getDetailimageOne() {
            return detailimageOne;
        }

        public void setDetailimageOne(String detailimageOne) {
            this.detailimageOne = detailimageOne;
        }

        public String getDetailimageTwo() {
            return detailimageTwo;
        }

        public void setDetailimageTwo(String detailimageTwo) {
            this.detailimageTwo = detailimageTwo;
        }

        public String getDetailimageThree() {
            return detailimageThree;
        }

        public void setDetailimageThree(String detailimageThree) {
            this.detailimageThree = detailimageThree;
        }
    }
}
