package com.autoit.calc.generator;

import com.autoit.calc.data.CalcData;
import com.autoit.calc.util.CalcUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Generator {

    public static final String SOURCE = "C:/Users/ilyab/Desktop";

    public static void main(String[] args) {
        String type = args[0];
        String filename = args[1];
        String format = args[2];
        if (Objects.equals(type, "calc")) GenerateCalcData(filename, format);
        else throw new IllegalArgumentException("Unrecognized type: " + type);
    }

    private static void GenerateCalcData(String filename, String format) {
        CalcData calcData = new CalcData(
                CalcUtils.getRandomNumber(),
                CalcUtils.getRandomNumber()
        );

        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(SOURCE + "/" + filename + "." + format)) { writeCalcDataToXmlFile(calcData, fileWriter); }
            catch (IOException exception) { throw new RuntimeException(exception); }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writeCalcDataToXmlFile(CalcData calcData, FileWriter fileWriter) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CalcData.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(calcData, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
