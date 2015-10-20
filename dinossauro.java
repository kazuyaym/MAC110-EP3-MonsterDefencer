/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: dinossauro.java                                    **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*; 

public class dinossauro  extends inimigos
{
    final static int norte = 0, sul = 1, frente = 2; 
    private int direcao = frente;
    private java.awt.Color c;
    
    public dinossauro(int v)
    {
        vida = v;
        velocidade = 3;
        tempoAndaDevagar = 0;
        pontosAGanhar = (int)((v+1)*7.5);
        dinheiroAGanhar = (int)((v+2)*0.5);
    }


    public void act() 
    {
        move();
        tempoLento();
        imagem();
    }    
    
    public void move()
    {
        if(canMove())
        {
            switch(direcao) {
                case frente :
                    setLocation(getX() + velocidade, getY());
                    break;
                case norte :
                    setLocation(getX(), getY() + velocidade);
                    break;
                case sul :
                    setLocation(getX(), getY() - velocidade);
                    break;
                }
        }
        else
        {
            if(direcao == norte || direcao == sul)
                direcao = frente;
            else
                direcao = (int)(Math.random()*2.99);
        }

    }
    
    public boolean canMove()
    {
        switch(direcao) {
                case frente :
                    c = getWorld().getColorAt(getX() + 20 , getY());
                    break;
                case norte :
                    c = getWorld().getColorAt(getX(), getY() + 15);
                    break;
                case sul :
                    c = getWorld().getColorAt(getX(), getY() - 15);
                    break;
                }
        return c.equals(java.awt.Color.black);
    }
    
    public void imagem()
    {
        if(vida == 0)
            setImage("dinooo.png");
    }
}
