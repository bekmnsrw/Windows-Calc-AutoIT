package com.autoit.calc.config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Properties;

public class Settings {

    public static String pathToSettingXml = "/C:/Users/ilyab/Repositories/IdeaProjects/AutoIT/src/test/resources/settings.xml";
    public static String entryTagName = "entry";
    public static String keyAttributeName = "key";
    public static String CALCULATOR = "calculator";
    public static String LOCALHOST = "localhost";

    private static final Properties properties = new Properties();
    private static String calc;
    private static String localhost;

    static {
        try {
            File file = new File(pathToSettingXml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName(entryTagName);

            properties.setProperty(((Element) nodeList.item(0)).getAttribute(keyAttributeName), nodeList.item(0).getTextContent());
            properties.setProperty(((Element) nodeList.item(1)).getAttribute(keyAttributeName), nodeList.item(1).getTextContent());
        } catch (Exception ignored) {}
    }

    public static String getCalc() {
        if (calc == null) { calc = properties.getProperty(CALCULATOR); }
        return calc;
    }

    public static String getLocalhost() {
        if (localhost == null) { localhost = properties.getProperty(LOCALHOST); }
        return localhost;
    }
}
