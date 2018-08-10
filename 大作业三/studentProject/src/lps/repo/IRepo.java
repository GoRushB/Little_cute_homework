package lps.repo;

import java.util.List;

public interface IRepo<T> {
	/**
	 * * 创建新的对象
	 * 
	 * @param t
	 * @return
	 */
	public boolean create(T t);

	/**
	 * * 获取全部对象
	 * 
	 * @return
	 */
	public List<T> retrieve();

	/**
	 * * 用新的对象更新旧的对象
	 * 
	 * @param tOld
	 * @param tNew
	 * @return
	 */
	public boolean update(T tOld, T tNew);

	/**
	 * * 删除某对象
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(String id);
}