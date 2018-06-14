package com.cniao.bean;

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
public class HotGoodsBean {


    private List<ListEntity> list;

    public List<ListEntity> getList() {
        return list;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public static class ListEntity {
        /**
         * name : 爱慕新品金丝奇缘3/4薄模杯无托文胸AM17GP1 酒红色 B80
         * imgUrl : http://m.360buyimg.com/n4/jfs/t1786/328/1204039392/295008/96a7278c/55e3e456N0ddbe7c5.jpg!q70.jpg
         * price : 239
         * sale : 3973
         */

        private String name;
        private String imgUrl;
        private int price;
        private int sale;

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
    }
}
