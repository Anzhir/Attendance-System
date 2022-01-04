package tictactoe;

import java.io.FileWriter;
import java.io.IOException;


public class CsvConvert {
    
 public static FileWriter csvWriter;
 public void add_line(char [][] my_board ,int eval) throws IOException
 {
     csvWriter=new FileWriter("C:\\Users\\antoz\\Desktop\\tictactoe_data.csv" , true);
        for (int i = 0 ; i< 3 ; i++){
             for(int j = 0 ; j< 3 ; j++)
             {
             csvWriter.append(my_board[i][j]);
             csvWriter.append(",");
             }
        }
        csvWriter.append(Integer.toString(eval));
        csvWriter.append(",");
        csvWriter.append("\n");
        csvWriter.close();
 }
}
