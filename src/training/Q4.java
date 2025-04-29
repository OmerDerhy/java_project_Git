package training;

import java.io.*;
import java.util.Scanner;

public class Q4{
    public static void main(String[] args) {
        try (
             BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("file.txt")));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("file1.txt")));) {

            // wrting text to file
            byte[] data = new byte[1024];
            while(bin.read(data) != -1){
                bos.write(data);
            }
        } catch (FileNotFoundException e) {}
        catch (IOException e){}

    }

}


