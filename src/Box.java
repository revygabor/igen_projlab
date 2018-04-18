public class Box extends Thing {
    /**
     * az utolso dolog ami meglokte a dobozt
     */
    Thing pushedBy;

    /**
     * A Box tömege
     */
    private int mass = 1;

    /**
     * Pontszerzes jelzese.
     */
    @Override
    public void signalScore() {
        pushedBy.signalScore();
    }

    /**
     * A dolog egy masik dolgot meglok az atadott iranyba.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param t a dolog amit meg kell lokni
     * @param d a lokes iranya
     * @param f a még rendelkezésre álló erő
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushOtherThing(Thing t, Direction d, int f) {
        int forceNeed = field.friction.getFrictionCoefficient()*mass;
        if(f-forceNeed<0) return false;
        boolean moveAccepted = t.pushByBox(this, d, f-forceNeed);
        return moveAccepted;
    }

    /**
     * A dobozt egy doboz loki meg az adott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param b a doboz, ami lok
     * @param d a lokes iranya
     * @param f a még rendelkezésre álló erő
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushByBox(Box b, Direction d, int f) {
        pushedBy = b;
        int forceNeed = field.friction.getFrictionCoefficient()*mass;
        if(f-forceNeed<0) return false;
        boolean moveAccepted = field.moveContainedThing(d, f-forceNeed);
        return moveAccepted;
    }

    /**
     * A dobozt egy munkas loki meg az atadott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param w a munkas, aki lok
     * @param d a lokes iranya
     * @param f a még rendelkezésre álló erő
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushByWorker(Worker w, Direction d, int f) {
        pushedBy = w;
        int forceNeed = field.friction.getFrictionCoefficient()*mass;
        if(f-forceNeed < 0) return false;
        boolean moveAccepted = field.moveContainedThing(d, f-forceNeed);
        return moveAccepted;
    }

    /**
     * Jelzi a ladanak, hogy ladanak kijelolt helyre erkezett.
     * A lada a parameterkent megkapott BoxPlace-nek visszajelez, hogy lada erkezett ra.
     * @param place az erintett ladahely
     */
    @Override
    public void arriveAtBoxPlace(BoxPlace place) {
        place.signalBoxEntered();
        pushedBy.signalScore();
    }

    /**
     * elzi a ladanak, hogy kapcsolora erkezett, vagy onnan tavozott.
     * A lada a parameterkent kapott Switch objektumnak jelzi a kapcsolo valtasat.
     * @param s a kapcsolo
     */
    @Override
    public void enterOrLeaveSwitch(Switch s) {
        s.changeSwitch();
    }

    /**
     * A lada elpusztulasat jelzi.
     */
    @Override
    public void die() {
    }

    /**
     * Visszaadja, hogy a ladat lehetseges-e meg mozgatni.
     * @return a lada mozgathato-e meg
     */
    public boolean stillMoveable() {
        return true;
    }
}
