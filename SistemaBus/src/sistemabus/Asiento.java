package sistemabus;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian_Carrasco-Claudio
 */
public class Asiento {


    // false corresponde a Asiento sin comprar, true a Asiento comprada
    private boolean used=true;
    private int x;
    private int y;
    private int id;
    
    public Asiento(int x,int y,int id) {
        this.x=x;
        this.y=y;
        this.id=id;
    }
    
    public void claim(int id){
        used=true;
    }
    
    public void unClaim(){
        used=false;
    }
    
    public boolean isUsed(){
        return used;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
