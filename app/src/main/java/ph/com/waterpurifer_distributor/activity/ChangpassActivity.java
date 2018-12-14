package ph.com.waterpurifer_distributor.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import butterknife.OnClick;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.base.BaseActivity;
import ph.com.waterpurifer_distributor.base.MyApplication;


public class ChangpassActivity extends BaseActivity {
    MyApplication application;
    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        setSteepStatusBar(true);
        return R.layout.activity_changepass;
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
    @OnClick({R.id.iv_main_memu,R.id.bt_chan_qd})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_main_memu:
                finish();
                break;

            case R.id.bt_chan_qd:

                break;
        }
    }

}
