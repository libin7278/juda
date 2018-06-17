package com.cniao.activity;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cniao.R;
import com.cniao.adapter.SecondGoodsAdapter;
import com.cniao.bean.HotGoods;
import com.cniao.contants.Contants;
import com.cniao.utils.GetJsonDataUtil;
import com.google.gson.Gson;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *   author : 高磊华
 *   e-mail : 984992087@qq.com
 *   time   : 2017/08/30
 *   desc   : 搜索结果
 * </pre>
 */

public class SearchResultActivity extends BaseActivity {

    private SecondGoodsAdapter mSecondGoodsAdapter;

    @BindView(R.id.recyclerview_wares)
    RecyclerView mRecyclerviewWares;

    private List<HotGoods.ListEntity> datas;

    @Override
    protected void init() {
        int type_search = getIntent().getIntExtra("type_search", 1);

        Log.e("TAG","type_search=="+type_search);
        requestWares(type_search);

    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_search_result;
    }

    private void requestWares(int firstCategorId) {
        String JsonData = null;
        if(firstCategorId == 1){
            JsonData = GetJsonDataUtil.getJson(this, "fenlei1.json");
        }else if(firstCategorId == 2){
            JsonData = GetJsonDataUtil.getJson(this, "fenlei2.json");
        }else if(firstCategorId == 3){
            JsonData = GetJsonDataUtil.getJson(this, "fenlei3.json");
        }else if(firstCategorId == 4){
            JsonData = GetJsonDataUtil.getJson(this, "fenlei4.json");
        }else if(firstCategorId == 5){
            JsonData = GetJsonDataUtil.getJson(this, "fenlei5.json");
        }else {
            JsonData = GetJsonDataUtil.getJson(this, "fenlei1.json");
        }
        HotGoods hotGoods = parseData(JsonData);

        datas = hotGoods.getList();

        showData();
    }

    public HotGoods parseData(String result) {    //Gson 解析
        HotGoods detail = new HotGoods();
        try {
            Gson gson = new Gson();
            HotGoods hotGoods = gson.fromJson(result, HotGoods.class);
            Log.e("hotGoods","hotGoods=="+hotGoods);
            return hotGoods;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    /**
     * 展示二级菜单的数据
     */
    private void showData() {
        mSecondGoodsAdapter = new SecondGoodsAdapter(this, datas);
        mSecondGoodsAdapter.setOnItemClickListener(new MultiItemTypeAdapter
                .OnItemClickListener() {

            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int
                    position) {

                HotGoods.ListEntity listBean = datas.get(position);

                Intent intent = new Intent(SearchResultActivity.this, GoodsDetailsActivity.class);
                intent.putExtra(Contants.WARE,listBean);
                intent.putExtra("from",2);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int
                    position) {
                return false;
            }
        });

        mRecyclerviewWares.setAdapter(mSecondGoodsAdapter);
        mRecyclerviewWares.setLayoutManager(new GridLayoutManager(this, 1));
        //                mRecyclerviewWares.setLayoutManager(new LinearLayoutManager
        // (getContext()));
        mRecyclerviewWares.setItemAnimator(new DefaultItemAnimator());
        mRecyclerviewWares.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.HORIZONTAL));
    }
}
