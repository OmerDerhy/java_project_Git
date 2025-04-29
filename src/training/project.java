package training;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class project {
    public static void main(String[] args){
        try(PrintWriter pw = new PrintWriter(new File("file.txt"));
            Scanner scan=new Scanner(new File("file.txt"));){

            String str = "!OOP And Java Like I\"";
            for(int i=0;i< str.length();i++) {
                if (str.charAt(i) == ' ') {
                    pw.println();
                } else {
                    pw.print(str.charAt(i));
                }
            }
            pw.flush();
            while(scan.hasNext()){
                System.out.println(scan.nextLine());
            }


        }catch(Exception e){

        }

    }


}
