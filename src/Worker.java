public class Worker extends Thing {
    /**
     * a munkas altal osszegyujtott pontszam
     */
    private int score = 0;
    int strength;
    public static final int  DEFAULT_STRENGTH = 10;

    public Worker(int score, int strength) {
        this.score = score;
        this.strength = strength;
    }

    public Worker() {
        this(0, DEFAULT_STRENGTH);
    }

    /**
     * Pontszerzest jelez a munkasnak, igy eggyel megno a pontszama.
     */
    @Override
    public void signalScore() {
        Main.functionCalled("Worker.signalScore");
        score++;
        Main.functionReturned("Worker.signalScore", "");
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
        Main.functionCalled("Worker.pushOtherThing");
        boolean moveAccepted = t.pushByWorker(this, d);
        Main.functionReturned("Worker.pushOtherThing", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    /**
     * A munkast egy doboz loki meg az adott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * Sikertelen mozgas eseten a munkas meghal, mert a doboz agyonnyomja.
     * @param b a doboz, ami lok
     * @param d a mozgas iranya
     * @return a mozgas sikeres-e (mindig true, mert ha nem tud mozdulni meghal)
     */
    @Override
    public boolean pushByBox(Box b, Direction d) {
        Main.functionCalled("Worker.pushByBox");
        if(!field.moveContainedThing(d)) die();
        Main.functionReturned("Worker.pushByBox", "true");
        return true;
    }

    /**
     * A munkast egy munkas loki meg az atadott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param w a munkas, aki lok
     * @param d a mozgas iranya
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushByWorker(Worker w, Direction d) {
        Main.functionCalled("Worker.pushByWorker");
        boolean moveAccepted = field.moveContainedThing(d);
        Main.functionReturned("Worker.pushByWorker", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    /**
     * Ladanak kijelolt helyre valo erkezest jelez. Nem csinal semmit, mert a munkasnak nincsen ekkor specialis viselkedese.
     * @param place az erintett ladahely
     */
    @Override
    public void arriveAtBoxPlace(BoxPlace place) {
        Main.functionCalled("Worker.arriveAtBoxPlace");
        Main.functionReturned("Worker.arriveAtBoxPlace", "");
    }

    /**
     * Kapcsolo mezore valo lepest vagy annak elhagyasat jelzi.
     * Nem csinal semmit, mert a munkasnak nincsen ekkor specialis viselkedese.
     * @param s a kapcsolo
     */
    @Override
    public void enterOrLeaveSwitch(Switch s) {
        Main.functionCalled("Worker.enterOrLeaveSwitch");
        Main.functionReturned("Worker.enterOrLeaveSwitch", "");
    }

    /**
     * A munkas halalat jelzi.
     * A munkas ekkor jelez a Warehouse-nak, hogy egyel kevesebb munkas van eletben.
     */
    @Override
    public void die() {
        Main.functionCalled("Worker.die");
        Warehouse.getInstance().decreaseLivingWorkers();
        Main.functionReturned("Worker.die", "");
    }

    /**
     * A munkas mozogni probal a megadott iranyba.
     * Mozgaslanc kezdete, igy nincs visszateresi erteke.
     * @param d a mozgas iranya
     */
    public void move(Direction d) {
        Main.functionCalled("Worker.move");
        field.moveContainedThing(d);
        Main.functionReturned("Worker.move", "");
    }
}
