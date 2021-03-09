import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SeparatingStudents {
    public static BufferedReader stud;
    public static BufferedWriter stud18;
    public static BufferedWriter stud19;
    public static BufferedWriter stud20;
    public static int count;

    public static void openFiles() {
        System.out.println("Opening Files. \n");
        try {
            stud = new BufferedReader(new FileReader("src/resources/students.txt"));
            stud18 = new BufferedWriter(new FileWriter("src/resources/students18.txt"));
            stud19 = new BufferedWriter(new FileWriter("src/resources/students19.txt"));
            stud20 = new BufferedWriter(new FileWriter("src/resources/students20.txt"));
        } catch (IOException e) {
            System.out.println("Error opening files inside openFiles()");
        }
    }

    public static List<Integer> separateStudents(BufferedReader file) throws IndexOutOfBoundsException {

        String currentLine;
        String numLine;
        int count18 = 0;
        int count19 = 0;
        int count20 = 0;
        List<Integer> counts = new ArrayList<Integer>(4); 
        try {
            while ((currentLine = file.readLine()) != null) { // While current line is not null
                count++;
                numLine = currentLine.replaceAll("[^0-9]", ""); // Takes integers from a string.
                int num1 = Character.getNumericValue(numLine.charAt(0)); // Takes the first number.
                int num2 = Character.getNumericValue(numLine.charAt(1)); // Takes the second number.
                if (num1 == 1 && num2 == 8) { // Compares 1st and 2nd number and places the student accordingly.
                    stud18.write(currentLine);
                    stud18.newLine();
                    count18++;
                } else if (num1 == 1 && num2 == 9) {
                    stud19.write(currentLine);
                    stud19.newLine();
                    count19++;
                } else if (num1 == 2 && num2 == 0) {
                    stud20.write(currentLine);
                    stud20.newLine();
                    count20++;
                } else {
                    throw new IndexOutOfBoundsException(currentLine + " :at line " + count + ": Does not meet the requirements.");
                }
            }
            counts.add(count);
            counts.add(count18);
            counts.add(count19);
            counts.add(count20);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Error reading a line in the file. At line: " + count + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to files inside separateStudents() \n");
        }
        return counts;
    } 

    public static void closeFiles() {
        System.out.println("Reading Files and closing them.\n");
        String currentLine;
        try {
            stud.close();
            stud18.close();
            stud19.close();
            stud20.close();

            BufferedReader studReader = new BufferedReader(new FileReader("src/resources/students.txt"));
            BufferedReader stud18Reader = new BufferedReader(new FileReader("src/resources/students18.txt"));
            BufferedReader stud19Reader = new BufferedReader(new FileReader("src/resources/students19.txt"));
            BufferedReader stud20Reader = new BufferedReader(new FileReader("src/resources/students20.txt"));

            System.out.println("Students inside Students.txt file: \n");
            while ((currentLine = studReader.readLine()) != null) {
                System.out.println(currentLine);
            }
            studReader.close();

            System.out.println("");
            System.out.println("Students inside Students18.txt file: \n");
            while ((currentLine = stud18Reader.readLine()) != null) {
                System.out.println(currentLine);
            }
            stud18Reader.close();

            System.out.println("");
            System.out.println("Students inside Students19.txt file: \n");
            while ((currentLine = stud19Reader.readLine()) != null) {
                System.out.println(currentLine);
            }
            stud19Reader.close();

            System.out.println("");
            System.out.println("Students inside Students20.txt file: \n");
            while ((currentLine = stud20Reader.readLine()) != null) {
                System.out.println(currentLine);
            }
            stud20Reader.close();
        } catch (IOException e) {
            System.out.println("Error opening or closing files inside closeFiles()");
        }
    }
    
   
    public static void main(String[] args) {
        openFiles();
        System.out.println("Source, Out18, Out19, Out20");
        System.out.println(separateStudents(stud));
        closeFiles();
    }



}
