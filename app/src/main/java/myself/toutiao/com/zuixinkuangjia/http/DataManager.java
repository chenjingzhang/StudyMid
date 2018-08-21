package myself.toutiao.com.zuixinkuangjia.http;

import retrofit2.Retrofit;

public class DataManager {
    private RetrofitService retrofitService;
    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final DataManager INSTANCE = new DataManager();
    }

    //获取单例
    public static DataManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

}

































