package generics.advanced;

public interface Container<T> {
    void add(T item);

    T get();
}
