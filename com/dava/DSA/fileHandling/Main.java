package com.dava.DSA.fileHandling;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
//        try(InputStreamReader isr = new InputStreamReader(System.in)) {
//            System.out.print("Enter some letters: ");
//            int letter = isr.read();
//            while(isr.ready()) {
//                System.out.println((char) letter);
//                letter = isr.read();
//            }
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        String location = "C:\\Users\\laksh\\OneDrive\\Desktop\\DSA_java\\com\\dava\\DSA\\FileHandling\\text.txt";
        String newFileLocation = "C:\\Users\\laksh\\OneDrive\\Desktop\\DSA_java\\com\\dava\\DSA\\FileHandling\\file.txt";
        try(FileReader fr = new FileReader(location)) {
            int letter = fr.read();
            while (fr.ready()) {
                System.out.print((char) letter);
                letter = fr.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // used to read the file line by line
//        BufferedReader br = new BufferedReader(new FileReader(location));
//        while (br.ready()) {
//            System.out.println(br.readLine());
//        }

        //to write in the file
        FileWriter fw = new FileWriter("C:\\Users\\laksh\\OneDrive\\Desktop\\DSA_java\\com\\dava\\DSA\\FileHandling\\output.txt");
        fw.write("it's a test for fw");
        fw.close();

        System.out.println(); 

        // used to get thr input faster
        System.out.print("write something: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("you wrote: " + br.readLine());

        // output
        OutputStream os = System.out;
//        os.write(😒👌);
        System.out.println();

//        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
//            osw.write("Hello");
//        }

        FileWriter fw1 = new FileWriter(location, true);
        fw1.write("hello man, this is a test for the FileWriter class!");
        fw1.close();
        FileReader fr1 = new FileReader(location);
        int word;
        while ((word = fr1.read()) !=-1) {
            System.out.print((char) word);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(location));
        bw.write("hello ji!");
        bw.close();
        BufferedReader br1 = new BufferedReader(new FileReader(location));
        int line;
        while ((line = br1.read()) != -1) {
            System.out.print((char) line);
        }

        // creating a new file
        try {
            File file = new File(newFileLocation);
            if(file.createNewFile()) {
                System.out.println("file created successfully");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
