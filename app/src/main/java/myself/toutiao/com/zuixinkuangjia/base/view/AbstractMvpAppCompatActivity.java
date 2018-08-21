package myself.toutiao.com.zuixinkuangjia.base.view;
import android.os.Bundle;
import android.support.annotation.Nullable;
import myself.toutiao.com.zuixinkuangjia.base.BaseActivity;
import myself.toutiao.com.zuixinkuangjia.base.factory.PresenterMvpFactory;
import myself.toutiao.com.zuixinkuangjia.base.factory.PresenterMvpFactoryImpl;
import myself.toutiao.com.zuixinkuangjia.base.presenter.BaseMvpPresenter;
import myself.toutiao.com.zuixinkuangjia.base.proxy.BaseMvpProxy;
import myself.toutiao.com.zuixinkuangjia.base.proxy.PresenterProxyInterface;

//activity基类
public class AbstractMvpAppCompatActivity <V extends BaseMvpView,P extends BaseMvpPresenter<V>>
        extends BaseActivity implements PresenterProxyInterface<V,P> {

    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";

    // 创建被代理对象,传入默认Presenter的工厂
    private BaseMvpProxy<V, P> mProxy = new BaseMvpProxy<>(PresenterMvpFactoryImpl.<V, P>createFactory(getClass()));

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getMvpPresenter() {
        return mProxy.getMvpPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
        mProxy.onResume((V) this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxy.onDestroy();
        isDestroy = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle(PRESENTER_SAVE_KEY, mProxy.onSaveInstanceState());
    }
}






































