package com.autoit.calc.base;

import com.autoit.calc.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;

public class HelperBase {

    protected ApplicationManager applicationManager;
    protected WiniumDriver driver;

    private static final String CALC_RESULT = "CalculatorResults";
    private static final String CALC_RESULT_NAME = "Name";


    public HelperBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    public String getCalcResult() {
        String result = driver.findElement(By.id(CALC_RESULT)).getAttribute(CALC_RESULT_NAME);
        int lastIndex = result.lastIndexOf(" ");
        return result.substring(lastIndex + 1);
    }

    public int convertStringNumToIntNum(String stringNum) {
        return switch (stringNum) {
            case "One" -> 1;
            case "Two" -> 2;
            case "Three" -> 3;
            case "Four" -> 4;
            case "Five" -> 5;
            case "Six" -> 6;
            case "Seven" -> 7;
            case "Eight" -> 8;
            case "Nine" -> 9;
            default -> 0;
        };
    }
}
