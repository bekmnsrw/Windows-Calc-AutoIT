package com.autoit.calc.util;

import com.autoit.calc.ApplicationManager;

public class DestructorUtil {

    public static void addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
    }

    public static void addManagerDestructor(ApplicationManager applicationManager) {
        addDestructor(() -> {
            try { if (applicationManager != null && applicationManager.getDriver() != null) applicationManager.getDriver().close(); }
            catch (Exception ignored) {}
        });
    }
}
