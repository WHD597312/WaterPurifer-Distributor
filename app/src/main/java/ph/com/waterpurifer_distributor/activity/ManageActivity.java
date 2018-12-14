package ph.com.waterpurifer_distributor.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.base.BaseActivity;
import ph.com.waterpurifer_distributor.base.MyApplication;
import ph.com.waterpurifer_distributor.util.ToastUtil;

public class ManageActivity extends BaseActivity {
    MyApplication application;
    SharedPreferences preferences;
    @BindView(R.id.et_man_pass)
    EditText  et_man_pass;
    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        setSteepStatusBar(true);
        return R.layout.activity_manage;
    }

    @Override
    public void initView(View view) {
        if (application == null) {
            application = (MyApplication) getApplication();
        }
        preferences = getSharedPreferences("my", MODE_PRIVATE);
        application.addActivity(this);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }
    @OnClick({R.id.iv_back,R.id.bt_man_qd})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_man_qd:
                if (et_man_pass.getText().toString().length()<4){
                    ToastUtil.showShort(this,"请输入四位数的数字密码");
                }else  if (et_man_pass.getText().toString().length()==4){
                    String pass = et_man_pass.getText().toString();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("pass",pass);
                    editor.commit();
                    ToastUtil.showShort(this,"设置成功");
                    finish();
                }

                break;
        }
    }
}
