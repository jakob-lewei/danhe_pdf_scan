package tech.danhe;

import tech.danhe.service.FileAnalyzeService;
import tech.danhe.service.FilenameService;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReadMain {
    private static FilenameService filenameService = new FilenameService();
    private static FileAnalyzeService fileAnalyzeService = new FileAnalyzeService();

    public static void main(String[] args) {
        ReadMain main = new ReadMain();
        File inputFolder = main.getFileFromResources("CDS");

        List<List<File>> groupedFiles = filenameService.groupingCollege(Arrays.asList(Objects.requireNonNull(inputFolder.listFiles())));
        groupedFiles.forEach(files -> {
            System.out.println("---------------------------");
            if (files.size() <= 1) {
                fileAnalyzeService.analyzeSingleData(files);
            } else {
                fileAnalyzeService.analyzeGroupedData(files);
            }
            System.out.println("---------------------------");
        });

    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
