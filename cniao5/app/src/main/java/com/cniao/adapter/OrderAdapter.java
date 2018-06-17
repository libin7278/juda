package com.cniao.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.cniao.CNiaoApplication;
import com.cniao.R;
import com.cniao.bean.ShoppingCart;
import com.cniao.utils.GlideUtils;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 高磊华
 * Time  2017/8/9
 * Dscribe: 分类 二级菜单 适配器
 */

public class OrderAdapter extends CommonAdapter<ShoppingCart> {

    public OrderAdapter(Context context, List<ShoppingCart> datas) {
        super(context, R.layout.template_category_order, datas);

    }

    @Override
    protected void convert(ViewHolder holder, ShoppingCart bean, int position) {

        long time=System.currentTimeMillis();//long now = android.os.SystemClock.uptimeMillis();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1=new Date(time);
        String t1=format.format(d1);

        holder.setText(R.id.text_title, bean.getName());
        holder.setText(R.id.text_price, "总价 :" + bean.getTotalPrice());
        holder.setText(R.id.text_pcount, "数量 :" + bean.getCount());
        holder.setText(R.id.text_time, "时间 :" + t1);
        GlideUtils.load(CNiaoApplication.sContext, bean.getImgUrl(), (ImageView) holder.getView(R
                .id.iv_view));
    }
}
