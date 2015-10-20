/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: robo.java                                          **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*; 

public class robo  extends inimigos
   {
    final static int esquerda = 0, baixo = 1; 
       
   
    private int direcao = esquerda, contadorFumaca = 0;
    private java.awt.Color c;
    
    boolean dir = true;
    int contador = 5;
    
    public robo(int v)
    {
        vida = v;
        velocidade = 3;
        tempoAndaDevagar = 0;
        pontosAGanhar = (int)((v+1)*7.5);
        dinheiroAGanhar = (int)((v+3)*0.5);
    }


    public void act() 
    {
        move();
        imagem();
        andaEfeito();
        tempoLento();
    }   
    
    public void andaEfeito()
    {
        if(contador == 0){
            contador = 20;
            dir = !dir;
            if(dir)
                setImage("robo2.png");
            else
                setImage("robo1.png");
        }  
        contador--;
    }
    
    public void move()
    {
        if(canMove())
        {
            switch(direcao) {
                case esquerda :
                    setLocation(getX() - velocidade, getY());
                    break;
                case baixo :
                    setLocation(getX(), getY() + velocidade);
                    break;
                }
        }
        else
        {
            if(direcao == esquerda)
                direcao = baixo;
            else
                direcao = esquerda;
        }

    }
    
    public boolean canMove()
    {
        switch(direcao) {
                case esquerda :
                    c = getWorld().getColorAt(getX() - 16 , getY());
                    break;
                case baixo :
                    c = getWorld().getColorAt(getX(), getY() + 15);
                    break;
                }
        return c.equals(java.awt.Color.black);
    }
    
        public void imagem()
    {
        if(vida == 0 && contadorFumaca == 0){
            getWorld().addObject(new BUM(2), getX(), getY());
            contadorFumaca = 15;
        }
        if(vida == 0 && contadorFumaca > 0)
            contadorFumaca--;
    }
}
