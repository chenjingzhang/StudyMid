package myself.toutiao.com.zuixinkuangjia.http;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static class SingletonHolder {
        private static final RetrofitHelper INSTANCE = new RetrofitHelper();
    }
    //获取单例
    public static RetrofitHelper getInstance() {
        return RetrofitHelper.SingletonHolder.INSTANCE;
    }

//
//    private RetrofitHelper() {
//        // 初始化Retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.apiopen.top/")
//                .addConverterFactory(GsonConverterFactory.create()) // json解析
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
//                .client(getOkHttpClient()) //打印请求参数
//                .build();
//        retrofitService = retrofit.create(RetrofitService.class);
//    }
//
//    private OkHttpClient getOkHttpClient(){
//        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
//        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//        httpClientBuilder.addInterceptor(new HttploggingInterceptor());
//        return  httpClientBuilder.build();
//    }
}
