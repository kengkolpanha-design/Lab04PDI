package lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        String name = "Test.csv";
        File f = new File(name);
        Random random = new Random();

        // Step 1: Create the file and write 500 random numbers
        try {
            if (f.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File already exists.");
            }

            FileWriter fw = new FileWriter(f);

            for (int k = 1; k <= 500; k++) {
                int number = random.nextInt(1000) + 1;
                fw.write(number + "\n");
            }

            fw.close();

            System.out.println("500 random numbers saved!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return;
        }

        // Step 2: Read the file and display the numbers
        System.out.println("\nReading Test.csv:");

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
