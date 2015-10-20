/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: BUM.java                                    **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*; 

public class BUM extends inimigos
{
    int contadorBUM;
    
    public BUM (int i)
    {
        switch (i){
            case 1:
                setImage("pum.png");
                contadorBUM = 15;
            break;
            case 2:
                setImage("fumaca.png");
                contadorBUM = 30;
            break;
        }    
    }
    
    
    public void act() 
    {
        contadorBUM--;

        if(contadorBUM == 0){
            getWorld().removeObject(this);
        }
    }    
}
