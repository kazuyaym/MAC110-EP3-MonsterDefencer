/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: BOTAO_JOGO.java                                    **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*; 

public class BOTAO_JOGO  extends confereJOGO
{
    private int originalX;
    private int originalY;
    private int i;
    GreenfootImage Imagem;
    
    public BOTAO_JOGO (int numTorre)
    {
        i = numTorre;
        switch(i) {
                case 1 :
                    setImage("arma4.png");
                    break;
                case 2 :
                    setImage("arma2.png");
                    break;
                case 3 :
                    setImage("arma3.png");
                    break;
                case 4 :
                    setImage("arma.png");
                    break;
                case 5 :
                    setImage("armalenta.png");
                    break;
                case 10:
                    setImage("borracha.png");
                    break;
                case 11 :
                    setImage("vida.png");
                    break;
                }
    }
    
    
    public void addedToWorld(World world) {
        originalX = getX();
        originalY = getY();
    }
 
    public void act() 
    { 
        if(i <= 10){ //Caso seja os botoes das torres
            if(Greenfoot.mouseDragged(this)) {
                MouseInfo mouse = Greenfoot.getMouseInfo();
                setLocation(mouse.getX(), mouse.getY());             
            }
         
            if(Greenfoot.mouseDragEnded(this)) {
                int custo = 0;
                switch(i) {
                case 1 :
                    custo = 10;
                    break;
                case 2 :
                    custo = 20;
                    break;
                case 3 :
                    custo = 50;
                    break;
                case 4 :
                    custo = 100;                   
                    break;
                case 5:
                   custo = 60;
                   break;
                }
                
                if(PodeColocar (custo) && i != 10) {
                        getWorld().addObject(new TORRE(i), getX(), getY());
                        ((cenario)getWorld()).dinheiro.adiciona(custo*(-1));
                }
                
                if(i == 10){
                    Actor torr = getOneObjectAtOffset(1, 1, TORRE.class);
           
                        if(torr != null)
                        {   
                            TORRE removeTorre = (TORRE) getOneIntersectingObject(TORRE.class);
                            removeTorre.foiRemovido();
                        }
                    }
                    
                reset(originalX, originalY);
            }        
        }
        
        else{
             if(i == 11 && Greenfoot.mouseClicked(this) && 
                                                (((cenario)getWorld()).dinheiro.Valor()) >= 500){
                  ((cenario)getWorld()).dinheiro.adiciona(-500);
                  ((cenario)getWorld()).vida.adiciona(1);
                                                }
             if(i == 12){
                if(((cenario)getWorld()).Pausado && ((cenario)getWorld()).LANGUAGE == 0)
                    setImage("ReadyPT.png");
                if(!((cenario)getWorld()).Pausado && ((cenario)getWorld()).LANGUAGE == 0)
                    setImage("ReadyPT1.png");
                if(((cenario)getWorld()).Pausado && ((cenario)getWorld()).LANGUAGE == 1)
                    setImage("Ready.png");
                if(!((cenario)getWorld()).Pausado && ((cenario)getWorld()).LANGUAGE == 1)
                    setImage("Ready1.png");
                 
                if(Greenfoot.mouseClicked(this)){
                    ((cenario)getWorld()).Pausado = false;
                }
             }
        }
  }
}
