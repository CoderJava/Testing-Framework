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

}