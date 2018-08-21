package myself.toutiao.com.zuixinkuangjia.base.factory;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import myself.toutiao.com.zuixinkuangjia.base.presenter.BaseMvpPresenter;
import myself.toutiao.com.zuixinkuangjia.base.proxy.BaseMvpProxy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends BaseMvpPresenter> value();
}
