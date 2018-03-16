public abstract class Thing {

    protected Field field;

    public abstract void signalScore();

    public abstract boolean pushOtherThing(Thing t, Direction direction);

    public abstract boolean pushByBox(Box b, Direction direction);

    public abstract boolean pushByWorker(Worker w, Direction direction);

    public boolean moveToField(Field targetField, Direction d) {
        Main.functionCalled("Thing.moveToField");
        boolean accepted = targetField.accept(this, d);
        Main.functionReturned("Thing.moveToField", String.valueOf(accepted));
        return accepted;
    }

    public abstract void arriveAtBoxPlace(BoxPlace place);

    public abstract void enterOrLeaveSwitch(Switch s);

    public abstract void die();

}
