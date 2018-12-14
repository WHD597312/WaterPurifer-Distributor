package ph.com.waterpurifer_distributor.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.activity.AddDeviceActivity;
import ph.com.waterpurifer_distributor.activity.ManageActivity;
import ph.com.waterpurifer_distributor.activity.PassWordActivity;
import ph.com.waterpurifer_distributor.activity.SettingActivity;
import ph.com.waterpurifer_distributor.activity.UserActivity;
import ph.com.waterpurifer_distributor.base.BaseFragment;
import ph.com.waterpurifer_distributor.util.ToastUtil;

import static android.content.Context.MODE_PRIVATE;

public class MyFragment extends BaseFragment {
    SharedPreferences preferences;
    String pass;
    @Override
    public int bindLayout() {
        return R.layout.fragment_my;

    }

    @Override
    public void initView(View view) {
        preferences = getActivity().getSharedPreferences("my", MODE_PRIVATE);
        pass = preferences.getString("pass","");
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }
    @OnClick({R.id.rl_my_adress ,R.id.rl_my_sz ,R.id.rl_my_to,R.id.rl_my_name})
    public  void onClick (View view){
        switch (view.getId()){
            case R.id.rl_my_adress:
                //管理密码
                if (pass.length()==0){
                    startActivity(new Intent(getActivity(), ManageActivity.class));
                }else {
                    Intent intent = new Intent(getActivity(), PassWordActivity.class);
                    intent.putExtra("type",2);
                    startActivity(intent);
                }

                break;

            case R.id.rl_my_sz:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;

            case R.id.rl_my_to:
                startActivity(new Intent(getActivity(), UserActivity.class));
                break;
            case R.id.rl_my_name:
                startActivity(new Intent(getActivity(), AddDeviceActivity.class));
                break;
        }
    }
}
