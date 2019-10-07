/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    boolean draw = false;
    int winner = 0;
    int player = 0;
    public int [][] krydsOgBolle = new int [3][3];

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        if (player == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        if(isGameOver()) return false;
        if (krydsOgBolle[col][row] == 0)
        {
            if (player == 0)
            {
                krydsOgBolle[col][row] = 1;
                player = 1;
            }
            else
            {
                krydsOgBolle[col][row] = 2;
                player = 0;
            }
            return true;
        }
        else 
        {
            return false;
        }   
    }

    public boolean isGameOver()
    {
        
        int full = 0;
        
        //Check column
       
         /*for(int i = 0; i < 3; i++){
             for(int j = 0; j < 3; j++){
                 if(krydsOgBolle[i][j] == null)
                  break;
                 if(j == 3-1)
                 {
                     return true;
                 }
             }
        
        
        */   
        
         //Check for player 0 columns
        for(int i = 0; i < 3; i++){
          if(krydsOgBolle[i][0] != 0 && krydsOgBolle[i][1] != 0 && krydsOgBolle[i][2] != 0){
              
           if(krydsOgBolle[i][0] == 1 && krydsOgBolle[i][1] == 1 && krydsOgBolle[i][2] == 1){
               
               winner = 0;
               return true;
           
           }
            
        }
        }
        //Check for player 0 rows
        for(int i = 0; i < 3; i++){
          if(krydsOgBolle[0][i] != 0 && krydsOgBolle[1][i] != 0 && krydsOgBolle[2][i] != 0){
              
           if(krydsOgBolle[0][i] == 1 && krydsOgBolle[1][i] == 1 && krydsOgBolle[2][i] == 1){
               
               winner = 0;
               return true;
           }
        }
        }
        
        //Check for player 0 diag
        if(krydsOgBolle[0][0] != 0 && krydsOgBolle[1][1] != 0 && krydsOgBolle[2][2] != 0){
              
           if(krydsOgBolle[0][0] == 1 && krydsOgBolle[1][1] == 1 && krydsOgBolle[2][2] == 1){
               
               winner = 0;
               return true;
           }
        }
        
        //check for player 0 antiDiag
        if(krydsOgBolle[0][2] != 0 && krydsOgBolle[1][1] != 0 && krydsOgBolle[2][0] != 0){
              
           if(krydsOgBolle[0][2] == 1 && krydsOgBolle[1][1] == 1 && krydsOgBolle[2][0] == 1){
               
               winner = 0;
               return true;
           }
        }
        
        //Check for player 1 columns
        for(int i = 0; i < 3; i++){
          if(krydsOgBolle[i][0] != 0 && krydsOgBolle[i][1] != 0 && krydsOgBolle[i][2] != 0){
              
           if(krydsOgBolle[i][0] == 2 && krydsOgBolle[i][1] == 2 && krydsOgBolle[i][2] == 2){
               
               winner = 1;
               return true;
           
           }
            
        }
        }
        //Check for player 1 rows
        for(int i = 0; i < 3; i++){
          if(krydsOgBolle[0][i] != 0 && krydsOgBolle[1][i] != 0 && krydsOgBolle[2][i] != 0){
              
           if(krydsOgBolle[0][i] == 2 && krydsOgBolle[1][i] == 2 && krydsOgBolle[2][i] == 2){
               
               winner = 1;
               return true;
           }
        }
        }
        
        //Check for player 1 diag
        if(krydsOgBolle[0][0] != 0 && krydsOgBolle[1][1] != 0 && krydsOgBolle[2][2] != 0){
              
           if(krydsOgBolle[0][0] == 2 && krydsOgBolle[1][1] == 2 && krydsOgBolle[2][2] == 2){
               
               winner = 1;
               return true;
           }
        }
        
        //check for player 1 antiDiag
        if(krydsOgBolle[0][2] != 0 && krydsOgBolle[1][1] != 0 && krydsOgBolle[2][0] != 0){
              
           if(krydsOgBolle[0][2] == 2 && krydsOgBolle[1][1] == 2 && krydsOgBolle[2][0] == 2){
               
               winner = 1;
               return true;
           }
        }
      
        
      
        //Check if all tiles are filled. If enough tiles are filled and noone has one, it returns true and draws
        for (int i = 0; i<krydsOgBolle.length;i++)
        {
            for (int j = 0; j<krydsOgBolle.length;j++)
             {
                if( krydsOgBolle[i][j] != 0){
                    
                    full++;
             }
             }
        }
        if(full >= 9){
        draw = true; 
        return true; 
        
        }
        return false;
        
        
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        if(draw){
            draw = false;
            return player = -1;
        
        }
        /*return currentPlayer = (lastSymbol == 'x') ? 1 : 0;*/
        return winner;
    }
public void newGame()
    {
        for (int i = 0; i<krydsOgBolle.length;i++)
        {
            for (int j = 0; j<krydsOgBolle.length;j++)
             {
                 krydsOgBolle[i][j]= 0;
                 player = 0;
             }
        }
       
        
    }


  }

