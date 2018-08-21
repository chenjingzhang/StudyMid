package myself.toutiao.com.zuixinkuangjia.app;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BaseApplication extends Application{

    protected List<Activity> activityList;

    @Override
    public void onCreate() {
        super.onCreate();
        activityList = new ArrayList<>();
    }

    /*打开一个页面*/
    public void openActivity(@NonNull Activity activity) {
        activityList.add(0, activity);
    }

    /* 关闭一个页面*/
    public void closeActivity(@NonNull Activity activity) {
        activityList.remove(activity);
    }

    /**
     * 退出App
     */
    public void exitApp() {
        if (activityList.size() > 0) {
            for (Activity activity : activityList) {
                activity.finish();
            }
        }
    }


}

