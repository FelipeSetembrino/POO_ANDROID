package pt.isel.poo.first_counter;

public class Model {
    private ModelListener listener;
    private int counter;
    public void setListener(ModelListener listener) {
        this.listener = listener;
    }
    public void inc() {
        ++counter;
        listener.onChange(counter);
    }
    public void dec() {
        --counter;
        listener.onChange(counter);
    }
    public void reset() {
        counter = 0;
        listener.onChange(counter);
    }
    public int value() {
        return counter;
    }

    public void set(int value) {
        counter = value;
        listener.onChange(counter);
    }
}
