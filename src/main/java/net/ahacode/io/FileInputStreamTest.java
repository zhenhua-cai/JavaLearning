package net.ahacode.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("test.txt");
            int _byte;
            while((_byte = fis.read()) != -1);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println(fis == null);
            if(fis != null){
                try{
                    fis.close();
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
