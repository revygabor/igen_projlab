/**
 * Absztrakt ososztaly barmilyen targy reprezentalasara, ami mezon allhat.
 * Kepes lehet mozgasra, meglokhetik, de ennek pontos viselkedeset a leszarmazott hatarozza meg.
 */
public abstract class Thing {

    protected Field field;

    /**
     * Pontszerzes jelzesere hasznalt absztrakt metodus.
     */
    public abstract void signalScore();

    /**
     * A dolog egy masik dolgot meglok az atadott iranyba.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param t a dolog amit meg kell lokni
     * @param d a lokes iranya
     * @return a mozgas sikeres volt-e
     */
    public abstract boolean pushOtherThing(Thing t, Direction d);

    /**
     * A dolgot egy doboz loki meg az adott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param b a doboz, ami lok
     * @param d a lokes iranya
     * @return a mozgas sikeres-e
     */
    public abstract boolean pushByBox(Box b, Direction d);

    /**
     * A dolgot egy munkas loki meg az adott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param w a munkas, aki lok
     * @param d a lokes iranya
     * @return a mozgas sikeressege
     */
    public abstract boolean pushByWorker(Worker w, Direction d);

    /**
     *A dolog az atadott mezore probal mozogni, a mozgas iranyat a masodik parameter jelzi.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param targetField a celmezo
     * @param d a mozgas iranya
     * @return a mozgas sikeres-e
     */
    public boolean moveToField(Field targetField, Direction d) {
        Main.functionCalled("Thing.moveToField");
        boolean accepted = targetField.accept(this, d);
        if(accepted) field = targetField;
        Main.functionReturned("Thing.moveToField", String.valueOf(accepted));
        return accepted;
    }

    /**
     * Ladanak szant helyre valo megerkezest jelez
     * @param place az erintett ladahely
     */
    public abstract void arriveAtBoxPlace(BoxPlace place);

    /**
     * Kapcsolora valo erkezest vagy arrol valo elmozdulast jelez.
     * @param s a kapcsolo
     */
    public abstract void enterOrLeaveSwitch(Switch s);

    /**
     * A dolog elpusztulasat jelzi
     */
    public abstract void die();

}
