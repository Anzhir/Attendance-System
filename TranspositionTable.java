/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antoz
 */
public class TranspositionTable 
{

    
    public static Connection MyConnection = null; 
    public TranspositionTable()
    {
         try{
           MyConnection=DriverManager
                   .getConnection("jdbc:mysql://localhost:3306/tictactoe?zeroDateTimeBehavior=convertToNull"
                                  ,"root","") ;
           System.out.println("connected");
       }
       catch(SQLException x){
            System.out.println("can't connect" + x );
        } 
    }
    public int transpoisition_search(char[][] board)
    {
    Statement myStatement = null;
        try 
        {
            myStatement = MyConnection.createStatement();
        }catch (SQLException ex) 
        {
            Logger.getLogger(TranspositionTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String[] new_board={"","","","","","","","","",""};
    int counter = 0 ;
    for(int i = 0 ; i<3 ; i++)
    {
        for(int j = 0 ; j <3 ; j++)
        {
        new_board[counter]=Character.toString(board[i][j]);
        counter++;
        }
    }
    
    for(int i = 0 ; i <10 ; i++)
    {
    System.out.print(new_board[i] + "  ");
    
    }
    
    
    String my_que="SELECT `V9` FROM `boards` WHERE `V0`= '"+new_board[0]+"' AND `V1`='"+new_board[1]+"' AND `V2`='"+new_board[2]+"' AND `V3`='"+new_board[3]+"' AND `V4`='"+new_board[4]+"' AND `V5`='"+new_board[5]+"' AND `V6`='"+new_board[6]+"' AND `V7`='"+new_board[7]+"' AND `V8`='"+new_board[8]+"' ";                                               
    ResultSet myresult = null;
        try
        {
            myresult = myStatement.executeQuery(my_que);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(TranspositionTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(myresult.next())
            {
                String result = null;
                try {
                    result = myresult.getString("V9");
                    System.out.println(result);
                } catch(SQLException ex) 
                {
                    Logger.getLogger(TranspositionTable.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("found : " + result);
                return Integer.parseInt(result);
            }   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(TranspositionTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    return -1;
    }   
}