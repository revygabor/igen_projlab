/**
 * Az ezt az interface-t megvalosito osztaly
 * kepes kirajzolni valamilyen feluletre a munkast.
 */
public interface IWorkerView {

    /**
     * Munkas kirajzolasa.
     * @param w kirajzolando munkas
     * @param f mezo, amin a munkas van
     */
    void Draw(Worker w, Field f);
}
