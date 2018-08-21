package myself.toutiao.com.zuixinkuangjia.http;

import java.util.Map;

import io.reactivex.Observable;
import myself.toutiao.com.zuixinkuangjia.bean.BaseModel;
import myself.toutiao.com.zuixinkuangjia.bean.DataInfo;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("satinCommentApi")
    Observable<BaseModel<DataInfo>> getDataInfo(Map<String,String> map);

}
