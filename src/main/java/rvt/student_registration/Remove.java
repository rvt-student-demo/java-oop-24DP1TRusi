package rvt.student_registration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Remove {
    String filePath = "data/Students.csv";

    public Remove() {
    }

    public void removeStudent(String codeDelete) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/Students.csv"));
            String[] lines = new String[100];
            int count = 0;
            String line;
            Boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String code = parts[3];

                if (code.equals(codeDelete)) {
                    found = true;
                } else {
                    lines[count++] = line;
                }
            }
            br.close();
            if (!found) {
                System.out.println("Šāds skolēns netika atrasts!");
                return;
            }

            FileWriter fw = new FileWriter("data/Students.csv");
            for (int i = 0; i < count; i++) {
                fw.write(lines[i] + "\n");
            }
            fw.close();
            System.out.println("Skolēns veiksmīgi izdzēsts!");

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
}
