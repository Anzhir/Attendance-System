
package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class TicTacTOE {
    
    
    public static void main(String[] args) 
    {
    Board board=new Board();
    MiniMaxAgent agent=new MiniMaxAgent();
    JFrame f= new JFrame();
    f.setSize(500, 500);
    JPanel panel = new JPanel();
    f.getContentPane().add(panel);

    

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setBounds(100, 100, 500, 500);
    panel.setLayout(new GridLayout(3, 3));
    JButton[][] grid= new JButton[3][3];

    ActionListener listener = new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) 
                
        {
            JButton source=(JButton) e.getSource();
            for(int i = 0 ;i < 3 ; i++)
            {
                for(int j = 0 ; j<3 ; j++)
                {   try{
                    if (source==grid[i][j])
                    {
                        if(board.checkWin()=='N' && source.getText()=="")
                        {
                           grid[i][j].setText("X");
                           board.insert_on_board(i, j, 'X');
                           
                           if(board.checkWin()!='N')
                           {
                            String msg=board.checkWin() + " Has Won!";
                            if(board.checkWin()=='T')
                            {
                            JOptionPane.showMessageDialog(f, "its a tie!");
                            f.dispose();
                            }
                            else
                            {
                            JOptionPane.showMessageDialog(f, msg);
                            f.dispose();
                            }
                           }
                           else
                           {
                           int []arr=agent.play_(board);
                           grid[arr[0]][arr[1]].setText("O");
                           if(board.checkWin()!='N')
                           {
                               if(board.checkWin()!='T')
                               {
                            String msg=board.checkWin() + " Has Won!";
                            JOptionPane.showMessageDialog(f,msg);
                            f.dispose();
                               }
                               else
                               {
                               JOptionPane.showMessageDialog(f, "its A Tie!");
                               f.dispose();
                               }
                           }
                           }
                           
                           
                        }
                        
                    }
                }
                catch(ArrayIndexOutOfBoundsException eX)
                {
                JOptionPane.showMessageDialog(f, "ITS A TIE!");
                }   catch (IOException ex) {
                        Logger.getLogger(TicTacTOE.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
            
        }
    };
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            grid[i][j] = new JButton();
            grid[i][j].setBorder(new LineBorder(Color.BLACK));
            grid[i][j].setFont(new Font(Font.DIALOG,Font.BOLD , 150));
            //grid[i][j].setBackground(Color.black);
            grid[i][j].setOpaque(true);
            grid[i][j].addActionListener(listener);
            grid[i][j].setBackground( Color.WHITE);
            grid[i][j].setFocusable(false);
            panel.add(grid[i][j]);
        }
    }
    f.setVisible(true);
    
    
    }
    }
