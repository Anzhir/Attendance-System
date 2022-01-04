
package tictactoe;

import java.util.ArrayList;
import java.util.Collections;

public class Board 
{
    public static char [][] my_board={   
        {' ' , ' ' , ' '},
        {' ' ,  ' ' , ' '},
        {' ' , ' ' , ' ' },
    };
    public static int freePlaces_count = 9;
    
    
    public void insert_on_board(int row , int col , char Player )
    {   
    if(my_board[row][col] ==' ' && Player!=' ')
    {   
    my_board[row][col]=Player;
    freePlaces_count--;
    }
    else if(Player==' ')
    {
       my_board[row][col]=Player;
       freePlaces_count++;
    }
    else
    {
    System.out.println("Already Placed");
    }
    }
        
    
    
    public void print_board()
    {
    for(int i = 0 ; i<3 ; i++)
    {
    for(int j = 0 ; j<3 ; j++)
    {
    System.out.print(my_board[i][j] + "   ");
    
    }
    
    }
    
    }
    
    public char checkWin()
    {
        for(int i =0 ; i<3 ; i++)
        {
            //1
        if(my_board[i][0]==my_board[i][1] && my_board[i][1]==my_board[i][2] && my_board[i][0]!=' ')
        {
        return my_board[i][0];
        }
           //2
        if(my_board[0][i]==my_board[1][i] && my_board[1][i]==my_board[2][i] && my_board[0][i]!=' ' )
        {
        return my_board[0][i];
        }
           
        }
        //3 diagonal
        
        if(my_board[0][0]==my_board[1][1] && my_board[1][1]==my_board[2][2] && my_board[0][0] !=' ')
        {
        return my_board[0][0];
        
        }
        else if(my_board[2][0]==my_board[1][1] && my_board[1][1]==my_board[0][2] && my_board[0][2] !=' ')
        {
        return my_board[2][0];
        }
        //
        if(freePlaces_count==0)
        {
        return 'T';
        }
        return 'N';
    }
    
    public ArrayList available_moves()
    {
     ArrayList<Move> available=new ArrayList<Move>();
     Move move;
    for(int i =0 ; i<3 ; i++)
    {
         for(int j =0 ; j<3 ; j++)
          {
             if(my_board[i][j]==' ')
              {
               move = new Move();
               move.row=i;
               move.col=j;
               available.add(move);
              }
          }
    }
    int index = 0;
    for(int i = 0 ; i< available.size() ; i++)
    {
        if(available.get(i).row == 0 && available.get(i).col == 0)
        {
        Collections.swap(available, i, index);
        index++;
        }
        else if(available.get(i).row == 0 && available.get(i).col == 2)
        {
        Collections.swap(available, i, index);
        index++;
        }
        else if(available.get(i).row == 2 && available.get(i).col == 0)
        {
        Collections.swap(available, i, index);
        index++;
        }
        else if(available.get(i).row == 2 && available.get(i).col == 2)
        {
        Collections.swap(available, i, index);
        index++;
        }
        else if(available.get(i).row == 1 && available.get(i).col == 1)
        {
        Collections.swap(available, i, index);
        index++;
        }
    }
    return available;
    }
    
    public int evaluate()
    {
    for(int i =0 ; i<3 ; i++)
        {
            //1
        if(my_board[i][0]==my_board[i][1] && my_board[i][1]==my_board[i][2] && my_board[i][0]!=' ')
        {
         if( my_board[i][0]=='O')
             return 10;
         else if(my_board[i][0]=='X')
             return -10;
        }
           //2
        if(my_board[0][i]==my_board[1][i] && my_board[1][i]==my_board[2][i] && my_board[0][i]!=' ' )
        {
        if( my_board[0][i]=='O')
             return 10;
         else if(my_board[0][i]=='X')
             return -10;
        }
           
        }
        //3 diagonal
        
        if(my_board[0][0]==my_board[1][1] && my_board[1][1]==my_board[2][2] && my_board[0][0] !=' ')
        {
        if( my_board[0][0]=='O')
             return 10;
         else if(my_board[0][0]=='X')
             return -10;
        
        }
        else if(my_board[2][0]==my_board[1][1] && my_board[1][1]==my_board[0][2] && my_board[0][2] !=' ')
        {
        if( my_board[2][0]=='O')
             return 10;
         else if(my_board[2][0]=='X')
             return -10;
        }
        if(freePlaces_count==9)
        {
        return 0;
        }
        return 0;
    
    }
    
    
    
}