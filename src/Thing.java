public abstract class Thing {
    public boolean moveToField(Field neighbor) {return true;}    //TODO:javitsd
    public abstract boolean arriveAtBoxPlace(BoxPlace place);
    public abstract boolean enterOrLeaveSwitch(Switch s);
    public abstract void die();

}
