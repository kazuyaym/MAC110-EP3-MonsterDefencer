/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: TORRE.java                                         **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*; 
import java.util.List;

public class TORRE  extends confereJOGO
{
    private java.awt.Color c;
    
    private int cont = 0, direcao = 1, tempo, raio, i;
    List inimigos;
    
    public TORRE (int numTorre)
    {
        i = numTorre;
        switch(i) {
                case 1 :
                    raio = 50;
                    tempo = 140;
                    cont = 140;
                    setImage("arma4.png");
                    break;
                case 2 :
                    raio = 65;
                    tempo = 90;
                    cont = 90;
                    setImage("arma2.png");
                    break;
                case 3 :
                    raio = 80;
                    tempo = 50;
                    cont = 50;
                    setImage("arma3.png");
                    break;
                case 4 :
                    raio = 140;
                    tempo = 30;
                    cont = 30;
                    setImage("arma.png");
                    break;
                case 5 :
                    raio = 50;
                    tempo = 75;
                    cont = 75;
                    setImage("armalenta.png");
                    break;
                }
    }
    
    public void act()
    {     
        int faseJogo = ((cenario)getWorld()).FASE;
        
        switch (faseJogo){
            case 1 :
                inimigos = getObjectsInRange(raio, dinossauro.class);
                break;
            case 2:
                inimigos = getObjectsInRange(raio, fantasma.class);
                break;
            case 3:
                inimigos = getObjectsInRange(raio, robo.class);
                break;
            }
            
         if(inimigos.isEmpty() == false && cont == tempo){
             tiro t = new tiro(direcao, i);
             
             getWorld().addObject(t, getX(), getY());
             cont = 0;
         }
         
         direcao = verificaKey(direcao);
         if(cont < tempo)
             cont++;
    }
    
    public void foiRemovido()
    {
        getWorld().removeObject(this);
    }
}


