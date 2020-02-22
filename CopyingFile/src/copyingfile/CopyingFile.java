package copyingfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyingFile {

    public static void main(String[] args){
        String file_name;
        boolean exist = false;
        int number;
        String line;
        number = 1;
        Scanner scan = null;
        Scanner name = new Scanner(System.in);
        System.out.println("File name: ");
        file_name = name.next();
        File tFile = new File(file_name);
        try{
            scan = new Scanner(tFile);
        } catch(Exception FileNotFoundException) {
            while(!exist) {
                System.out.println("\nFile not found!");
                System.out.println("\nInput file name again: ");
                file_name = name.next();
                tFile = new File(file_name);
                try {
                    scan = new Scanner(tFile);
                    exist = true;
                } catch(Exception e) {
                    exist = false;
                }
            }
        }
        while(scan.hasNextLine()) {
            line = scan.nextLine();
            System.out.println("line " + number + " :" + line);
            number++;
        }
    }
}
