package com.cniao.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.cniao.R;
import com.cniao.adapter.BaseAdapter;
import com.cniao.adapter.WaresAdapter;
import com.cniao.bean.HotGoodsBean;
import com.cniao.contants.Contants;
import com.cniao.utils.GetJsonDataUtil;
import com.cniao.utils.ToastUtils;
import com.cniao.widget.CNiaoToolBar;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *     author : 高磊华
 *     e-mail : 984992087@qq.com
 *     time   : 2017/08/17
 *     desc   :商品列表
 *     version: 1.0
 * </pre>
 */

public class GoodsListActivity extends BaseActivity implements View.OnClickListener, TabLayout
        .OnTabSelectedListener {

    public static final int ACTION_LIST = 3;                //列表形式
    public static final int ACTION_GIRD = 4;                //多列形式
    private int actionType = ACTION_LIST;     //列表形式默认的值

    public static final int TAG_DEFAULT = 0;     //tabLayout 默认
    public static final int TAG_SALE = 1;     //tabLayout 价格
    public static final int TAG_PRICE = 2;     //tabLayout 销量

    @BindView(R.id.tab_layout)
    TabLayout mTablayout;
    @BindView(R.id.txt_summary)
    TextView mTxtSummary;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerview;
    @BindView(R.id.refresh_layout)
    MaterialRefreshLayout mRefreshLayout;
    @BindView(R.id.toolbar)
    CNiaoToolBar mToolbar;
    @BindView(R.id.ll_summary)
    LinearLayout mLlSummary;

    private int index;
    private List<HotGoodsBean.ListEntity> datas;
    private WaresAdapter mWaresAdapter;

    @Override
    protected void init() {
        Fresco.initialize(this);

        index = getIntent().getIntExtra(Contants.COMPAINGAIN_ID, 1);

        Log.e("TAG", index + "=======");

        initToolBar();
        initTab();
    }


    private void initToolBar() {

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsListActivity.this.finish();
            }
        });

        mToolbar.setRightButtonIcon(R.drawable.icon_grid_32);
        mToolbar.getRightButton().setTag(ACTION_LIST);
        mToolbar.setRightButtonOnClickListener(this);

        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(2000);//休眠3秒
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ToastUtils.showUiToast(GoodsListActivity.this, "数据刷新成功");
                                }
                            });
                            materialRefreshLayout.finishRefresh();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }


    private void initTab() {

        mTablayout.setOnTabSelectedListener(this);     //这一句必须放在添加tab的前面,要不然第一次进入时,没有默认的
        //    http://www.jianshu.com/p/493d40a9d38e

        TabLayout.Tab tab = mTablayout.newTab();
        tab.setText("默认");
        tab.setTag(TAG_DEFAULT);
        mTablayout.addTab(tab);

        tab = mTablayout.newTab();
        tab.setText("价格");
        tab.setTag(TAG_SALE);
        mTablayout.addTab(tab);

        tab = mTablayout.newTab();
        tab.setText("销量");
        tab.setTag(TAG_PRICE);
        mTablayout.addTab(tab);

    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_goods_list;
    }

    @Override
    public void onClick(View v) {
        //点击后,取反
        if (actionType == ACTION_LIST) {
            actionType = ACTION_GIRD;
            mToolbar.setRightButtonIcon(R.drawable.icon_list_32);
            mToolbar.getRightButton().setTag(ACTION_GIRD);
        } else {
            actionType = ACTION_LIST;
            mToolbar.setRightButtonIcon(R.drawable.icon_grid_32);
            mToolbar.getRightButton().setTag(ACTION_LIST);
        }

        showData();     //这里必须在获取一次数据,不调用的话,只会在 获取后台数据后展示.点击后不会再走showData()
    }

    @Override
    public void onTabSelected(final TabLayout.Tab tab) {

        Log.e("TAG", index + "================");
        String JsonData;
        switch (index) {
            case 1:
                if (TAG_SALE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist111.json");
                } else if (TAG_PRICE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist11.json");
                } else {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist1.json");
                }
                break;
            case 2:
                if (TAG_SALE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist222.json");
                } else if (TAG_PRICE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist22.json");
                } else {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist2.json");
                }
                break;
            case 3:
                if (TAG_SALE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist333.json");
                } else if (TAG_PRICE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist33.json");
                } else {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist3.json");
                }
                break;
            case 4:
                if (TAG_SALE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist444.json");
                } else if (TAG_PRICE == (int) tab.getTag()) {

                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist44.json");
                } else {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist4.json");
                }
                break;
            default:
                if (TAG_SALE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist111.json");
                } else if (TAG_PRICE == (int) tab.getTag()) {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist11.json");
                } else {
                    JsonData = GetJsonDataUtil.getJson(GoodsListActivity.this, "goodlist1.json");
                }
                break;
        }
        //获取assets目录下的json文件数据

        List<HotGoodsBean.ListEntity> goodList = parseData(JsonData);
        datas = goodList;

        showData();
    }

    public List<HotGoodsBean.ListEntity> parseData(String result) {    //Gson 解析
        List<HotGoodsBean.ListEntity> detail = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(result);
            JSONArray data = object.getJSONArray("list");
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                HotGoodsBean.ListEntity entity = gson.fromJson(data.optJSONObject(i).toString(),
                        HotGoodsBean.ListEntity.class);
                detail.add(entity);
                Log.e("TAG", entity.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }


    /**
     * 展示数据
     */
    private void showData() {

        if (datas != null && datas.size() > 0) {
            mTxtSummary.setText("共有" + datas.size() + "件商品");
        } else {
            mLlSummary.setVisibility(View.GONE);
            ToastUtils.showUiToast(GoodsListActivity.this, "暂无商品信息");
            return;
        }

        mWaresAdapter = new WaresAdapter(this, datas);
        mWaresAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                HotGoodsBean.ListEntity item = mWaresAdapter.getItem(position);

                Intent intent = new Intent(GoodsListActivity.this, GoodsDetailsActivity.class);
                intent.putExtra("from",1);
                intent.putExtra(Contants.WARE, item);
                startActivity(intent);
            }
        });

        //mAdatper = new HotGoodsAdapter(datas, this);
        mRecyclerview.setAdapter(mWaresAdapter);
        if (actionType == ACTION_LIST) {
            //mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

            mRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
            if (mWaresAdapter != null) {
                mWaresAdapter.resetLayout(R.layout.template_grid_wares);
                mRecyclerview.setAdapter(mWaresAdapter);
            }
        } else {
            //mRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));

            mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
            if (mWaresAdapter != null) {
                mWaresAdapter.resetLayout(R.layout.template_list_wares);
                mRecyclerview.setAdapter(mWaresAdapter);
            }
        }

        mRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration
                .HORIZONTAL));

        mWaresAdapter.notifyDataSetChanged();
    }
}
