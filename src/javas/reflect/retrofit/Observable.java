package javas.reflect.retrofit;

public class Observable<T> {

    private T value;

    public Observable(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
