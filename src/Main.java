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
        System.out.println("Function returned: " + funcName + (returnValue.isEmpty() ? "" : (" -> " + returnValue )));
    }



}
