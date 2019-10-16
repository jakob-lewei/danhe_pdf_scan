package tech.danhe.service;

import tech.danhe.obj.Data;

import java.util.List;

public class LinesAnalyzeService {
    private static final String I2 = "I2";
    private static final String C11 = "C11";
    private static final String HIGHER = "higher";
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
            if (line.contains(I2)) {
                data.setI2(line);
            }
            if (line.contains(C11) && line.contains(HIGHER)) {
                data.setC11_3_75_higher(line.substring(line.lastIndexOf(HIGHER) + HIGHER.length()).trim());
            }
            if (line.contains(C11) && line.contains(S_2_50) && line.contains(S_2_99)) {
                data.setC11_2_50_2_99(line.substring(line.lastIndexOf(S_2_99) + S_2_99.length()).trim());
            }
            if (line.contains(C11) && line.contains(S_3_00) && line.contains(S_3_24)) {
                data.setC11_3_00_3_24(line.substring(line.lastIndexOf(S_3_24) + S_3_24.length()).trim());
            }
            if (line.contains(C11) && line.contains(S_3_25) && line.contains(S_3_49)) {
                data.setC11_3_25_3_49(line.substring(line.lastIndexOf(S_3_49) + S_3_49.length()).trim());
            }
            if (line.contains(C11) && line.contains(S_3_50) && line.contains(S_3_74)) {
                data.setC11_3_50_3_74(line.substring(line.lastIndexOf(S_3_74) + S_3_74.length()).trim());
            }
        }
        return data;
    }
}
