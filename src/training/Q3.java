package training;

import java.io.*;
import java.util.Scanner;

public class Q3{
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("file.txt")));
             DataInputStream dis = new DataInputStream(new FileInputStream(new File("file.txt")));) {

            // wrting text to file
            dos.writeUTF("shirt");
            dos.writeDouble(499.99);
            dos.writeChar('$');
            dos.writeUTF("pants");
            dos.writeDouble(695.99);
            dos.writeChar('$');
            dos.flush();
            //reading text
            while(dis.available() !=0){
                System.out.printf("Name: %s Price: %.02f%c \n" ,dis.readUTF(),dis.readDouble(),dis.readChar());
            }
        } catch (FileNotFoundException e) {}
        catch (IOException e){}

    }

}


