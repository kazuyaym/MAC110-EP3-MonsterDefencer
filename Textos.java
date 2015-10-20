/*******************************************************************/
/**   MAC 110 - Introdução  a Computação                          **/
/**   IME-USP - Primeiro Semestre de 2011                         **/
/**   2011145 - Fabio Kon                                         **/
/**                                                               **/
/**   Terceiro Exercício-Programa -- Monsters Defence             **/
/**   Arquivo: Textos.java                                        **/
/**                                                               **/
/**   Bárbara de Castro Fernandes  7577351                        **/
/**   Marcos Kazuya Yamazaki       7577622                        **/
/**                                                               **/
/*******************************************************************/

import greenfoot.*;
import java.awt.Font;

public class Textos extends Actor
{
    private int valor;
    private String text;
    private int stringLength;

    public Textos(String prefix, int i)
    {
        text = prefix;
        valor = i;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 20));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(20.0F));  
        
        atualizaImagem();
    }
    
    public void act() {
        atualizaImagem();
    }
    
    public void substituiValor(int i)
    {
        valor = i;
    }

    public void adiciona(int i)
    {
        valor += i;
    }

    public int Valor()
    {
        return valor;
    }
    
    private void atualizaImagem()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + valor, 1, 18);
    }
}
