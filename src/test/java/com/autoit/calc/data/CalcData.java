package com.autoit.calc.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "calc")
public class CalcData {

    @XmlElement(name = "first_num")
    private String firstNum;

    @XmlElement(name = "second_num")
    private String secondNum;

    public CalcData() {}

    public CalcData(String firstNum, String secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public String firstNum() {
        return firstNum;
    }

    public String secondNum() {
        return secondNum;
    }
}
