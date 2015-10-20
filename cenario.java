/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: cenario.java                                       **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/


import greenfoot.*;  
import java.util.*;


public class cenario extends World
{
    // TEXTOS PARA CONTAGEM DE PONTOS, VIDAS,...
    Textos counter;
    Textos counter2;
    Textos dinheiro;
    Textos vida;
    Textos nivel;
    public boolean acabou = false, onOff = true, Pausado = true;
    
    public int prob = 1, inicio = 50, dificul = 110, vidaMonstro = 0, FASE = 0;
    public int LANGUAGE = 1; //1 - Ingles , 0 - Portugues.
    
    public cenario()
    {    
        super(600, 450, 1);
        menu();
    }
    
        public void act() 
    {
        
        if(FASE != 0 && !Pausado)
            colocaInimigos();
        mudaDeFase();
        
        GAMEOVER();
    }
    
    public void criaLetreiros ()
    {
        switch (LANGUAGE){
            case 0:
                counter = new Textos("Pontos: ", 0);
                counter2 = new Textos("Próximo nivel: ", 160);
                vida = new Textos("Vidas: ", 10);
                nivel = new Textos("Nivel: ", 1);
            break;
            case 1:
                counter = new Textos("Points: ", 0);
                counter2 = new Textos("Next level: ", 160);
                vida = new Textos("Health: ", 10);
                nivel = new Textos("Level: ", 1);
            break;
        }
        dinheiro = new Textos("$ ", 25);
    }
    
    public void menu ()
    {
        addObject(new segueMouse(), 1, 1);
        addObject(new BOTAO_MENU(1), 300, 220);
        addObject(new BOTAO_MENU(2), 300, 295);
        addObject(new BOTAO_MENU(3), 300, 370);
        addObject(new BOTAO_MENU(9), 70, 50);
        addObject(new BOTAO_MENU(8), 130, 50);
    }
    
    public void iniciarFase1()
    {
        criaLetreiros ();
        FASE = 1;
        
        List BOTAO = getObjects(BOTAO_MENU.class);
        removeObjects(BOTAO);
        
        setBackground("FASE_1.png");
        addObject(new PORTAL(1), 565, 175);        
        addObject(new BOTAO_JOGO(5), 290, 410);
        addObject(new BOTAO_JOGO(1), 350, 410);
        addObject(new BOTAO_JOGO(2), 390, 410);
        addObject(new BOTAO_JOGO(3), 430, 410);
        addObject(new BOTAO_JOGO(4), 470, 410);
        addObject(new BOTAO_JOGO(10), 520, 410);     
        addObject(new BOTAO_JOGO(11), 455, 25);
        addObject(new BOTAO_JOGO(12), 570, 420);
        addObject(counter, 97, 24);
        addObject(counter2, 140, 50);
        addObject(nivel, 270, 35);
        addObject(dinheiro, 355, 35);
        addObject(vida, 570, 35);
        
        Pausado = true;

    }
    
    public void mudaDeFase()
    {
        switch (FASE){
            case 1 :
                if(counter.Valor() > 10095){
                    ajudaMudarDeFase();
                    setBackground("FASE_2.png");
                    addObject(new PORTAL(2), 125, 340);
                    
                }
            break;
            case 2:
                if(counter.Valor() > 20194){
                    ajudaMudarDeFase();
                    setBackground("FASE_3.png");
                    addObject(new PORTAL(3), 40, 330);
                    
                }
            break;
        }
    }

    public void ajudaMudarDeFase()
    {
        addObject(new faseCompleta(LANGUAGE), 1, 240);
        FASE++;
        dinheiro.adiciona(100);
        List monstro = getObjects(inimigos.class);
        List torre = getObjects(TORRE.class);
        List portal = getObjects(PORTAL.class);
        removeObjects(monstro);
        removeObjects(torre);
        removeObjects(portal);
        inicio += (dificul + 50);
        dificul = 110;
        prob = 1;
        counter2.adiciona(160);
        vidaMonstro = 1;
        nivel.substituiValor(1);
        
        
        Pausado = true;
                    
    }
    
    public void colocaInimigos()
    {
        switch (FASE){
            
            case 1:
                if(vida.Valor() > 0){
                    if(Greenfoot.getRandomNumber(320) < prob) {
                         addObject(new dinossauro(vidaMonstro), 0, 320);   
                    }
                    if(nivel.Valor() < 9)
                        ficaDificil ();
                }
                else if(!acabou){
                    addObject(new gameOver(2), 300, 225); 
                    acabou = true;
                }
               break;
               
            case 2:
               if(vida.Valor() > 0){   
                     if(Greenfoot.getRandomNumber(320) < prob) {
                        int h = Greenfoot.getRandomNumber(2);
                        if(h == 0)
                           addObject(new fantasma(vidaMonstro), 1, 100);   
                        else
                           addObject(new fantasma(vidaMonstro), 489, 70);   
                        }
                     if(nivel.Valor() < 9)
                         ficaDificil ();
               }                  
               else if(!acabou){
                    addObject(new gameOver(2), 300, 225); 
                    acabou = true;
               }
            break;
            
            case 3: 
                if(vida.Valor() > 0){
                    if(Greenfoot.getRandomNumber(320) < (prob)) {
                        int g = Greenfoot.getRandomNumber(3);
                        if(g == 0)
                            addObject(new robo(vidaMonstro), 599, 125); 
                        if(g == 1)
                            addObject(new robo(vidaMonstro), 599, 270); 
                        if(g == 2)
                            addObject(new robo(vidaMonstro), 599, 340); 
                    }
                    if(nivel.Valor() < 9)
                         ficaDificil ();
                    }
               else if(!acabou){
                    addObject(new gameOver(2), 300, 225); 
                    acabou = true;
                    
               }
        }
    }
    
    public void ficaDificil ()
    {
        if (counter.Valor() > inicio + dificul){
            if(onOff)
                prob++;
            else
                vidaMonstro++;  

            dinheiro.adiciona(25);
                
            onOff = !onOff;
            nivel.adiciona(1);
            inicio += dificul;
            dificul = (int)(dificul*1.55);
            counter2.adiciona(dificul);
        }
    }
    
    public void GAMEOVER()
    {
        List monstro = null;
        if(acabou){
            switch (FASE){
                case 1:
                monstro = getObjects(dinossauro.class);
            break;
                case 2:
                monstro = getObjects(fantasma.class);
            break;
                case 3:
                monstro = getObjects(robo.class);
            break;
        }
        if(monstro != null)
            removeObjects(monstro);
        }
    }
}
