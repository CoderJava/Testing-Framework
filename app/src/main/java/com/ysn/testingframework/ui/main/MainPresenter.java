package com.ysn.testingframework.ui.main;

import com.ysn.testingframework.ui.base.MvpPresenter;

import java.util.regex.Pattern;

/**
 * Created by yudisetiawan on 10/29/17.
 */

public class MainPresenter implements MvpPresenter<MainView> {

    private final String TAG = getClass().getSimpleName();
    private MainView mainView;
    private final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private String messageInvalidInputNumber = "Invalid input number";

    @Override
    public void onAttachMvp(MainView mvpView) {
        mainView = mvpView;
    }

    @Override
    public void onDetachMvp() {
        mainView = null;
    }

    void onPlusNumber(String inputNumberA, String inputNumberB) {
        boolean isValidInputNumber = isValidNumber(inputNumberA, inputNumberB);
        if (isValidInputNumber) {
            mainView.plusNumberFailed(messageInvalidInputNumber);
        } else {
            int resultPlus = plus(inputNumberA, inputNumberB);
            mainView.plusNumber(resultPlus);
        }
    }

    public int plus(String inputNumberA, String inputNumberB) {
        return Integer.parseInt(inputNumberA) + Integer.parseInt(inputNumberB);
    }

    public boolean isValidNumber(String inputNumberA, String inputNumberB) {
        boolean isValidNumberA = inputNumberA != null
                && !inputNumberA.isEmpty()
                && NUMBER_PATTERN.matcher(inputNumberA).matches();
        boolean isValidNumberB = inputNumberB != null
                && !inputNumberB.isEmpty()
                && NUMBER_PATTERN.matcher(inputNumberB).matches();
        return isValidNumberA && isValidNumberB;
    }

    void onMinusNumber(String inputNumberA, String inputNumberB) {
        boolean isValidInputNumber = isValidNumber(inputNumberA, inputNumberB);
        if (isValidInputNumber) {
            mainView.minusNumberFailed(messageInvalidInputNumber);
        } else {
            int resultMinus = minus(inputNumberA, inputNumberB);
            mainView.minusNumber(resultMinus);
        }
    }

    public int minus(String inputNumberA, String inputNumberB) {
        return Integer.parseInt(inputNumberA) - Integer.parseInt(inputNumberB);
    }

    void onMultiplication(String inputNumberA, String inputNumberB) {
        boolean isValidInputNumber = isValidNumber(inputNumberA, inputNumberB);
        if (isValidInputNumber) {
            mainView.multiplicationFailed(messageInvalidInputNumber);
        } else {
            int resultMultiplication = multiplication(inputNumberA, inputNumberB);
            mainView.multiplicationNumber(resultMultiplication);
        }
    }

    public int multiplication(String inputNumberA, String inputNumberB) {
        return Integer.parseInt(inputNumberA) * Integer.parseInt(inputNumberB);
    }

    void onDivideNumber(String inputNumberA, String inputNumberB) {
        boolean isValidInputNumber = isValidNumber(inputNumberA, inputNumberB);
        if (isValidInputNumber) {
            mainView.divideNumberFailed(messageInvalidInputNumber);
        } else {
            int resultDivide = divide(inputNumberA, inputNumberB);
            mainView.divideNumber(resultDivide);
        }
    }

    public int divide(String inputNumberA, String inputNumberB) {
        return Integer.parseInt(inputNumberA) / Integer.parseInt(inputNumberB);
    }
}
