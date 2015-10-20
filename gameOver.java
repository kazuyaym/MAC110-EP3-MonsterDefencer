/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: gameOver.java                                      **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*; 

public class gameOver extends Actor
{
    int cont = 10, i;
    
    public gameOver(int j)
    {
        i = j;
    }
    
    public void act()
    {
        if(i == 1){
            cont--;
            if(cont == 0)
            {
                getWorld().removeObject(this);
            }
        }
        else if (i == 2){
            if(((cenario)getWorld()).LANGUAGE == 0)
                setImage("GameOverPT.png");
            else
                setImage("GameOver.png");
        }
    }   
}
