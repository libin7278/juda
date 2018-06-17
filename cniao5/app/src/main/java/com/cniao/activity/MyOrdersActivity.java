package com.cniao.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cniao.R;
import com.cniao.adapter.OrderAdapter;
import com.cniao.bean.ShoppingCart;
import com.cniao.widget.CNiaoToolBar;

import java.util.List;

import butterknife.BindView;

/**
 * Created by 高磊华
 * Time  2017/8/21
 * Describe: 我的订单
 */

public class MyOrdersActivity extends BaseActivity {

    @BindView(R.id.recyclerview_order)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    CNiaoToolBar mToolBar;
    @BindView(R.id.tv_no)
    TextView tv_no;

    @Override
    protected void init() {
        initToolBar();

        List<ShoppingCart> carts = (List<ShoppingCart>) getIntent().getSerializableExtra("serinfo");

        if(carts != null){
            if (carts.size() > 0) {
                mRecyclerView.setVisibility(View.VISIBLE);
                tv_no.setVisibility(View.GONE);
                OrderAdapter mSecondGoodsAdapter = new OrderAdapter(this, carts);

                mRecyclerView.setAdapter(mSecondGoodsAdapter);
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
                //                mRecyclerviewWares.setLayoutManager(new LinearLayoutManager
                // (getContext()));
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                        DividerItemDecoration.HORIZONTAL));

            } else {
                tv_no.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.GONE);

            }
        }else {
            tv_no.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }

    }


    @Override
    protected int getContentResourseId() {
        return R.layout.activity_myorder;
    }

    private void initToolBar() {
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOrdersActivity.this.finish();
            }
        });

    }
}
