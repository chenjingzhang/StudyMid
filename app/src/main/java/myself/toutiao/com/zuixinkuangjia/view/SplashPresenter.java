package myself.toutiao.com.zuixinkuangjia.view;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

import myself.toutiao.com.zuixinkuangjia.base.presenter.BaseMvpPresenter;

public class SplashPresenter extends BaseMvpPresenter<SplashView>{

    public void test(Activity activity){
        Map<String,String> map =new HashMap<>();
        map.put("id","27610708");
        map.put("page","1");
    }


}
