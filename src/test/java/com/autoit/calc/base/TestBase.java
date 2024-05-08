package com.autoit.calc.base;

import com.autoit.calc.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

public class TestBase {

    protected ApplicationManager applicationManager;

    @BeforeEach
    public void setUp() throws MalformedURLException, InterruptedException {
        applicationManager = ApplicationManager.getInstance();
    }
}
