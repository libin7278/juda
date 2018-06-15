package com.cniao.bean;

import java.util.List;

/**
 * Created by 高磊华
 * Time  2017/8/8
 * Describe:  热卖商品.也是 一级菜单  二级菜单的数据模型
 *            同时,也是首页跳转到商品列表 的数据模型
 */

public class HotGoods {

    /**
     * copyright :
     * totalCount : 19
     * currentPage : 1
     * totalPage : 0
     * pageSize : 10
     * orders : []
     * list : [{"id":157,"categoryId":3,"campaignId":14,"repertory":200,"allsales":3000,"name":"都市丽人聚拢文胸 上薄下厚女士蕾丝性感内衣女胸罩聚拢B杯 浅啡 75B","imgUrl":"http://m.360buyimg.com/n4/jfs/t1195/118/369587391/159886/4e6a59cd/551e5c9dN3a4773e5.jpg!q70.jpg","price":32,"sale":3111,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":158,"categoryId":3,"campaignId":1,"repertory":200,"allsales":3000,"name":"幻薇文胸 无钢圈无痕内衣夏小胸聚拢调整型一片式胸罩 肤色(拉丝款) 75B=34B","imgUrl":"http://m.360buyimg.com/n4/jfs/t1810/37/158141536/91268/52ade0d1/55cd6965N55b8637b.jpg!q70.jpg","price":98,"sale":4762,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":159,"categoryId":3,"campaignId":18,"repertory":200,"allsales":3000,"name":"梦秀侨姿聚拢交叉美背文胸光面无痕半杯少女内衣胸罩 女 T176 黑色 AB杯通用 34B/75B","imgUrl":"http://m.360buyimg.com/n4/jfs/t868/246/383781342/448885/17cd2480/552dbba8Nc5aaa015.jpg!q70.jpg","price":66,"sale":4476,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":160,"categoryId":3,"campaignId":3,"repertory":200,"allsales":3000,"name":"纤慕聚拢调整型文胸性感薄款收副乳抹胸内衣 优雅紫 85D=38D","imgUrl":"http://m.360buyimg.com/n4/jfs/t847/298/1373127200/278544/935e057f/559ce9a0N0b0695e6.jpg!q70.jpg","price":95,"sale":8094,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":161,"categoryId":3,"campaignId":1,"repertory":200,"allsales":3000,"name":"古今小胸聚拢文胸调整型女士内衣胸罩09713 深肤 B75","imgUrl":"http://m.360buyimg.com/n4/jfs/t1357/136/681026303/374327/93bf2521/55a4ba57N8a821abb.jpg!q70.jpg","price":85,"sale":7042,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":162,"categoryId":3,"campaignId":11,"repertory":200,"allsales":3000,"name":"幻薇内衣 女士文胸聚拢调整无钢圈一片式小胸胸罩W1282 柔肤 75/34B","imgUrl":"http://m.360buyimg.com/n4/jfs/t1060/361/906309574/282781/f0b0558a/55575fceN9ceb87a8.jpg!q70.jpg","price":98,"sale":927,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":163,"categoryId":3,"campaignId":6,"repertory":200,"allsales":3000,"name":"曼妮芬 性感无痕舒适无钢圈文胸女 美背调整侧收副乳聚拢女士内衣20810946 肤色 75B","imgUrl":"http://m.360buyimg.com/n4/jfs/t1771/101/1673804042/273811/4af8536a/5600f154N1311e78c.jpg!q70.jpg","price":199,"sale":3511,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":164,"categoryId":3,"campaignId":5,"repertory":200,"allsales":3000,"name":"幻薇运动文胸内衣女薄款聚拢调整跑步无钢圈透气瑜伽背心睡眠W0153 黑色+白色共2件 M(适合70-80)","imgUrl":"http://m.360buyimg.com/n4/jfs/t1531/241/692314543/64645/92543274/55a4d787N4e94aa38.jpg!q70.jpg","price":85,"sale":4772,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":165,"categoryId":3,"campaignId":1,"repertory":200,"allsales":3000,"name":"幻薇聚拢文胸 隐形硅胶内衣女士胸贴调整婚纱游泳乳贴W0080 肤(厚款)顺丰速递时效快 B杯","imgUrl":"http://m.360buyimg.com/n4/jfs/t2206/278/4512658/129636/7f46073c/55e599c1N41d3dfb3.jpg!q70.jpg","price":85,"sale":3326,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"},{"id":166,"categoryId":3,"campaignId":13,"repertory":200,"allsales":3000,"name":"婷美内衣 上薄下厚调整型聚拢文胸收副乳性感美背防下垂薄厚款文胸 3742 黑色(厚杯) 75B","imgUrl":"http://m.360buyimg.com/n4/jfs/t1222/125/1032104601/228439/d62a9bfa/556bf9d6N059c6c2b.jpg!q70.jpg","price":139,"sale":2317,"detailimageOne":"https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg","detailimageTwo":"https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg","detailimageThree":"https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg"}]
     */

    private String copyright;
    private int totalCount;
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private List<?> orders;
    private List<ListEntity> list;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getOrders() {
        return orders;
    }

    public void setOrders(List<?> orders) {
        this.orders = orders;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public static class ListEntity {
        /**
         * id : 157
         * categoryId : 3
         * campaignId : 14
         * repertory : 200
         * allsales : 3000
         * name : 都市丽人聚拢文胸 上薄下厚女士蕾丝性感内衣女胸罩聚拢B杯 浅啡 75B
         * imgUrl : http://m.360buyimg.com/n4/jfs/t1195/118/369587391/159886/4e6a59cd/551e5c9dN3a4773e5.jpg!q70.jpg
         * price : 32.0
         * sale : 3111
         * detailimageOne : https://img.alicdn.com/imgextra/i2/3663553983/TB231TovYGYBuNjy0FoXXciBFXa_!!3663553983.jpg
         * detailimageTwo : https://img.alicdn.com/imgextra/i3/3663553983/TB2yTbCv7yWBuNjy0FpXXassXXa_!!3663553983.jpg
         * detailimageThree : https://img.alicdn.com/imgextra/i1/3663553983/TB2jNQCv21TBuNjy0FjXXajyXXa_!!3663553983.jpg
         */

        private int id;
        private int categoryId;
        private int campaignId;
        private int repertory;
        private int allsales;
        private String name;
        private String imgUrl;
        private double price;
        private int sale;
        private String detailimageOne;
        private String detailimageTwo;
        private String detailimageThree;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
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
