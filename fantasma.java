/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: fantasma.java                                      **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*;

public class fantasma  extends inimigos
{
    final static int esquerda = 0, sul = 1, direita = 2; 
    private int direcao = direita;
    private java.awt.Color c;
    public boolean podeMorrer = false;
    
    public fantasma (int v)
    {
            vida = v;
            pontosAGanhar = (int)((v+1)*7.5);
            dinheiroAGanhar = (int)((v+2)*0.5);
            tempoAndaDevagar = 0;
            velocidade = 3; 
        
        switch (vida){
            case 6:
                setImage("Fantasma_14.png");
            break;
            case 5:
                setImage("Fantasma_14.png");
            break;
            case 4:
                setImage("Fantasma_13.png");
            break;
            case 3:
                setImage("Fantasma_13.png");
            break;
            case 2:
                setImage("Fantasma_10.png");
            break;
        }
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
                case direita :
                    setLocation(getX() + velocidade, getY());
                    break;
                case esquerda :
                    setLocation(getX() - velocidade, getY());
                    break;
                case sul :
                    setLocation(getX(), getY() + velocidade);
                    break;
                }
        }
        else
        {
            if(direcao == direita || direcao == esquerda)
                direcao = sul;
            else
                direcao = (int)(Math.random()*2.99);
        }

    }
    
    public boolean canMove()
    {
        switch(direcao) {
                case direita :
                    c = getWorld().getColorAt(getX() + 12 , getY());
                    break;
                case esquerda :
                    c = getWorld().getColorAt(getX() - 12, getY());
                    break;
                case sul :
                    c = getWorld().getColorAt(getX(), getY() + 17);
                    break;
                }
        return c.equals(java.awt.Color.white);
    }   
    
        public void imagem()
    {
        if(vida == 1)
            setImage("Fantasma_000.png");
    }
}
