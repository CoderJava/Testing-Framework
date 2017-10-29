package com.ysn.testingframework;

import com.ysn.testingframework.ui.main.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by yudisetiawan on 10/29/17.
 */
@RunWith(JUnit4.class)
public class MainActivityTest {


    private MainPresenter mainPresenter;

    @Before
    public void initSetup() {
        mainPresenter = new MainPresenter();
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

}