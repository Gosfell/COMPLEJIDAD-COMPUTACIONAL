package sistemabus;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian_Carrasco-Claudio
 */
import java.util.Scanner;

public class IntInputReader {

    static Scanner intro = new Scanner(System.in);
    private static int top,bot;
    
    /**
     * Metodo input recibe @param Bot y @param Top para almacenarlas en la clase y
     * @return el input recibido de err.
     */
    public static int input(int Bot,int Top){
        top=Top;
        bot=Bot;
        return err(intro.next());
    }
    
    /**
     * Metodo err intenta transformar a int el String recibido de
     * @param input, valida el input mediante ValidInt y
     * @return in ya validado
     */
    public static int err(String input){
        int in=0;
        try {
            in=validInt(Integer.parseInt(input));
        } catch (Exception ex) {
            System.out.println("Favor ingresar digitos y no caracteres");
            in=err(intro.next());
        }
        return in; 
    }
    
    /**
     * Metodo ValidInt recibe @param in y revisa si esta entre los
     * @param bot y @param top establecidos en la clase, si es asi
     * @return in
     */
    public static int validInt(int in){
        if (in<bot || in >top) {
            System.out.println("Favor ingresar un numero entre "+bot+" y "+top);
            in=input(bot,top);
        }
        return in;
    }
}