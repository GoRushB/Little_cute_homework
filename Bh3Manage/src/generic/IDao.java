package generic;

import java.util.ArrayList;

public interface IDao<T> {
    boolean Create(T t);
    ArrayList<T> Retrieve();
    boolean Updata(T oldt,T newt);
    boolean Delete(T t);
    T getById(String id);
}
