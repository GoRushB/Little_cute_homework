package lps.repo;

import java.util.List;

public interface IRepo<T> {
	public boolean create(T t);
	public List<T> retrieve();
	public boolean update(T tOld, T tNew);
	public boolean delete(T t);
}