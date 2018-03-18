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
        System.out.println("2. Worker-Worker-HiddenHole");
        System.out.println("3. Worker-Switch-Box");
        System.out.println("4. Worker-Box-BoxPlace");
        System.out.println("5. Worker-Box-Hole");
        System.out.println("6. Worker-Box-Worker-Wall");
        System.out.println("7. Worker-Box-Wall");
        System.out.println("8. Worker-Floor");
        System.out.print("A kivant use case sorszama: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String response = br.readLine();
        int id = Integer.parseInt(response);
        switch (id) {
            case 1:
                test = new W_B_B_F();
                break;
            case 2:
                test = new W_W_HH();
                break;
            case 3:
                test = new W_S_B();
                break;
            case 4:
                test = new W_B_BP();
                break;
            case 5:
                test = new W_B_H();
                break;
            case 6:
                test = new W_B_W_Wall();
                break;
            case 7:
                test = new W_B_Wall();
                break;
            case 8:
                test = new W_F();
                break;
            default:
                test = new W_B_S();
        }
        test.start();
    }

}
