package genericCollection.sec02;

public class Box<T> {
    private T tObj;

    public void set(T t) {
        this.tObj = t;
    }

    public T get() {
        return this.tObj;
    }
}
