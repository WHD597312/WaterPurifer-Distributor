package ph.com.waterpurifer_distributor.activity;


import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.base.BaseActivity;
import ph.com.waterpurifer_distributor.base.MyApplication;
import ph.com.waterpurifer_distributor.util.view.ScreenSizeUtils;


public class LoginActivity extends BaseActivity {
    MyApplication application;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_pswd)
    EditText et_pswd;
    @BindView(R.id.image_seepwd)
    ImageView image_seepwd;
    SharedPreferences preferences;
    boolean isHideFirst;
    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        setSteepStatusBar(true);
        return R.layout.activity_login;
    }

    @Override
    public void initView(View view) {
        if (application == null) {
            application = (MyApplication) getApplication();
        }
        application.addActivity(this);
        preferences = getSharedPreferences("my", MODE_PRIVATE);


    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {


    }
    @OnClick({R.id.btn_login,  R.id.tv_forget_pswd, R.id.image_seepwd})
    public void onClick(View view){
        switch (view.getId()) {


//                ToastUtil.showShort(this,"注册");



            case R.id.btn_login:
               /* phone = et_name.getText().toString().trim();
                password = et_pswd.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    Utils.showToast(this, "账号码不能为空");
                    break;
                } else if (!Mobile.isMobile(phone)) {
                    Utils.showToast(this, "手机号码不合法");
                    break;
                }
                if (TextUtils.isEmpty(password)) {
                    Utils.showToast(this, "请输入密码");
                    break;
                }
                boolean isConn = NetWorkUtil.isConn(MyApplication.getContext());
                if (isConn){
                    showProgressDialog("正在登录，请稍后...");
                    Map<String, Object> params = new HashMap<>();
                    params.put("phone", phone);
                    params.put("password", password);
                    new LoginAsyncTask().execute(params);
                }else {
                    Utils.showToast(this, "无网络可用，请检查网络");
                }

                ToastUtil.showShort(this,"登录");
*/      startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tv_forget_pswd:
                ShareDialog();
                break;
            case R.id.image_seepwd:

                if (isHideFirst) {
                    image_seepwd.setImageResource(R.mipmap.login_see);
                    //密文
                    HideReturnsTransformationMethod method1 = HideReturnsTransformationMethod.getInstance();
                    et_pswd.setTransformationMethod(method1);
                    isHideFirst = false;
                } else {
                    image_seepwd.setImageResource(R.mipmap.login_seeno);
                    //密文
                    TransformationMethod method = PasswordTransformationMethod.getInstance();
                    et_pswd.setTransformationMethod(method);
                    isHideFirst = true;

                }
                // 光标的位置
                int index = et_pswd.getText().toString().length();
                et_pswd.setSelection(index);
                break;

        }

    }
    /**
     * 自定义对话框
     */
    private void ShareDialog() {
        final Dialog dialog = new Dialog(this, R.style.MyDialog);
        View view = View.inflate(this, R.layout.dialog_forgtpassword, null);
        dialog.setContentView(view);
        //使得点击对话框外部不消失对话框
        dialog.setCanceledOnTouchOutside(true);
        //设置对话框的大小
        view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight() * 0.23f));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth() * 0.75f);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        dialog.show();
    }



    @Override
    protected void onStart() {
        super.onStart();

        if (preferences.contains("phone") && !preferences.contains("password")) {
            String phone = preferences.getString("phone", "");
            et_name.setText(phone);
            et_pswd.setText("");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
