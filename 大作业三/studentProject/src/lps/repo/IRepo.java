package lps.repo;

import java.util.List;

public interface IRepo<T> {
	/**
	 * * �����µĶ���
	 * 
	 * @param t
	 * @return
	 */
	public boolean create(T t);

	/**
	 * * ��ȡȫ������
	 * 
	 * @return
	 */
	public List<T> retrieve();

	/**
	 * * ���µĶ�����¾ɵĶ���
	 * 
	 * @param tOld
	 * @param tNew
	 * @return
	 */
	public boolean update(T tOld, T tNew);

	/**
	 * * ɾ��ĳ����
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(String id);
}