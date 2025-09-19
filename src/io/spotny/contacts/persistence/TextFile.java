package io.spotny.contacts.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TextFile {
    private final File file;

    public TextFile(String path) {
        file = new File(path);
    }

    public void writeLine(String line) {
        FileWriter out = null;
        BufferedWriter buffer = null;
        PrintWriter writer = null;

        try {
            out = new FileWriter(file, true);
            buffer = new BufferedWriter(out);
            writer = new PrintWriter(buffer);

            writer.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            writer.close();
        }
    }

    public List<String> readLines() {
        Scanner scanner = null;
        try{
            var lines = new LinkedList<String>();
            var in = new FileReader(file);
            var buffer = new BufferedReader(in);
            scanner = new Scanner(buffer);

            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }

            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally{
            scanner.close();
        }
    }

    public void delete() {
        if (file.exists()) {
            file.delete();
        }
    }
}
