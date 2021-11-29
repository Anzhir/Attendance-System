/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FileReader {
    private final File file=new File("C:\\Users\\antoz\\Desktop\\students.txt");
    StringTokenizer tokenizer;
    String filecontent="";
    FileReader()
    {
    try
    {
        Scanner scan=new Scanner(file);

        while(scan.hasNextLine())
        {
        filecontent=filecontent.concat(scan.nextLine() + "\n");
          
        }
        tokenizer= new StringTokenizer(filecontent , "///");
        while(tokenizer.hasMoreTokens())
        {
        System.out.println(tokenizer.nextToken());
        }

        
    }
    catch(FileNotFoundException e)
    {
    System.out.println("FileNotFound!");
    }
    }
   
}
