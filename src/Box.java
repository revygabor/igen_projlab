public class Box extends Thing {

    @Override
    public void SignalScore() {

    }

    @Override
    public boolean pushOtherThing(Thing t, Direction direction) {
        return false;
    }

    @Override
    public boolean pushByBox(Box b, Direction direction) {
        return false;
    }

    @Override
    public boolean pushByWorker(Worker w, Direction direction) {
        return false;
    }

    @Override
    public void arriveAtBoxPlace(BoxPlace place) {

    }

    @Override
    public void enterOrLeaveSwitch(Switch s) {

    }

    @Override
    public void die() {

    }

    public boolean stillMoveable() {
        Main.functionCalled("Box.stillMoveable");
        Main.functionReturned("Box.stillMoveable", "true");
        return true;
    }
}
