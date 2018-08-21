package myself.toutiao.com.zuixinkuangjia.view;

import myself.toutiao.com.zuixinkuangjia.base.view.BaseMvpView;

interface SplashView<T> extends BaseMvpView {

    void onSuccess(T t);
    void onError(String message);

}
