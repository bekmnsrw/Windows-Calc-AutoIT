package com.autoit.calc.test;

import com.autoit.calc.base.TestBase;
import com.autoit.calc.data.CalcData;
import com.autoit.calc.generator.Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CalcTest extends TestBase {

    public static List<CalcData> createCalcData() {
        try {
            List<CalcData> calcData = new ArrayList<>();
            JAXBContext context = JAXBContext.newInstance(CalcData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CalcData task = (CalcData) unmarshaller.unmarshal(new File(Generator.SOURCE + "/calc.xml"));
            calcData.add(task);
            return calcData;
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @ParameterizedTest
    @MethodSource("com.autoit.calc.test.CalcTest#createCalcData")
    public void plusTestCase(CalcData calcData) throws InterruptedException {

        applicationManager.getCalcHelper().plusTwoNumbers(calcData.firstNum(), calcData.secondNum());
        Thread.sleep(1000);

        String actualResult = applicationManager.getHelperBase().getCalcResult();
        int expectedResult = applicationManager.getHelperBase().convertStringNumToIntNum(calcData.firstNum()) +
                applicationManager.getCalcHelper().convertStringNumToIntNum(calcData.secondNum());

        Assertions.assertEquals(Integer.toString(expectedResult), actualResult);
    }
}
