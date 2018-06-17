package com.cniao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cniao.R;
import com.cniao.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *     author : 高磊华
 *     e-mail : 984992087@qq.com
 *     time   : 2017/08/02
 *     desc   : 热卖商品fragment
 *     version: 2.0
 * </pre>
 */
public class HotFragment extends BaseFragment {


    @BindView(R.id.ib_dapei)
    ImageButton ibDapei;
    @BindView(R.id.ib_shequ)
    ImageButton ibShequ;
    Unbinder unbinder;

    @Override
    protected void init() {
        ibDapei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showUiToast(getActivity(),"搭配师。。。。");
            }
        });

        ibShequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                String packageName = "com.yiw.circledemo";
                String className = "com.yiw.circledemo.activity.MainActivity";
                intent.setClassName(packageName, className);
                try {
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("external://shequ")));
                    startActivity(intent);
                } catch (Exception e) {
                    ToastUtils.showUiToast(getActivity(),"获取社区内容失败");
                }
            }
        });
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.fragment_shequ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
