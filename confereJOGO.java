/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: confereJOGO.java                                   **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*;
import java.util.List;

public class confereJOGO  extends Actor
{
    private java.awt.Color d,e,c,b;    

    public boolean PodeColocar (int precoTorre)
    {
        if(!(getY() < 70 || getY() > 380 || getX() < 20 || getX() > 580)){ 
            //Antes de verificar fundo e outras caracteristicas, primeiro verifica se esta dentro da area permitida, se nao da ERRO!
            List torre = getObjectsInRange(25, TORRE.class);
            List portal = getObjectsInRange(25, PORTAL.class);
            boolean din =  (((cenario)getWorld()).dinheiro.Valor()) >= precoTorre;
            return !(verificaCor() || !torre.isEmpty() || !portal.isEmpty() ||!din);
        }
        return false;
    }
    
    public boolean verificaCor()
    {
        boolean fundo = false;
        
        d = getWorld().getColorAt(getX() + 12 , getY());
        e = getWorld().getColorAt(getX() - 12 , getY());
        c = getWorld().getColorAt(getX(), getY() - 12);
        b = getWorld().getColorAt(getX(), getY() + 12);
        
        switch (((cenario)getWorld()).FASE){
            case 2:
                fundo = (d.equals(java.awt.Color.white) || e.equals(java.awt.Color.white)
            || c.equals(java.awt.Color.white) || b.equals(java.awt.Color.white));
            break;
            default : //case 1: || case 3:
                fundo = (d.equals(java.awt.Color.black) || e.equals(java.awt.Color.black)
            || c.equals(java.awt.Color.black) || b.equals(java.awt.Color.black));
            break;
            
        }
        return fundo;
    }
    
    public void reset(int x, int y) 
    {
        setLocation(x, y);
    }
    
    public int verificaKey(int direcao){
     
        if(Greenfoot.mouseClicked(this)){
            setRotation(getRotation() + 90);
            
            if(++direcao == 5)
                direcao = 1;
        }
        return direcao;
    }
}
