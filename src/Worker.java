public class Worker extends Thing {
    int score = 0;

    @Override
    public void signalScore() {
        Main.functionCalled("Worker.signalScore");
        score++;
        Main.functionReturned("Worker.signalScore", "");
    }

    @Override
    public boolean pushOtherThing(Thing t, Direction d) {
        Main.functionCalled("Worker.pushOtherThing");
        boolean moveAccepted = t.pushByWorker(this, d);
        Main.functionReturned("Worker.pushOtherThing", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    @Override
    public boolean pushByBox(Box b, Direction d) {
        Main.functionCalled("Worker.pushByBox");
        if(!field.moveContainedThing(d)) die();
        Main.functionReturned("Worker.pushByBox", "true");
        return true;
    }

    @Override
    public boolean pushByWorker(Worker w, Direction d) {
        Main.functionCalled("Worker.pushByWorker");
        boolean moveAccepted = field.moveContainedThing(d);
        Main.functionReturned("Worker.pushByWorker", String.valueOf(moveAccepted));
        return moveAccepted;
    }

    @Override
    public void arriveAtBoxPlace(BoxPlace place) {
        Main.functionCalled("Worker.arriveAtBoxPlace");
        Main.functionReturned("Worker.arriveAtBoxPlace", "");
    }

    @Override
    public void enterOrLeaveSwitch(Switch s) {
        Main.functionCalled("Worker.enterOrLeaveSwitch");
        Main.functionReturned("Worker.enterOrLeaveSwitch", "");
    }

    @Override
    public void die() {
        Main.functionCalled("Worker.die");
        Warehouse.getInstance().decreaseLivingWorkers();
        Main.functionReturned("Worker.die", "");
    }

    public void move(Direction d) {
        Main.functionCalled("Worker.move");
        field.moveContainedThing(d);
        Main.functionReturned("Worker.move", "");
    }
}
