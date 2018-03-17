import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int indent = 0;

    /**
     * Fuggveny meghivasast logolja a standard kimenetre
     * @param funcName a meghivott fuggveny neve
     */
    public static void functionCalled(String funcName) {
        for (int i=0; i<indent; i++)
            System.out.print("   ");
        System.out.println("Function Called: " + funcName);
        indent++;
    }

    /**
     * Fuggveny visszatereset logolja a standerd kimenetre
     * @param funcName a visszatero fuggveny neve
     * @param returnValue a fuggveny visszateresi erteke, ha van, egyebkent ures string
     */
    public static void functionReturned(String funcName, String returnValue) {
        indent--;
        for (int i=0; i<indent; i++)
            System.out.print("   ");
        System.out.println("Function returned: " + funcName + (returnValue.isEmpty() ? "" : (" -> " + returnValue )));
    }

    public static void main(String[] args) throws IOException {
        UseCase test;
        System.out.println("Melyik use case-t szeretne elinditani?");
        System.out.println("1. Worker-Box-Box-Floor");
        System.out.println("2. Worker-Box-Hole");
        System.out.println("3. Worker-Box-Worker-Wall");
        System.out.print("A kivant use case sorszama: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String response = br.readLine();
        int id = Integer.parseInt(response);
        switch (id) {
            case 1:
                test = new W_B_B_F();
                break;
            case 2:
                test = new W_B_H();
                break;
            default:
                test = new W_B_W_Wall();
        }
        test.start();
    }

}
