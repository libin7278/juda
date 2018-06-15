/**
 * <pre>
 *     author : 高磊华
 *     e-mail : 984992087@qq.com
 *     time   : 2017/08/17
 *     desc   :首页 分类数据 二级
 *             必须这么写,要不然adapter中的接口回调无法进行
 *     version: 1.0
 * </pre>
 */
package com.cniao.bean;

import java.io.Serializable;


public class Campaign implements Serializable {


    private int id;
    private String title;
    private String imgUrl;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
