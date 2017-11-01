package com.ysn.testingframework.ui.main;


import com.ysn.testingframework.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

/**
 * Created by yudisetiawan on 10/29/17.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    private MainActivity mainActivity;
    private MainPresenter mainPresenter;

    private String messageInvalidInputNumber = "Invalid input number";

    @Before
    public void initSetup() {
        /*MockitoAnnotations.initMocks(this);*/
        /*mainActivity = Robolectric.setupActivity(MainActivity.class);*/
        /*mainActivity.setPresenter(mainPresenter);*/

        mainActivity = Mockito.mock(MainActivity.class);
        mainPresenter = new MainPresenter();
        mainPresenter.onAttachMvp(mainActivity);
    }

    @Test
    public void testValidNumber() {
        assertTrue(mainPresenter.isValidNumber("2", "10"));
    }

    @Test
    public void testPlusNumberPositive() {
        String inputNumberA = "2";
        String inputNumberB = "20";
        assertTrue(mainPresenter.plus(inputNumberA, inputNumberB) == 22);
    }

    @Test
    public void testPlusNumberNegative() {
        String inputNumberA = "-50";
        String inputNumberB = "20";
        assertTrue(mainPresenter.plus(inputNumberA, inputNumberB) == -30);
    }

    @Test
    public void testPlusNumberPositiveView() {
        mainPresenter.onPlusNumber("2", "2");
        Mockito.verify(mainActivity).plusNumber(4);
    }

    @Test
    public void testPlusNumberPositiveViewFailed() {
        mainPresenter.onPlusNumber("2a", "2");
        Mockito.verify(mainActivity).plusNumberFailed(messageInvalidInputNumber);
    }

    @Test
    public void testMinusNumberPositive() {
        String inputNumberA = "99";
        String inputNumberB = "5";
        assertTrue(mainPresenter.minus(inputNumberA, inputNumberB) == 94);
    }

    @Test
    public void testMinusNumberNegative() {
        String inputNumberA = "5";
        String inputNumberB = "10";
        assertTrue(mainPresenter.minus(inputNumberA, inputNumberB) == -5);
    }

    @Test
    public void testMinusNumberView() {
        mainPresenter.onMinusNumber("2", "2");
        Mockito.verify(mainActivity).minusNumber(0);
    }

    @Test
    public void testMinusNumberViewFailed() {
        mainPresenter.onMinusNumber("2a", "2");
        Mockito.verify(mainActivity).minusNumberFailed(messageInvalidInputNumber);
    }

    @Test
    public void testMultiplicationPositive() {
        String inputNumberA = "25";
        String inputNumberB = "4";
        assertTrue(mainPresenter.multiplication(inputNumberA, inputNumberB) == 100);
    }

    @Test
    public void testMultiplicationNegative() {
        String inputNumberA = "25";
        String inputNumberB = "-4";
        assertTrue(mainPresenter.multiplication(inputNumberA, inputNumberB) == -100);
    }

    @Test
    public void testMultiplicationView() {
        mainPresenter.onMultiplication("5", "5");
        Mockito.verify(mainActivity).multiplicationNumber(25);
    }

    @Test
    public void testMultiplicationViewFailed() {
        mainPresenter.onMultiplication("5a", "5");
        Mockito.verify(mainActivity).multiplicationFailed(messageInvalidInputNumber);
    }

    @Test
    public void testDividePositive() {
        String inputNumberA = "100";
        String inputNumberB = "25";
        assertTrue(mainPresenter.divide(inputNumberA, inputNumberB) == 4);
    }

    @Test
    public void testDivideNegative() {
        String inputNumberA = "100";
        String inputNumberB = "-25";
        assertTrue(mainPresenter.divide(inputNumberA, inputNumberB) == -4);
    }

    @Test
    public void testDivideView() {
        mainPresenter.onDivideNumber("5", "5");
        Mockito.verify(mainActivity).divideNumber(1);
    }

    @Test
    public void testDivideViewFailed() {
        mainPresenter.onDivideNumber("5i", "5");
        Mockito.verify(mainActivity).divideNumberFailed(messageInvalidInputNumber);
    }

    @Test
    public void testOnPlusNumber() {
        String inputNumberA = "5";
        String inputNumberB = "15";
        mainPresenter.onPlusNumber(inputNumberA, inputNumberB);
    }

}