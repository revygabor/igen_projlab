public class Worker extends Thing {
    /**
     * a munkas altal osszegyujtott pontszam
     */
    private int score = 0;

    /**
     * a munkas sorszama
     */
    private int id;

    /**
     * A munkas sorszamat adja vissza.
     * @return A munkas sorszama
     */
    public int getId() {
        return id;
    }

    /**
     * el -e a munkas?
     */
    private boolean isAlive;

    int strength;
    public int getStrength() {
        return strength;
    }
    public static final int  DEFAULT_STRENGTH = 10;

    public Worker(int score, int strength, int id, boolean isAlive) {
        this.score = score;
        this.strength = strength;
        this.id = id;
        this.isAlive = isAlive;
    }

    /**
     * Pontszerzest jelez a munkasnak, igy eggyel megno a pontszama.
     */
    @Override
    public void signalScore() {
        score++;
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
        boolean moveAccepted = t.pushByWorker(this, d, f+strength);
        return moveAccepted;
    }

    /**
     * A munkast egy doboz loki meg az adott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * Sikertelen mozgas eseten a munkas meghal, mert a doboz agyonnyomja.
     * @param b a doboz, ami lok
     * @param d a mozgas iranya
     * @param f a még rendelkezésre álló erő
     * @return a mozgas sikeres-e (mindig true, mert ha nem tud mozdulni meghal)
     */
    @Override
    public boolean pushByBox(Box b, Direction d, int f) {
        if(!field.moveContainedThing(d, f)) die();
        return true;
    }

    /**
     * A munkast egy munkas loki meg az atadott iranyba, erre reagal.
     * Visszaterese a mozgas sikeresseget jelzi.
     * @param w a munkas, aki lok
     * @param d a mozgas iranya
     * @param f a még rendelkezésre álló erő
     * @return a mozgas sikeres-e
     */
    @Override
    public boolean pushByWorker(Worker w, Direction d, int f) {
        boolean moveAccepted = field.moveContainedThing(d, f);
        return moveAccepted;
    }

    /**
     * Ladanak kijelolt helyre valo erkezest jelez. Nem csinal semmit, mert a munkasnak nincsen ekkor specialis viselkedese.
     * @param place az erintett ladahely
     */
    @Override
    public void arriveAtBoxPlace(BoxPlace place) {
    }

    /**
     * Kapcsolo mezore valo lepest vagy annak elhagyasat jelzi.
     * Nem csinal semmit, mert a munkasnak nincsen ekkor specialis viselkedese.
     * @param s a kapcsolo
     */
    @Override
    public void enterOrLeaveSwitch(Switch s) {
    }

    /**
     * A munkas halalat jelzi.
     * A munkas ekkor jelez a Warehouse-nak, hogy egyel kevesebb munkas van eletben.
     */
    @Override
    public void die() {
        Warehouse.getInstance().decreaseLivingWorkers();
        isAlive = false;
    }

    @Override
    public String getShortDesc() {
        return "W" + id;
    }

    @Override
    public String getLongDesc() {
        return "Worker " + id;
    }

    /**
     * A munkas mozogni probal a megadott iranyba.
     * Mozgaslanc kezdete, igy nincs visszateresi erteke.
     * @param d a mozgas iranya
     */
    public boolean move(Direction d) {
        return field.moveContainedThing(d, 0);
    }

    /**
     * A mezőre amin áll olajat helyez el a munkás
     */
    public void dropOil(){
        field.apply(new Oil());
    }

    /**
     * A mezőre amin áll mézet helyez el a munkás
     */
    public void dropHoney(){
        field.apply(new Honey());
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return isAlive ? field.getXPos() + " " + field.getYPos() + " " + score + " " + strength : "X";
    }


    public boolean isAlive() {
        return isAlive;
    }
}
