/*******************************************************************/
/**   MAC 110 - Introdu��o  a Computa��o                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exerc�cio-Programa -- Monsters Defence             **/
/**   Arquivo: PORTAL.java                                        **/
/**                                                               **/
/**   B�rbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*;  

public class PORTAL  extends Actor
{
   public int j;
   public Actor OBJETO;
    public PORTAL(int fase)
    {
        j = fase;
        
         switch(j) {
                case 1 :
                    setImage("Untitled-1.png");
                    break;
                case 2 :
                    setImage("porta.png");
                    break;
                case 3:
                    setImage("PORTAL3.png");
                    break;
                }
    }
    
    public void act() 
    {
       if(chegou()){
           getWorld().addObject(new gameOver(1), 300,223);
           entra();
       }
    }    
    
    public boolean chegou()
    {
        switch (((cenario)getWorld()).FASE){
            case 1:
                   OBJETO = getOneObjectAtOffset(10, 10, dinossauro.class);
                   break;
            case 2:
                   OBJETO = getOneObjectAtOffset(10, 10, fantasma.class);
                   break;
            case 3 :
                   OBJETO = getOneObjectAtOffset(20, 20, robo.class);
                   break;
        }
        return (OBJETO != null);
    }
    
    public void entra()
    {
            getWorld().removeObject(OBJETO);
            ((cenario)getWorld()).counter.adiciona(-50);
            ((cenario)getWorld()).counter2.adiciona(50);
            ((cenario)getWorld()).vida.adiciona(-1);

    }
}
