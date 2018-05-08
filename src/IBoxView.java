/**
 * Az ezt az interface-t megvalosito osztaly
 * kepes kirajzolni valamilyen feluletre a dobozt.
 */
public interface IBoxView {

    /**
     * Doboz kirajzolasa.
     * @param b kirjzolando doboz
     * @param f a mezo, amelyiken a doboz van
     */
    void draw(Box b, Field f);
}
