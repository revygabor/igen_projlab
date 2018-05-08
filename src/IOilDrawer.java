/**
 * Az ezt az interface-t megvalosito osztaly
 * kepes kirajzolni valamilyen feluletre az olajat.
 */
public interface IOilDrawer {

    /**
     * Olaj kirajzolasa.
     * @param o kirajzolando olaj
     * @param f mezo, amin az olaj van
     */
    void draw(Oil o, Field f);
}
