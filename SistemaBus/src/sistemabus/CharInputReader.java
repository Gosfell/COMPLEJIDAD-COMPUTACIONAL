package sistemabus;
/**
 *
 * @author Mendoza-Diego_Muñoz-Tomas_Torres-Sebastian_Carrasco-Claudio
 */
import java.util.Scanner;

public class CharInputReader {

    static Scanner intro = new Scanner(System.in);
    
    /**
     * CharInput Ingresa un String y lo retorna luego de mandarlo a CharErr
     * @return char de A a Z
     */
    public static char charInput(){
        return charErr(intro.next());
    }
    
    /**
     * IntInput Ingresa un String y lo retorna luego de mandarlo a IntErr
     * @return int de 65 a 90
     */
    public static int intInput(){
        return intErr(intro.next());
    }
    
    /**
     * Metodo CharErr recibe @param input, valida que sea un String de 1 de largo
     * y que sea una letra.
     * @return char de A a Z
     */
    public static char charErr(String input){
        return validChar(validString(input).charAt(0));
    }
    
    /**
     * Metodo IntErr recibe @param input, valida que sea un String de 1 de largo
     * , que sea una letra y lo transforma a AltCode Int para letras Mayusculas.
     * @return int de 65 a 90
     */
    public static int intErr(String input) {
        int in=(int)validChar(validString(input).charAt(0));
        if (in > 90) {
            in-=32;
        }
        return in;
    }
    
    /**
     * Metodo ValidString recibe @param in y revisa si es un String
     * de largo 1, de lo contrario pide un nuevo input.
     * @return String de largo 1
     */
    public static String validString(String in){
        if (in.length() != 1) {
            System.out.println("Favor ingresar solo un caracter");
            in=Character.toString(charInput());
        }
        return in;
    }
    
    /**
     * Metodo validChar recibe @param in, y mediante AltCode revisa si el char
     * recibido es una letra (es independiente de si la letra es mayuscula o minuscula).
     * @return char de A a Z
     */
    public static char validChar(char in) {
        if ((int) in<65 || (int)in > 95) {
            if ((int) in<97 || (int)in > 122) {
                System.out.println("Favor ingresar caracteres de letras");
                in=charInput();
            }
        }
        return in;
    }
}