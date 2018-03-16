public class Box extends Thing {
    Thing pushedBy;

    @Override
    public void signalScore() {
        Main.functionCalled("Box.signalScore");
        pushedBy.signalScore();
        Main.functionReturned("Box.signalScore", "");
    }

    @Override
    public boolean pushOtherThing(Thing t, Direction d) {
        Main.functionCalled("Box.pushOtherThing");
        boolean moveAccepted = t.pushByBox(this, d);
        Main.functionReturned("Box.pushOtherThing", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    @Override
    public boolean pushByBox(Box b, Direction d) {
        Main.functionCalled("Box.pushByBox");
        pushedBy = b;
        boolean moveAccepted = field.moveContainedThing(d);
        Main.functionReturned("Box.pushByBox", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    @Override
    public boolean pushByWorker(Worker w, Direction d) {
        Main.functionCalled("Box.pushByWorker");
        pushedBy = w;
        boolean moveAccepted = field.moveContainedThing(d);
        Main.functionReturned("Box.pushByWorker", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    @Override
    public void arriveAtBoxPlace(BoxPlace place) {
        Main.functionCalled("Box.arriveAtBoxPlace");
        pushedBy.signalScore();
        Main.functionReturned("Box.arriveAtBoxPlace", "");
    }

    @Override
    public void enterOrLeaveSwitch(Switch s) {
        Main.functionCalled("Box.enterOrLeaveSwitch");
        s.changeSwitch();
        Main.functionReturned("Box.enterOrLeaveSwitch", "");
    }

    @Override
    public void die() {
        Main.functionCalled("Box.die");
        Main.functionReturned("Box.die", "");
    }

    public boolean stillMoveable() {
        Main.functionCalled("Box.stillMoveable");
        Main.functionReturned("Box.stillMoveable", "true");
        return true;
    }
}
