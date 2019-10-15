package tech.danhe.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilenameService {

    public List<List<File>> groupingCollege(List<File> allFiles) {
        allFiles.sort(Comparator.comparing(File::getName));
        List<List<File>> result = new ArrayList<>();
        String tempPrefix = "";
        List<File> currentGroup = new ArrayList<>();
        for (int i = 0; i < allFiles.size(); i++) {
            File currentFile = allFiles.get(i);
            String filename = currentFile.getName();
            Pattern pattern = Pattern.compile("^[0-9]+.*\\.pdf");
            Matcher m = pattern.matcher(filename);
            if (m.find()) {
                Pattern numPattern = Pattern.compile("^\\d+");
                Matcher numM = numPattern.matcher(filename);
                numM.find();
                String currentPrefix = numM.group();
//                System.out.println(currentPrefix);
                if (currentPrefix.equals(tempPrefix) && i != 0) {
                    currentGroup.add(currentFile);
                } else {
                    if (!currentGroup.isEmpty()) {
                        result.add(currentGroup);
                    }
                    currentGroup = new ArrayList<>();
                    tempPrefix = currentPrefix;
                }
            } else {
                System.out.println("file no match!! " + filename);
            }
        }
        return result;
    }

}
