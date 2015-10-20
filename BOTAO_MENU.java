/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: BOTAO_MENU.java                                    **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*; 
import java.util.*;

public class BOTAO_MENU  extends Actor
{
    private int numBotao, contador = 5;
    public boolean mouseEncima = false, podeDeletar = false;
    public Actor voltar;
    static int paginaINSTRU = 0;
    
    
    public BOTAO_MENU (int i)
    {
        numBotao = i;
    }
    
    

    public void act() 
    {
        mouse();
        mouseEncima = false;

        //Seta
        if(numBotao == 4)
            efeito ();
            
            
        if(podeDeletar){
            contador--;
            if(contador == 0)
                delete();
        }
    }  
    
    
    
    public void efeito (){      //Caso o botão seja a seta, faz ela descer =)
        if(getY() != 391)
            setLocation(getX(), getY()+5);
    }
    
    
    
    public void mouse()
    {
        if(mouseEncima){    //Caso o mouse esteje encima do botão, efeito pressionado
           switch (numBotao){
           case 1:
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("iniciar1.png");
                else
                    setImage("iniciarEN1.png");
           break;
           case 2:
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("instru1.png");
                else
                    setImage("instruEN1.png");
           break;
           case 3 :
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("credit1.png");
                else
                    setImage("creditEN1.png");
           break;
           case 4 :
                setImage("voltar1.png");
           break;
           case 8 :
                setImage("Bandeira_brasil_pressionada.png");
           break;
           case 9 :
                setImage("Bandeira_ingles_pressionada.png");
           break;
          }
        }
        else{   //Imagem de cada botao
            switch (numBotao){
            case 1:
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("iniciar.png");
                else
                    setImage("iniciarEN.png");
            break;
            case 2 :
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("instru.png");
                else
                    setImage("instruEN.png");
            break;
            case 3:
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("credit.png");
                else
                    setImage("creditEN.png");
            break;
            case 4:
                setImage("voltar.png");
            break;
            case 5:
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("instruENTRADA.png");
                else
                    setImage("instruENTRADAEN.png");
            break;
            case 6:
                if(((cenario)getWorld()).LANGUAGE == 0)
                    setImage("creditos.png");
                else
                    setImage("creditosEN.png");
            break;
            case 7: // segundfa pagina  INSTRUÇÕES
                if(((cenario)getWorld()).LANGUAGE == 0)
                   setImage("instruENTRADA2.png");
                else
                   setImage("instruENTRADA2EN.png");
                
            break;
            case 8:
                setImage("Bandeira_brasil_sem_pressionar.png");
            break;
            case 9:
                setImage("Bandeira_ingles_sem_pressionar.png");
            break;
            case 10:
                // ??
            break;
            }
        }
        
        // Caso apertem no botão
        if(Greenfoot.mouseClicked(this)){
            switch (numBotao){
            case 1 :
                //INICIAR JOGO!
                ((cenario) getWorld()).iniciarFase1();
            break;
            case 2 :
                //Instruções
                ((cenario) getWorld()).addObject(new BOTAO_MENU(5), 300, 205);
                ((cenario) getWorld()).addObject(new robo(4), 95, 120);
                ((cenario) getWorld()).addObject(new robo(4), 500, 120);
                ((cenario) getWorld()).addObject(new BOTAO_MENU(4), 520, 1);
                paginaINSTRU = 1;
            break;
            case 3 :
                //Creditos
                ((cenario) getWorld()).addObject(new BOTAO_MENU(6), 290, 205);
                ((cenario) getWorld()).addObject(new BOTAO_MENU(4), 520, 1);
                
            break;
            case 4 :
                //Voltar
                verificaOutros();
                setLocation(getX(), getY()+5);
                podeDeletar = true;
                
                if(paginaINSTRU == 1){
                    ((cenario) getWorld()).addObject(new BOTAO_MENU(7), 300, 205);
                    ((cenario) getWorld()).addObject(new BOTAO_MENU(4), 520, 1);
                    paginaINSTRU = 2;
                }
                
            break;
            case 8:
                // Botão para mudar o idioma do jogo, para portugues
                ((cenario)getWorld()).LANGUAGE = 0;
            break;
            case 9:
                // Botão para mudar o idioma do jogo, para inglês
                ((cenario)getWorld()).LANGUAGE = 1;
            break;
            }
        }
    }
    
    
    
    
    public void verificaOutros()
    {
        // Botão voltar! 
        voltar = getOneObjectAtOffset(1, 1, BOTAO_MENU.class);
                if(voltar != null){
                    BOTAO_MENU tirar = (BOTAO_MENU) getOneIntersectingObject(BOTAO_MENU.class);
                    tirar.delete();
                }
        List robozinho = getWorld().getObjects(inimigos.class);
        if(robozinho != null)
            getWorld().removeObjects(robozinho);
    }
    
    
    
    public void delete()
    {
        getWorld().removeObject(this);   
    }
}
