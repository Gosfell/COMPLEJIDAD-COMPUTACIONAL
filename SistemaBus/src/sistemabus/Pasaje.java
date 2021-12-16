package sistemabus;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian_Carrasco-Claudio
 */
import com.sun.management.UnixOperatingSystemMXBean;

import java.util.Random;

public class Pasaje {
    
    Random r=new Random();
    private int ID;
    private String nombrePasajero;
    private Asiento Asiento;

    public Pasaje(Asiento Asiento,String nombrePasajero,int ID) {
        this.ID = ID;
        this.nombrePasajero= nombrePasajero;
        this.Asiento = Asiento;
        claimAsiento();
    }

    public Pasaje(String nombrePasajero,int ID) {
        this.ID = ID;
        this.nombrePasajero= nombrePasajero;
    }
    
    public void claimAsiento(){
        Asiento.claim(ID);
    }
    
    public int getId(){
        return this.ID;
    }


    public void setAsiento(Asiento Asiento) {
        this.Asiento = Asiento;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }
}
