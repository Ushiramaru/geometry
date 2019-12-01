package com.epam.interface_pyramid.impl;

import com.epam.interface_pyramid.FileLineReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class PrimitiveFileLineReader implements FileLineReader {

    @Override
    public List<String> readLines(String path) {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File file = new File(path);
            FileReader fileReader;
            fileReader = new FileReader(file);

            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            lines = new ArrayList<>();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lines;
    }

}