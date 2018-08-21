package myself.toutiao.com.zuixinkuangjia.base.proxy;

import myself.toutiao.com.zuixinkuangjia.base.factory.PresenterMvpFactory;
import myself.toutiao.com.zuixinkuangjia.base.presenter.BaseMvpPresenter;
import myself.toutiao.com.zuixinkuangjia.base.view.BaseMvpView;

public interface PresenterProxyInterface<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {

     /*设置创建Presenter的工厂*/
     void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory);

     //获取Presenter的工厂类
     PresenterMvpFactory<V,P> getPresenterFactory();

     // 获取创建的Presenter
     P getMvpPresenter();


}
