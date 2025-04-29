package training;

import java.io.*;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(new File("file.txt"));
             FileInputStream fin = new FileInputStream(new File("file.txt"));) {

            String str = "!OOP And Java Like I\"";
            fos.write(str.getBytes());
            fos.flush();

            int readChar = fin.read();
            while (readChar != -1) {
                if ((char)readChar == ' ')
                    System.out.println();
                else {
                    System.out.print((char) readChar);
                }
                readChar = fin.read();
            }
        } catch (FileNotFoundException e) {}
        catch (IOException e){}

        }

    }


