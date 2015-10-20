/*******************************************************************/
/**   MAC 110 - Introdu��o  a Computa��o                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exerc�cio-Programa -- Monsters Defence             **/
/**   Arquivo: inimigos.java                                      **/
/**                                                               **/
/**   B�rbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*;

public class inimigos extends Actor
{
    public int tempoAndaDevagar, velocidade, pontosAGanhar, dinheiroAGanhar, vida;
    
    public void remover()
    {
        getWorld().removeObject(this);   
    }
    
    public void levouTiroLento ()
    {
        tempoAndaDevagar = tempoAndaDevagar + 500;
        velocidade = 1;
    }
    
        public void levouTiro ()
    {
        if(vida > 0){
            vida--;
        }
        else{
            getWorld().addObject(new BUM(1), getX(), getY());
            
           ((cenario)getWorld()).counter.adiciona(pontosAGanhar);
           ((cenario)getWorld()).counter2.adiciona(-pontosAGanhar);
           ((cenario)getWorld()).dinheiro.adiciona(dinheiroAGanhar);
           
            getWorld().removeObject(this);
        }
            
    }
    
    public void tempoLento()
    {
                if(tempoAndaDevagar != 0){
            tempoAndaDevagar--;
            if(tempoAndaDevagar == 0){
                velocidade = 2;
            }
        }
    }
}