package myself.toutiao.com.zuixinkuangjia.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import myself.toutiao.com.zuixinkuangjia.App;
import myself.toutiao.com.zuixinkuangjia.app.AppStatusConstant;
import myself.toutiao.com.zuixinkuangjia.app.AppStatusManager;

/*使用RxLifeCycle是因为在使用Rxjava的过程中,当发布一个订阅后,页面被finsh,
  此时订阅的逻辑还没完成,容易引发内存泄漏的问题.
  所以RxLifeCircle可以通过compose()手动/自动关闭没完成的逻辑对象  */

public class BaseActivity extends RxAppCompatActivity implements View.OnClickListener {
    protected boolean isDestroy = false;

    public LifecycleTransformer getLifecycleTransformer() {
        return bindUntilEvent(ActivityEvent.DESTROY);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppStatusManager.getInstance().getAppStatus() == AppStatusConstant.STATUS_FORCE_KILLED) {
//            restartApp();
            return;
        }
        App.getInstance().openActivity(this);
    }

    @Override
    protected void onDestroy() {
        isDestroy = true;
        super.onDestroy();
        App.getInstance().closeActivity(this);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            hideSoftKeyBoard();
            onEnterPressed();
            return true;
            //点击返回键时候
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            onBackKeyPressed();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /*隐藏软键盘*/
    public void hideSoftKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && inputMethodManager.isActive() && getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    //当软键盘enter按键被按下时候，此方法会被调用，此方法需要子类重写
    public void onEnterPressed() {

    }

    //如果子类需要在点击返回键时候，做一些事情，重写下面方法即可
    public void onBackKeyPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {

    }
}