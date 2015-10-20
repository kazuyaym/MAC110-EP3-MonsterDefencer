/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: tiro.java                                          **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*;  

public class tiro  extends confereJOGO
{

    public Actor inimigos;
    private int cont = 0, direcao, torre, velocidadeTiro = 5;

    public tiro(int d, int numTorre)
    {
        direcao = d;
        torre = numTorre;
        switch (numTorre){
            case 1:
                cont = 18;
                break;
            case 2:
                cont = 23;
                break;
            case 3:
                cont = 28;
                break;
            case 4:
                cont = 40;
                break;
            case 5:
                cont = 17;
                setImage("set2a.png");
                break;
            }
            
            Greenfoot.playSound("tiro.wav");
        }

        public void move()
        {
            switch(direcao) {
                case 1 :
                    setLocation(getX(), getY()-velocidadeTiro);
                    break;
                case 2 :
                    setLocation(getX() + velocidadeTiro, getY());
                    break;
                case 3 :
                    setLocation(getX(), getY()+ velocidadeTiro);
                    break;
                case 4 :
                    setLocation(getX()- velocidadeTiro, getY());
                    break;
                }
    
            }

            public void act()
            {
                move();
                if (cont > 2){
                    mata();
                }
                limite();
            }

            public void mata()
            {
    
                switch (((cenario) getWorld()).FASE) {
                    case 1:   
                    inimigos = getOneObjectAtOffset(1, 1, dinossauro.class);
                    break;
                    case 2:
                    inimigos = getOneObjectAtOffset(1, 1, fantasma.class);
                    break;
                    case 3:
                    inimigos = getOneObjectAtOffset(1, 1, robo.class);
                    break;
                }
        
                if(inimigos != null)
                {   
                    switch (((cenario) getWorld()).FASE){
                        case 1:
                            dinossauro inim = (dinossauro) getOneIntersectingObject(dinossauro.class);
                            if(torre == 5){
                                inim.levouTiroLento();
                                inim.levouTiro();
                            }
                            else
                                inim.levouTiro();
                            break;
                       case 2:
                            fantasma inim2 = (fantasma) getOneIntersectingObject(fantasma.class);
                            if(torre == 5){
                                inim2.levouTiroLento();
                                inim2.levouTiro();
                            }
                            else
                                inim2.levouTiro();
                            break;
                       case 3: 
                            robo inim3 = (robo) getOneIntersectingObject(robo.class);
                            if(torre == 5){
                                inim3.levouTiroLento();
                                inim3.levouTiro();
                            }
                            else
                                inim3.levouTiro();
                            break;
                    }
                    getWorld().removeObject(this);  
                }
            }

           public void limite()
                {
                    cont--;
                    if (cont == 0)
                    getWorld().removeObject(this);
                } 
            }
