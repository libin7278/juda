package com.cniao.fragment;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cniao.R;
import com.cniao.activity.CreateOrderActivity;
import com.cniao.adapter.ShopCartAdapter;
import com.cniao.bean.MessageEvent;
import com.cniao.bean.ShoppingCart;
import com.cniao.utils.CartShopProvider;
import com.cniao.utils.LogUtil;
import com.cniao.widget.CNiaoToolBar;
import com.cniao.widget.WrapContentLinearLayoutManager;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : 高磊华
 *     e-mail : 984992087@qq.com
 *     time   : 2017/08/09
 *     desc   : 购物车fragment
 *     version: 1.0
 * </pre>
 */

public class ShopCartFragment extends BaseFragment implements View.OnClickListener {

    public static final int ACTION_EDIT = 1;
    public static final int ACTION_CAMPLATE = 2;
    private static final String TAG = "CartFragment";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.checkbox_all)
    CheckBox mCheckBox;
    @BindView(R.id.txt_total)
    TextView mTextTotal;
    @BindView(R.id.btn_order)
    Button mBtnOrder;
    @BindView(R.id.btn_del)
    Button mBtnDel;
    @BindView(R.id.toolbar)
    CNiaoToolBar mToolbar;
    @BindView(R.id.rv_bottom)
    RelativeLayout mRvBottom;
    @BindView(R.id.ll_empty)
    LinearLayout mLlEmpty;

    private ShopCartAdapter mAdapter;
    private CartShopProvider mCartShopProvider;

    @Override
    protected int getContentResourseId() {
        return R.layout.fragment_shopcart;
    }

    @Override
    protected void init() {
        LogUtil.e("生命周期", "ShopCartFragment", true);
        mCartShopProvider = new CartShopProvider(getContext());
        changeToolbar();
        showData();
    }


    /**
     * 改变标题栏
     */
    private void changeToolbar() {
        mToolbar.hideSearchView();
        mToolbar.showTitleView();
        mToolbar.setTitle(R.string.cart);
        mToolbar.getRightButton().setVisibility(View.VISIBLE);
        mToolbar.setRightButtonText("编辑");
        mToolbar.getRightButton().setOnClickListener(this);
        mToolbar.getRightButton().setTag(ACTION_CAMPLATE);
    }


    /**
     * 获取数据
     */
    private void showData() {

        List<ShoppingCart> carts = mCartShopProvider.getAll();

        Log.e("TAG","===="+carts.size());
        if (carts == null || carts.size() == 0) {
            initEmptyView();
            mToolbar.getRightButton().setVisibility(View.INVISIBLE);
            //如果数据为空,显示空的试图
            return;
        }mToolbar.getRightButton().setVisibility(View.VISIBLE);

        /**
         * 购物车数据不为空
         */
        mAdapter = new ShopCartAdapter(getContext(), carts, mCheckBox, mTextTotal);
        hideDelControl();
        mRecyclerView.setAdapter(mAdapter);
        //recyclerView本身存在一个bug,在删 添加数据同时进行时,会报错:
        // java.lang.IndexOutOfBoundsException: Inconsistency detected. Invalid view holder
        // adapter positionViewHolder{42319ed8 position=1 id=-1, oldPos=0, pLpos:0 scrap
        // tmpDetached no parent}
        //需要 重写LinearLayoutManager
        mRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));

    }

    private void initEmptyView() {
        mRvBottom.setVisibility(View.GONE);
        mLlEmpty.setVisibility(View.VISIBLE);
    }


    @OnClick({R.id.btn_del, R.id.btn_order, R.id.tv_goshop})
    public void viewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_del:
                if(mAdapter != null){
                    mAdapter.delCart();
                    initEmptyView();
                }
                break;
            case R.id.btn_order:
                Intent intent = new Intent(getContext(), CreateOrderActivity.class);
                startActivity(intent, true);
                break;
            case R.id.tv_goshop:      //如果没有商品时
                mLlEmpty.setVisibility(View.GONE);
                //跳转到homeFragment中

                //不能这样使用.replace也不行.会出现界面的重叠

                //                getActivity().getSupportFragmentManager()
                //                        .beginTransaction()
                //                        .add(R.id.realtabcontent, new HomeFragment())
                //                        .commit();

                EventBus.getDefault().post(new MessageEvent(0));

                break;
        }
    }


    @Override
    public void onClick(View view) {
        int action = (int) view.getTag();
        if(action == ACTION_EDIT){
            showDelControl();
        }else if(action == ACTION_CAMPLATE){
            hideDelControl();
        }
    }

    private void showDelControl() {
        mToolbar.getRightButton().setText("编辑");
        mBtnOrder.setVisibility(View.VISIBLE);
        mBtnDel.setVisibility(View.GONE);
        if(mAdapter != null){
            mAdapter.setNumberAddSubVisible(true);
        }
        mToolbar.getRightButton().setTag(ACTION_CAMPLATE);
    }


    private void hideDelControl(){
        mToolbar.getRightButton().setText("完成");
        mBtnOrder.setVisibility(View.GONE);
        mBtnDel.setVisibility(View.VISIBLE);
        if(mAdapter != null){

            mAdapter.setNumberAddSubVisible(false);
        }
        mToolbar.getRightButton().setTag(ACTION_EDIT);

    }

    /**
     * 刷新数据
     * <p>
     * fragment是隐藏与显示.生命周期很多没走.
     * 需要切换到购物车fragment后,进行刷新
     * <p>
     * 先将数据全部清除,再重新添加(有可能和以前一样,有可能有新数据)
     * 清除的目的,就是为了防止添加了新数据而界面上没展示
     */
    public void refData() {

        List<ShoppingCart> carts = mCartShopProvider.getAll();
        if (carts != null && carts.size() > 0) {
            mLlEmpty.setVisibility(View.GONE);
            mRvBottom.setVisibility(View.VISIBLE);
            showData();
            mAdapter.showTotalPrice();
        } else {
            initEmptyView();
            return;
        }

    }

}



