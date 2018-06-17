package com.cniao.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cniao.CNiaoApplication;
import com.cniao.R;
import com.cniao.activity.AddressListActivity;
import com.cniao.activity.LoginActivity;
import com.cniao.activity.MyFavoriteActivity;
import com.cniao.activity.MyOrdersActivity;
import com.cniao.bean.User;
import com.cniao.contants.Contants;
import com.cniao.utils.ToastUtils;
import com.cniao.widget.CircleTransform;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * <pre>
 *     author : 高磊华
 *     e-mail : 984992087@qq.com
 *     time   : 2017/08/02
 *     desc   : 我的 fragment
 *     version: 1.0
 * </pre>
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.img_head)
    CircleImageView mImageHead;
    @BindView(R.id.txt_username)
    TextView mTxtUserName;
    @BindView(R.id.btn_logout)
    Button mbtnLogout;


    @Override
    protected void init() {
        User user = CNiaoApplication.getInstance().getUser();
        showUser(user);
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.fragment_mine;
    }


    @OnClick({R.id.txt_my_address, R.id.txt_my_favorite, R.id.txt_my_orders, R.id.txt_username, R
            .id.img_head, R.id.btn_logout})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.txt_my_address:      //收货地址
                startActivity(new Intent(getActivity(), AddressListActivity.class), true);
                break;
            case R.id.txt_my_favorite:    //我的收藏
                startActivity(new Intent(getActivity(), MyFavoriteActivity.class), true);
                break;
            case R.id.txt_my_orders:     //我的点单
                startActivity(new Intent(getActivity(), MyOrdersActivity.class), true);
                break;
            case R.id.txt_username:
            case R.id.img_head:
                User user = CNiaoApplication.getInstance().getUser();
                if (user == null) {
                    Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent2, Contants.REQUEST_CODE);
                }
                break;
            case R.id.btn_logout:
                if(CNiaoApplication.getInstance().getUser() != null){
                    ToastUtils.showSafeToast(getContext(), "退出登录成功");
                }
                CNiaoApplication.getInstance().clearUser();

                showUser(null);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        User user = CNiaoApplication.getInstance().getUser();
        showUser(user);
    }

    private void showUser(User user) {
        if (user != null) {
            mTxtUserName.setText(user.getUsername());
            int[] urls = {R.drawable.abc,R.drawable.abcd,R.drawable.abcde,R.drawable.abcef};
            Glide.with(getContext())
                    .load(user.getLogo_url())
                    .error(urls[new Random().nextInt(4)])
                    .transform(new CircleTransform(mContext))
                    .into(mImageHead);
        } else {
            mImageHead.setImageResource(R.drawable.default_head);
            mTxtUserName.setText("请登陆");
        }
    }
}
