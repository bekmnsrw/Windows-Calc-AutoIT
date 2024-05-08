package com.autoit.calc;

import com.autoit.calc.base.HelperBase;
import com.autoit.calc.config.Settings;
import com.autoit.calc.helper.CalcHelper;
import com.autoit.calc.util.DestructorUtil;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {

    private static final String CALC = Settings.getCalc();
    private static final String LOCALHOST = Settings.getLocalhost();

    private final WiniumDriver driver;
    private final HelperBase helperBase;
    private final CalcHelper calcHelper;

    private static final ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private ApplicationManager() throws MalformedURLException {
        DesktopOptions options = new DesktopOptions();
        options.setLaunchDelay(3000);
        options.setApplicationPath(CALC);
        driver = new WiniumDriver(new URL(LOCALHOST), options);

        helperBase = new HelperBase(this);
        calcHelper = new CalcHelper(this);

        DestructorUtil.addManagerDestructor(this);
    }

    public static ApplicationManager getInstance() throws MalformedURLException, InterruptedException {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public WiniumDriver getDriver() {
        return driver;
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }

    public CalcHelper getCalcHelper() {
        return calcHelper;
    }
}
