
package lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {

        File file = new File("data.csv");

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Input ID: ");
            int ID = input.nextInt();
            input.nextLine();

            System.out.print("Input Name: ");
            String Name = input.nextLine();

            System.out.print("Input Phone number: ");
            String PN = input.nextLine();

            System.out.print("Input Gender: ");
            String Gender = input.nextLine();

            System.out.print("Input Major: ");
            String Major = input.nextLine();

            // Append data to the CSV file
            try (FileWriter fw = new FileWriter(file, true)) {

                // Write the header only if the file is empty
                if (file.length() == 0) {
                    fw.write("ID,Name,Phone Number,Gender,Major\n");
                }

                // Write one new record
                fw.write(ID + "," + Name + "," + PN + ","
                        + Gender + "," + Major + "\n");
            }

            System.out.println("Data saved successfully to data.csv!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
