package myself.toutiao.com.zuixinkuangjia.base.factory;
import myself.toutiao.com.zuixinkuangjia.base.presenter.BaseMvpPresenter;
import myself.toutiao.com.zuixinkuangjia.base.view.BaseMvpView;

/*  Presenter工厂实现类 */
public class PresenterMvpFactoryImpl<V extends BaseMvpView,P extends BaseMvpPresenter<V>> implements PresenterMvpFactory<V,P>{
    // 需要创建的Presenter的类型
    private  Class<P> mPresenterClass;

    //根据注解创建Presenter的工厂实现类
    public static <V extends BaseMvpView,P extends BaseMvpPresenter<V>> PresenterMvpFactoryImpl<V,P> createFactory(Class<?> viewClazz){
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if(annotation != null){
            aClass = (Class<P>) annotation.value();
        }
        return aClass == null ? null : new PresenterMvpFactoryImpl<V, P>(aClass);
    }

    public PresenterMvpFactoryImpl(Class<P> mPresenterClass) {
        this.mPresenterClass = mPresenterClass;
    }

    @Override
    public P createMvpPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }
}












































