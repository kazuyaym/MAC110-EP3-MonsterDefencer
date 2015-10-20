/*******************************************************************/
/**   MAC 110 - Introdu��o  a Computa��o                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exerc�cio-Programa -- Monsters Defence             **/
/**   Arquivo: segueMouse.java                                    **/
/**                                                               **/
/**   B�rbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*;

public class segueMouse extends Actor
{
    public Actor botao;
    
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }        
        botao = getOneObjectAtOffset(0, 0, BOTAO_MENU.class);
        if(botao != null){
            BOTAO_MENU pressionar = (BOTAO_MENU) getOneIntersectingObject(BOTAO_MENU.class);
            pressionar.mouseEncima = true;
        }
    }
}    

