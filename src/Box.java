public class Box extends Thing {
    /**
     * az utolso dolog ami meglokte a dobozt
     */
    Thing pushedBy;

    /**
     * Pontszerzes jelzese.
     */
    @Override
    public void signalScore() {
        Main.functionCalled("Box.signalScore");
        pushedBy.signalScore();
        Main.functionReturned("Box.signalScore", "");
    }

    /**
     * A dolog egy masik dolgot meglok az atadott iranyba.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param t a dolog amit meg kell lokni
     * @param d a lokes iranya
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushOtherThing(Thing t, Direction d) {
        Main.functionCalled("Box.pushOtherThing");
        boolean moveAccepted = t.pushByBox(this, d);
        Main.functionReturned("Box.pushOtherThing", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    /**
     * A dobozt egy doboz loki meg az adott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param b a doboz, ami lok
     * @param d a lokes iranya
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushByBox(Box b, Direction d) {
        Main.functionCalled("Box.pushByBox");
        pushedBy = b;
        boolean moveAccepted = field.moveContainedThing(d);
        Main.functionReturned("Box.pushByBox", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    /**
     * A dobozt egy munkas loki meg az atadott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param w a munkas, aki lok
     * @param d a lokes iranya
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushByWorker(Worker w, Direction d) {
        Main.functionCalled("Box.pushByWorker");
        pushedBy = w;
        boolean moveAccepted = field.moveContainedThing(d);
        Main.functionReturned("Box.pushByWorker", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    /**
     * Jelzi a ladanak, hogy ladanak kijelolt helyre erkezett.
     * A lada a parameterkent megkapott BoxPlace-nek visszajelez, hogy lada erkezett ra.
     * @param place az erintett ladahely
     */
    @Override
    public void arriveAtBoxPlace(BoxPlace place) {
        Main.functionCalled("Box.arriveAtBoxPlace");
        place.signalBoxEntered();
        pushedBy.signalScore();
        Main.functionReturned("Box.arriveAtBoxPlace", "");
    }

    /**
     * elzi a ladanak, hogy kapcsolora erkezett, vagy onnan tavozott.
     * A lada a parameterkent kapott Switch objektumnak jelzi a kapcsolo valtasat.
     * @param s a kapcsolo
     */
    @Override
    public void enterOrLeaveSwitch(Switch s) {
        Main.functionCalled("Box.enterOrLeaveSwitch");
        s.changeSwitch();
        Main.functionReturned("Box.enterOrLeaveSwitch", "");
    }

    /**
     * A lada elpusztulasat jelzi.
     */
    @Override
    public void die() {
        Main.functionCalled("Box.die");
        Main.functionReturned("Box.die", "");
    }

    /**
     * Visszaadja, hogy a ladat lehetseges-e meg mozgatni.
     * @return a lada mozgathato-e meg
     */
    public boolean stillMoveable() {
        Main.functionCalled("Box.stillMoveable");
        Main.functionReturned("Box.stillMoveable", "true");
        return true;
    }
}
