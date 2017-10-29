package com.ysn.testingframework.ui.main;

import com.ysn.testingframework.ui.base.MvpView;

/**
 * Created by yudisetiawan on 10/29/17.
 */

interface MainView extends MvpView {

    void plusNumber(int resultPlus);

    void plusNumberFailed(String message);
}
