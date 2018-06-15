package com.cniao.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.cniao.R;
import com.cniao.bean.HotGoodsBean;
import com.cniao.utils.CartShopProvider;
import com.cniao.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


/**
 * Created by legoer on 2016/5/4.
 */
public class WaresAdapter extends BaseAdapter<HotGoodsBean.ListEntity,BaseViewHolder> {
    CartShopProvider provider ;

    public WaresAdapter(Context context, List<HotGoodsBean.ListEntity> datas) {
        super(context, R.layout.template_grid_wares, datas);

        provider = new CartShopProvider(context);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final HotGoodsBean.ListEntity wares) {
        SimpleDraweeView draweeView = (SimpleDraweeView) viewHolder.getView(R.id.drawee_view);
        draweeView.setImageURI(Uri.parse(wares.getImgUrl()));

        viewHolder.getTextView(R.id.text_title).setText(wares.getName());
        viewHolder.getTextView(R.id.text_price).setText("￥"+wares.getPrice());

        Button button =viewHolder.getButton(R.id.btn_add);
        if(button !=null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    provider.put(wares);

                    ToastUtils.showSafeToast(context, "已经添加到了购物车");
                }
            });
        }

    }




    public void  resetLayout(int layoutId){


        this.layoutResId  = layoutId;

        notifyItemRangeChanged(0,getDatas().size());


    }
}
