package tech.danhe.service;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import tech.danhe.obj.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAnalyzeService {

    private LinesAnalyzeService linesAnalyzeService = new LinesAnalyzeService();

    public Data analyzeSingleData(List<File> file) {
        List<String> lines = readSingleFileLines(file.get(0));
        return linesAnalyzeService.analyzeLines(lines);
    }

    public Data analyzeGroupedData(List<File> files) {
        List<String> lines = readGroupedLines(files);
        return linesAnalyzeService.analyzeLines(lines);
    }

    public List<String> readSingleFileLines(File file) {
        List<String> lines = new ArrayList<>();
        PdfReader reader = null;
        System.out.println("filename : " + file.getName());
        try {
            reader = new PdfReader(file.getAbsolutePath());

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                try {
                    String textFromPage = PdfTextExtractor.getTextFromPage(reader, i);

                    lines.addAll(Arrays.asList(textFromPage.split("\n")));

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) reader.close();
        }

        return lines;
    }

    public List<String> readGroupedLines(List<File> files) {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            lines.addAll(readSingleFileLines(files.get(i)));
        }
        return lines;
    }

}