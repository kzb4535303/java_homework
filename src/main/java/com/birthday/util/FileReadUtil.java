package com.birthday.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadUtil {
    public static FileReader getFile(String path) throws FileNotFoundException {
        return  new FileReader(path);
    }
    public static BufferedReader getBufferedReader(FileReader fileReader) {
        return new BufferedReader(fileReader);
    }
    public static List<String> getFileLineList (String path) {
        try {
            List<String> fileLineList = new ArrayList<>();
            BufferedReader bufferedReader = getBufferedReader(getFile(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileLineList.add(line);
            }
            return fileLineList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
