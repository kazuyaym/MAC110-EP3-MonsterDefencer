import greenfoot.*; 

public class faseCompleta extends Actor
{
    public int contadorSome = 0, contador = 0, velocidade = 9;
    
    public faseCompleta(int i)
        {
            switch(i){
            case 0:
                setImage("stageCompletPT.png");
            break;
            case 1:
                setImage("stageComplet.png");
            break;
                }
        }

    public void act() 
    {
        move();
        some();
    }    
    
    public void move()
    {
        setLocation(getX() + velocidade, getY());
        if(contador == 7){
            velocidade--;
            contador = 0;
        }
        contador++;
        
        if(velocidade == 0){
            contador = -65;
            velocidade = -1;
        }
    }
    public void some()
    {
        contadorSome++;
        if(contadorSome == 190)
            getWorld().removeObject(this);
    }
}
