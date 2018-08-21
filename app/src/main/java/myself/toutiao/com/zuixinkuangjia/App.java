package myself.toutiao.com.zuixinkuangjia;

import myself.toutiao.com.zuixinkuangjia.app.BaseApplication;

public class App extends BaseApplication {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }
}
