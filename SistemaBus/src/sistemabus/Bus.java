package sistemabus;

import java.util.Scanner;

public class Bus {

    private int col;
    private int row;

    private int lastId;

    private Asiento[][] Asientos;

    public Bus() {
        this.col = 2;
        this.row = 5;
        Asientos=new Asiento[row][col];
        setAsientos();
    }
    
    private void setAsientos(){

        int id=0;

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                Asientos[i][j]=new Asiento(i,j,id);
                id++;
            }
        }

        lastId=id;
    }

    public int getWidth() {
        return col;
    }

    public int getHeight() {
        return row;
    }
    
    public Asiento getAsiento(int x,int y) {
        return Asientos[x][y];
    }
    
    public void claimAsiento(int x,int y) {
        Pasaje ticket=new Pasaje(Asientos[x][y],getNombrePasajero(),lastId);
        lastId++;
        System.out.println("Boleto emitido, codigo: "+ticket.getId());
    }

    public void retrieveClaim(int x, int y,Pasaje ticket) {
        ticket.setAsiento(Asientos[x][y]);
        System.out.println("Asiento cobrada, boleto codigo: "+ticket.getId());
    }
    
    public boolean checkAsiento(int x,int y) {
        return Asientos[x][y].isUsed();
    }

    public boolean isEmpty(){
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (Asientos[i][j].isUsed()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFull(){
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (!Asientos[i][j].isUsed()){
                    return false;
                }
            }
        }
        return true;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public String getNombrePasajero(){
        System.out.println("Favor ingresar el nombre del pasajero");
        Scanner intro = new Scanner(System.in);
        return intro.nextLine();
    }
}
