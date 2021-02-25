package dao.interfaces;

public interface CrudInterface<T,K> {
    T add(T obj); // CREATE obj
    void delete(K id); // DELETE obj by id
    void update(T obj, K id);// UPDATE obj by id
    T get(K id); // READ by id
}