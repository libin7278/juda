package com.cniao.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cniao.CNiaoApplication;
import com.cniao.R;
import com.cniao.bean.HotGoods;
import com.cniao.bean.HotGoodsBean;
import com.cniao.contants.Contants;
import com.cniao.helper.SharePresenter;
import com.cniao.utils.CartShopProvider;
import com.cniao.utils.GlideUtils;
import com.cniao.utils.LogUtil;
import com.cniao.utils.ToastUtils;
import com.cniao.widget.CNiaoToolBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 高磊华
 * Time  2017/8/9
 * Describe: 商品详情
 */

public class GoodsDetailsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    CNiaoToolBar mToolBar;
    @BindView(R.id.iv_main)
    ImageView ivMain;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_kcun)
    TextView tvKcun;
    @BindView(R.id.tv_xiaoliang)
    TextView tvXiaoliang;
    @BindView(R.id.btn_jiarugouwuche)
    Button btnJiarugouwuche;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.iv_3)
    ImageView iv3;
    @BindView(R.id.tv_jieshao)
    TextView tvJieshao;

    //1 主页  2 分类
    private int from;
    private HotGoodsBean.ListEntity goodsBean;
    private CartShopProvider cartProvider;

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void init() {
        from = getIntent().getIntExtra("from",1);
        if(from == 1){
            //主页
            goodsBean = (HotGoodsBean.ListEntity) getIntent().getSerializableExtra(Contants.WARE);
        }else {
            //主页
            HotGoods.ListEntity goodsBean1 = (HotGoods.ListEntity) getIntent().getSerializableExtra(Contants.WARE);
            goodsBean = new HotGoodsBean.ListEntity(goodsBean1.getId(),goodsBean1.getRepertory(),goodsBean1.getAllsales(),goodsBean1.getName(),goodsBean1.getImgUrl(),(int) goodsBean1.getPrice(),goodsBean1.getSale(),goodsBean1.getDetailimageOne(),goodsBean1.getDetailimageTwo(),goodsBean1.getDetailimageThree());
        }
        if (goodsBean == null) {
            ToastUtils.showUiToast(this, "获取详情失败");
            finish();
        }

        cartProvider = new CartShopProvider(this);

        LogUtil.e("跳转后数据", goodsBean.getName() + goodsBean.getPrice()+goodsBean.getImgUrl(), true);

        initView(goodsBean);

        initToolBar(goodsBean);
    }

    private void initView(HotGoodsBean.ListEntity goodsBean) {
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getDetailimageOne(), iv1);
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getDetailimageTwo(), iv2);
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getDetailimageThree(), iv3);
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getImgUrl(), ivMain);
        tvXiaoliang.setText("总销量：" + goodsBean.getAllsales());
        tvKcun.setText("库存：" + goodsBean.getRepertory());
        tvPrice.setText(""+goodsBean.getPrice());
        tvJieshao.setText(goodsBean.getName());
    }

    private void initView(HotGoods.ListEntity goodsBean) {
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getDetailimageOne(), iv1);
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getDetailimageTwo(), iv2);
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getDetailimageThree(), iv3);
        GlideUtils.loadFull(CNiaoApplication.sContext, goodsBean.getImgUrl(), ivMain);
        tvXiaoliang.setText("总销量：" + goodsBean.getAllsales());
        tvKcun.setText("库存：" + goodsBean.getRepertory());
        tvPrice.setText(""+goodsBean.getPrice());
        tvJieshao.setText(goodsBean.getName());
    }

    /**
     * 初始化标题栏
     * @param goodsBean
     */
    private void initToolBar(final HotGoodsBean.ListEntity goodsBean) {

        mToolBar.setNavigationOnClickListener(this);
        mToolBar.setRightButtonText("分享");
        mToolBar.setRightButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePresenter.getInstance().showShareDialogOnBottom
                        (0, GoodsDetailsActivity.this, "聚搭",
                                goodsBean.getName(), "0");
            }
        });
    }

    /**
     * 初始化标题栏
     * @param goodsBean
     */
    private void initToolBar(final HotGoods.ListEntity goodsBean) {

        mToolBar.setNavigationOnClickListener(this);
        mToolBar.setRightButtonText("分享");
        mToolBar.setRightButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePresenter.getInstance().showShareDialogOnBottom
                        (0, GoodsDetailsActivity.this, "聚搭",
                                goodsBean.getName(), "0");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                this.finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_jiarugouwuche)
    public void onViewClicked() {
        cartProvider.put(goodsBean);
        Log.e("TAG","goodsBean=="+goodsBean.getId());

        ToastUtils.showSafeToast(GoodsDetailsActivity.this, "已添加到购物车");
    }
}
