package tech.danhe.service;

import tech.danhe.obj.Data;

import java.util.List;

public class LinesAnalyzeService {
    private static final String B1 = "B1";
    private static final String TOTAL_ALL_UNDERGRADUATES = "Total all undergraduates";
    private static final String C7 = "C7";
    private static final String C7_ACADEMIC = "Academic";
    private static final String C9 = "C9";
    private static final String C9_SAT_READING = "SAT Evidence-Based Reading and Writing";
    private static final String C9_SAT_MATH = "SAT Math";
    private static final String I2 = "I2";
    private static final String I2_Fall = "Fall 2018 Student to Faculty ratio";
    private static final String C11 = "C11";
    private static final String AND_HIGHER = "and higher";
    private static final String S_3_75 = "3.75";
    private static final String S_2_50 = "2.50";
    private static final String S_2_99 = "2.99";
    private static final String S_3_00 = "3.00";
    private static final String S_3_24 = "3.24";
    private static final String S_3_25 = "3.25";
    private static final String S_3_49 = "3.49";
    private static final String S_3_50 = "3.50";
    private static final String S_3_74 = "3.74";

    public Data analyzeLines(List<String> lines) {
        Data data = new Data();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains(I2) && line.contains(I2_Fall)) {
                String value = subString(line, I2, I2_Fall);
                data.setI2(value == null ? data.getI2() : value);
            }
            if (line.contains(C7) && line.contains(C7_ACADEMIC)) {
                String value = subString(line, C7, C7_ACADEMIC);
                data.setC7_academic(value == null ? data.getC7_academic() : value);
            }
            if (line.contains(B1) && line.contains(TOTAL_ALL_UNDERGRADUATES)) {
                String value = subString(line, B1, TOTAL_ALL_UNDERGRADUATES);
                data.setB1(value == null ? data.getB1() : value);
            }
            if (line.contains(C9) && line.contains(C9_SAT_MATH)) {
                String value = subString(line, C9, C9_SAT_MATH);
                data.setC9_sat_math(value == null ? data.getC9_sat_math() : value);
            }
            if (line.contains(C9) && line.contains(C9_SAT_READING)) {
                String value = subString(line, C9, C9_SAT_READING);
                data.setC9_sat_reading(value == null ? data.getC9_sat_reading() : value);
            }
            if (line.contains(C11) && line.contains(S_3_75)) {
                String value = subString(line, C11, S_3_75, AND_HIGHER);
                data.setC11_3_75_higher(value == null ? data.getC11_3_75_higher() : value);
            }
            if (line.contains(C11) && line.contains(S_2_50) && line.contains(S_2_99)) {
                String value = subString(line, C11, S_2_50, S_2_99);
                data.setC11_2_50_2_99(value == null ? data.getC11_2_50_2_99() : value);
            }
            if (line.contains(C11) && line.contains(S_3_00) && line.contains(S_3_24)) {
                String value = subString(line, C11, S_3_00, S_3_24);
                data.setC11_3_00_3_24(value == null ? data.getC11_3_00_3_24() : value);
            }
            if (line.contains(C11) && line.contains(S_3_25) && line.contains(S_3_49)) {
                String value = subString(line, C11, S_3_25, S_3_49);
                data.setC11_3_25_3_49(value == null ? data.getC11_3_25_3_49() : value);
            }
            if (line.contains(C11) && line.contains(S_3_50) && line.contains(S_3_74)) {
                String value = subString(line, C11, S_3_50, S_3_74);
                data.setC11_3_50_3_74(value == null ? data.getC11_3_50_3_74() : value);
            }
        }
        return data;
    }

    private String subString(String line, String... condition) {
        boolean flag = true;
        for (int i = 0; i < condition.length; i++) {
            flag &= line.contains(condition[i]);
        }
        if (flag) {
            return line.substring(line.lastIndexOf(condition[condition.length - 1]) + condition[condition.length - 1].length()).trim();
        } else {
            return null;
        }
    }
}
