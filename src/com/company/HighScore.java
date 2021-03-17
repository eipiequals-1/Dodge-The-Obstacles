package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore {

    public static void writeFile(String score) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("high_score.txt", true));
            writer.newLine();
            writer.write(score);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getMax() {
        ArrayList<Integer> lines = new ArrayList<>();
        try {
            File file = new File("high_score.txt");
            FileReader fileReader = new FileReader(file);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i) > max) {
                max = lines.get(i);
            }
        }
        */
        int max = Collections.max(lines);
        return "" + max;
    }

}
