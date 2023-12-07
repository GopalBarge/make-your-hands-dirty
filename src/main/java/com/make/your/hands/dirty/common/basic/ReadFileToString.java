package com.make.your.hands.dirty.common.basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileToString {
    public static String readFileAsString(String filePath) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded);
    }

    public static void main(String[] args) {
       //new ReverseString().getClass().getPackage().get
        String filePath = "/ReverseString.java";

        try {
            String fileContent = readFileAsString(filePath);
            System.out.println("File Content:\n" + fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
