
package tttdatabase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class tttdatabase {

    public static void main(String[] args) throws IOException, SQLException 
    {
       Scanner my_data=new Scanner(new File("C:\\Users\\antoz\\Desktop\\tictactoe_data.csv"));
       
       StringTokenizer tokenizer;
       String arr[]={"","","","","","","","","",""};
       int i = 0 ;
       Connection MyConnection = null; 
       String my_que;
       Statement myStatement;
       
       try{
           MyConnection=DriverManager
                   .getConnection("jdbc:mysql://localhost:3306/tictactoe?zeroDateTimeBehavior=convertToNull"
                                  ,"root","") ;
           System.out.println("connected");
       }
       catch(SQLException x){
            System.out.println("can't connect" + x );
        } 
       
           myStatement= MyConnection.createStatement();

       while(my_data.hasNext())
       {
             i=0;
             String str=my_data.next();
             tokenizer=new StringTokenizer(str,",");
             while(tokenizer.hasMoreTokens())
             {
                  String token=tokenizer.nextToken();
                  System.out.println(token);
                  arr[i]=token;
                  i++;
             }
             try{
             my_que="INSERT INTO `boards`(`V0`, `V1`, `V2`, `V3`, `V4`, `V5`, `V6`, `V7`, `V8`, `V9`) VALUES ('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"','"+arr[4]+"','"+arr[5]+"','"+arr[6]+"','"+arr[7]+"','"+arr[8]+"','"+arr[9]+"')";
             
             myStatement.executeUpdate(my_que);
             }
             catch(SQLException e)
             {
                 System.out.println(e);
             }
             
       }
    }
    }
