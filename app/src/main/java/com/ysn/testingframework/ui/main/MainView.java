package com.ysn.testingframework.ui.main;

import com.ysn.testingframework.ui.base.MvpView;

/**
 * Created by yudisetiawan on 10/29/17.
 */

public interface MainView extends MvpView {

    void plusNumber(int resultPlus);

    void plusNumberFailed(String message);

    void minusNumber(int resultMinus);

    void minusNumberFailed(String message);

    void multiplicationFailed(String message);

    void multiplicationNumber(int resultMultiplication);

    void divideNumberFailed(String message);

    void divideNumber(int resultDivide);

    void testing();
}
