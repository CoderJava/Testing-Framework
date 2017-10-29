package com.ysn.testingframework.ui.base;

/**
 * Created by yudisetiawan on 10/29/17.
 */

public interface MvpPresenter<T extends MvpView> {

    void onAttachMvp(T mvpView);

    void onDetachMvp();

}
