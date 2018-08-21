package myself.toutiao.com.zuixinkuangjia.base.proxy;

import android.os.Bundle;

import myself.toutiao.com.zuixinkuangjia.base.factory.PresenterMvpFactory;
import myself.toutiao.com.zuixinkuangjia.base.presenter.BaseMvpPresenter;
import myself.toutiao.com.zuixinkuangjia.base.view.BaseMvpView;

/* 代理实现类，用来管理Presenter的生命周期，还有和view之间的关联*/

public class BaseMvpProxy<V extends BaseMvpView,P extends BaseMvpPresenter<V>> implements PresenterProxyInterface<V,P>{
    /**
     * 获取onSaveInstanceState中bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";
    /**
     * Presenter工厂类
     */
    private PresenterMvpFactory<V, P> mFactory;
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttchView;

    public BaseMvpProxy(PresenterMvpFactory<V, P> mFactory) {
        this.mFactory = mFactory;
    }

//  设置创建Presenter的工厂
    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        this.mFactory = presenterFactory;
    }
//   获取Presenter的工厂类
    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        return mFactory;
    }
    // 获取创建的Presenter
    @Override
    public P getMvpPresenter() {
        if(mFactory!=null){
            if(mPresenter==null){
                mPresenter = mFactory.createMvpPresenter();
                mPresenter.onCreatePresenter(mBundle == null ? null : mBundle.getBundle(PRESENTER_KEY));
            }
        }
        return mPresenter;
    }
    /**
     * 绑定Presenter和view
     * @param mvpView
     */
    public void onResume(V mvpView) {
        getMvpPresenter();
        if (mPresenter != null && !mIsAttchView) {
            mPresenter.onAttachMvpView(mvpView);
            mIsAttchView = true;
        }
    }

    /**
     * 销毁Presenter持有的View
     */
    private void onDetachMvpView() {
        if (mPresenter != null && mIsAttchView) {
            mPresenter.onDetachMvpView();
            mIsAttchView = false;
        }
    }

    /**
     * 销毁Presenter
     */
    public void onDestroy() {
        if (mPresenter != null ) {
            onDetachMvpView();
            mPresenter.onDestroyPresenter();
            mPresenter = null;
        }
    }
    /**
     * 意外销毁的时候调用
     * @return Bundle，存入回调给Presenter的Bundle和当前Presenter的id
     */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        getMvpPresenter();
        if(mPresenter != null){
            Bundle presenterBundle = new Bundle();
            //回调Presenter
            mPresenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY,presenterBundle);
        }
        return bundle;
    }


    /**
     * 意外关闭恢复Presenter
     * @param savedInstanceState 意外关闭时存储的Bundler
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mBundle = savedInstanceState;

    }
}
//

















































