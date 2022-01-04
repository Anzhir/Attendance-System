package tictactoe;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MiniMaxAgent 
{
    TranspositionTable tt= new TranspositionTable();
    Board game =new Board(); // custom board for evaluation
    char maxmizing_player='O';
    char minimizing_player='X';
    public static int eval;
    public CsvConvert converter;
    
    public int[] get_best_move() throws IOException
    {
       
        converter=new CsvConvert();
        int searchResult;
        char[][]new_board;
        int[] bestMove = new int[]{-1, -1};
        int bestValue = Integer.MIN_VALUE;      
        int moveVALUE;
        ArrayList<Move> moves= game.available_moves();

           for(int counter =0 ; counter < moves.size() ; counter++)
           {
               
            game.insert_on_board(moves.get(counter).row, moves.get(counter).col, 'O' );
            
            
            if(tt.transpoisition_search(game.my_board)!=-1)
            {
            moveVALUE=tt.transpoisition_search(game.my_board);
            }
            else
            {
            moveVALUE=minimax(game, 9, 'X' , -100 , 100);
            System.out.println("Current Move :" + moves.get(counter).row + moves.get(counter).col + " move value :" + moveVALUE);
            }
            
            //addons
            game.print_board();
            converter.add_line(game.my_board, moveVALUE);
            game.insert_on_board(moves.get(counter).row, moves.get(counter).col, ' ');
            if (moveVALUE > bestValue) 
                   {
                        bestMove[0] = moves.get(counter).row;
                        bestMove[1] = moves.get(counter).col;
                        bestValue = moveVALUE;
                   }
           }
           System.out.println("Best VALUE :" + bestValue);
           return bestMove;
     }

    public int minimax(Board position  , int depth , char Player , int alpha , int beta)
    {
        ArrayList<Move> available=position.available_moves();
        if(depth==0)
        {
            eval=position.evaluate();
            return eval;
        }
        else
        {
        if(position.checkWin() !='N' )
        {
           eval=position.evaluate();
           return eval;
        }
        
        }
        //////////////////////
        if(Player==maxmizing_player)
        {
            int maxEval=-99;
            for(int counter = 0; counter < available.size(); counter++)
            { 		      
                 Move move=new Move();
                 move=available.get(counter); 
                 //test
                 
                 position.insert_on_board(move.row, move.col, Player);
                 eval=minimax(position, depth-1 , 'X' , alpha , beta);
                 position.insert_on_board(move.row, move.col, ' ');
                 maxEval=Math.max(maxEval , eval);
                 alpha=Math.max(alpha, eval);
                 if (beta<=alpha)
                 {break;}
                 
            }
            return maxEval;
        }  
        else if(Player==minimizing_player)
        {
          int minEval=99;
          for(int counter=0 ; counter < available.size() ; counter++)
          {
                 Move move=new Move();
                 move=available.get(counter); 	

                 position.insert_on_board(move.row, move.col, Player);
                 eval=minimax(position, depth-1 , 'O' , alpha , beta);
                 position.insert_on_board(move.row, move.col, ' ');
                 minEval=Math.min(minEval , eval);
                 beta=Math.min(beta,eval);
                 if(beta<=alpha)
                 {break;}
          }
          return minEval;
        }
        
        return 0;
        }
        
    public int[] play_(Board board) throws IOException
    {
        
   int x=get_best_move()[0];
   int y=get_best_move()[1];
   
   board.insert_on_board(x, y, 'O');
   int []arr={x,y};
   return arr;

    }
    
}
    
