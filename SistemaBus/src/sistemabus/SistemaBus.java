package sistemabus;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian_Carrasco-Claudio
 */        
public class SistemaBus {
    
    private static Bus bus;
    private static LinkQueue cola = new LinkQueue();
    
    public static void main(String[] args) {
        summonbuss();
        menu();
    }
    
    public static void summonbuss() {
        bus=new Bus();
    }
    
    private static void menu(){
        int selection;
        do {
           selection=optionSel();
           options(selection);
        }while (selection!=5);
    }
    
    private static int optionSel() {
        System.out.println(" Seleccione lo que desea realizar");
        System.out.println(" 1 - Mostrar bus");
        System.out.println(" 2 - Comprar boleto");
        System.out.println(" 3 - Reembolsar boleto");
        System.out.println(" 4 - Mostrar cola");
        System.out.println(" 5 - Salir");
        return IntInputReader.input(1, 5);
    }
    
    private static void options(int o){
        if (o==1) show(bus);
        if (o==2) buySeat();
        if (o==3) refundSeat();
        if (o==4) cola.displayQueue();
    }
    
    public static void buySeat() {
        if (!bus.isFull()) {
            Asiento temp = checkAsiento(summonAsiento());
            bus.claimAsiento(temp.getX(), temp.getY());
        }else toQueue();
    }

    public static Asiento summonAsiento() {
        return bus.getAsiento(askLetPos(bus.getHeight()), askNumPos(bus.getWidth()));
    }

    public static void toQueue(){
        System.out.println("Lo sentimos, el bus esta lleno, lo enviaremos a cola.");

            cola.insert(new Pasaje(bus.getNombrePasajero(), bus.getLastId()));

            System.out.println("Asiento comprado, ha sido ingresado en la posicion " + cola.size() + " su boleto tiene el codigo: " + bus.getLastId());

            bus.setLastId(bus.getLastId() + 1);
    }

    public static void refundSeat(){
        if (bus.isEmpty()) {
            System.out.println("No hay asientos comprados, favor intente otra opcion");
        }else {
            Asiento temp = checkEmptyAsiento(summonAsiento());
            bus.getAsiento(temp.getX(), temp.getY()).unClaim();

            System.out.println("Boleto reembolsado");

            //Queue step
            doQueue(temp.getX(),temp.getY());
        }


    }

    public static void doQueue(int x, int y){
        if (!cola.isEmpty()) {
            System.out.println("Avanza la cola, quedan "+(cola.size())+" personas en cola.");
            bus.retrieveClaim(x, y,cola.remove());
        }
    }

    public static int askNumPos(int width){
        System.out.println("Ingrese el numero del asiento a usar");
        return IntInputReader.input(1 , width)-1;
    }
    
    public static int askLetPos(int height) {
        System.out.println("Ingrese la letra de la asiento a usar");
        return (letPoscheck(CharInputReader.intInput()-65,height));
    }

    public static int letPoscheck(int letter, int height) {
        if (letter > height-1) {
            System.out.println("Favor ingresar una letra entre A y J");
            return askLetPos(height);
        }
        else return letter;
    }
    
    public static Asiento checkAsiento(Asiento check){
        if (check.isUsed()) {
            System.out.println("Esta asiento ya esta en uso, favor selecionar un nuevo asiento");
            check=checkAsiento(summonAsiento());
        }return check;
    }

    public static Asiento checkEmptyAsiento(Asiento check){
        if (!check.isUsed()) {
            System.out.println("Esta asiento no esta en uso, favor selecionar un nuevo asiento");
            check=checkEmptyAsiento(summonAsiento());
        }return check;
    }
    
    public static void show(Bus bus) {
        System.out.println("--------------------------------------------------------------");
        AsientoS(bus);
        System.out.println("--------------------------------------------------------------");
    }
    
    public static void AsientoS(Bus bus){
        for (int i=0;i<bus.getHeight()+1;i++) {
            for (int j=0;j<bus.getWidth()+1;j++) {
                if (i!=0 && j!=0) {
                    if (bus.checkAsiento((i-1),(j-1))) {
                        System.out.print(" X ");
                    }else System.out.print(" O ");
                } else if (i==0) {
                    System.out.print(j+" ");
                    if (j<10) System.out.print(" ");;
                }else System.out.print((char) (64+i)+" ");
            }
            System.out.println("");
        }
    }
}
