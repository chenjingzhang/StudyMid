package myself.toutiao.com.zuixinkuangjia.base.factory;
import myself.toutiao.com.zuixinkuangjia.base.presenter.BaseMvpPresenter;
import myself.toutiao.com.zuixinkuangjia.base.view.BaseMvpView;

public interface PresenterMvpFactory<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {
    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
