package com.ysn.testingframework.ui.main;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ysn.testingframework.R;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private final String TAG = getClass().getSimpleName();
    private MainPresenter mainPresenter;

    private EditText editTextNumberAMainActivity;
    private EditText editTextNumberBMainActivity;
    private Button buttonPlusMainActivity;
    private Button buttonMinusMainActivity;
    private Button buttonMultiplicationMainActivity;
    private Button buttonDivideMainActivity;
    public TextView textViewResultMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        initViews();
        initListeners();
    }

    private void initListeners() {
        buttonPlusMainActivity.setOnClickListener(this);
        buttonMinusMainActivity.setOnClickListener(this);
        buttonMultiplicationMainActivity.setOnClickListener(this);
        buttonDivideMainActivity.setOnClickListener(this);
    }

    private void initViews() {
        editTextNumberAMainActivity = (EditText) findViewById(R.id.edit_text_number_a_activity_main);
        editTextNumberBMainActivity = (EditText) findViewById(R.id.edit_text_number_b_activity_main);
        buttonPlusMainActivity = (Button) findViewById(R.id.button_plus_activity_main);
        buttonMinusMainActivity = (Button) findViewById(R.id.button_minus_activity_main);
        buttonMultiplicationMainActivity = (Button) findViewById(R.id.button_multiplication_activity_main);
        buttonDivideMainActivity = (Button) findViewById(R.id.button_divide_activity_main);
        textViewResultMainActivity = (TextView) findViewById(R.id.text_view_result_activity_main);
    }

    private void initPresenter() {
        mainPresenter = new MainPresenter();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_plus_activity_main:
                String inputNumberA = editTextNumberAMainActivity.getText().toString().trim();
                String inputNumberB = editTextNumberBMainActivity.getText().toString().trim();
                doPlusNumber(inputNumberA, inputNumberB);
                break;
            case R.id.button_minus_activity_main:
                inputNumberA = editTextNumberAMainActivity.getText().toString().trim();
                inputNumberB = editTextNumberBMainActivity.getText().toString().trim();
                doMinusNumber(inputNumberA, inputNumberB);
                break;
            case R.id.button_multiplication_activity_main:
                inputNumberA = editTextNumberAMainActivity.getText().toString().trim();
                inputNumberB = editTextNumberBMainActivity.getText().toString().trim();
                doMultiplication(inputNumberA, inputNumberB);
                break;
            case R.id.button_divide_activity_main:
                inputNumberA = editTextNumberAMainActivity.getText().toString().trim();
                inputNumberB = editTextNumberBMainActivity.getText().toString().trim();
                doDivide(inputNumberA, inputNumberB);
                break;
        }
    }

    private void doDivide(String inputNumberA, String inputNumberB) {
        mainPresenter.onDivideNumber(inputNumberA, inputNumberB);
    }

    private void doMultiplication(String inputNumberA, String inputNumberB) {
        mainPresenter.onMultiplication(inputNumberA, inputNumberB);
    }

    private void doMinusNumber(String inputNumberA, String inputNumberB) {
        mainPresenter.onMinusNumber(inputNumberA, inputNumberB);
    }

    private void doPlusNumber(String inputNumberA, String inputNumberB) {
        mainPresenter.onPlusNumber(inputNumberA, inputNumberB);
    }

    @Override
    public void onAttachMvp() {
        mainPresenter.onAttachMvp(this);
    }

    @Override
    public void onDetachMvp() {
        mainPresenter.onDetachMvp();
    }

    private void updateResultNumber(int resultNumber) {
        textViewResultMainActivity.setText(String.format("Result: %s", resultNumber));
    }

    private void showSnackbarFailed(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void plusNumber(int resultPlus) {
        updateResultNumber(resultPlus);
    }

    @Override
    public void plusNumberFailed(String message) {
        showSnackbarFailed(message);
    }

    @Override
    public void minusNumber(int resultMinus) {
        updateResultNumber(resultMinus);
    }

    @Override
    public void minusNumberFailed(String message) {
        showSnackbarFailed(message);
    }

    @Override
    public void multiplicationFailed(String message) {
        showSnackbarFailed(message);
    }

    @Override
    public void multiplicationNumber(int resultMultiplication) {
        updateResultNumber(resultMultiplication);
    }

    @Override
    public void divideNumberFailed(String message) {
        showSnackbarFailed(message);
    }

    @Override
    public void divideNumber(int resultDivide) {
        updateResultNumber(resultDivide);
    }

    public void setPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    public void tesTypeInput(String input) {
        textViewResultMainActivity.setText(input);
    }

    @Override
    public void testing() {

    }
}
