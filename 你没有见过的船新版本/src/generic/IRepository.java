package generic;

import java.util.ArrayList;

public interface IRepository<T> {
	boolean IsExisted(Object identifier);
	void Remove(Object identifier);
	void Create(Object identifier);
	T Save(T entity);
	T FindOne(Object identifier);
	ArrayList<T> FindAll();
}
