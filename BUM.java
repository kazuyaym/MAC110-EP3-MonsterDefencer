/*******************************************************************/
/**   MAC 110 - Introdu��o  a Computa��o                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exerc�cio-Programa -- Monsters Defence             **/
/**   Arquivo: BUM.java                                    **/
/**                                                               **/
/**   B�rbara de Castro Fernandes  7577351                        **/
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
