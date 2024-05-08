package com.autoit.calc.helper;

import com.autoit.calc.ApplicationManager;
import com.autoit.calc.base.HelperBase;
import org.openqa.selenium.By;

public class CalcHelper extends HelperBase {

    public static final String PLUS = "Plus";
    public static final String EQUALS = "Equals";

    public CalcHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void plusTwoNumbers(String firstNum, String secondNum) {
        driver.findElement(By.name(firstNum)).click();
        driver.findElement(By.name(PLUS)).click();
        driver.findElement(By.name(secondNum)).click();
        driver.findElement(By.name(EQUALS)).click();
    }
}
