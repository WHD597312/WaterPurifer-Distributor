package ph.com.waterpurifer_distributor.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.base.BaseActivity;
import ph.com.waterpurifer_distributor.base.MyApplication;

public class UserdetailsActivity extends BaseActivity {
    MyApplication application;
    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        setSteepStatusBar(true);
        return R.layout.activity_user;
    }

    @Override
    public void initView(View view) {
        if (application == null) {
            application = (MyApplication) getApplication();
        }
        application.addActivity(this);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @OnClick({R.id.iv_user_fh,R.id.rl_user_equxq})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_user_fh:
                finish();
                break;

            case R.id.rl_user_equxq:
                startActivity(EqupmentxqActivity.class);
                break;
        }

    }
}
