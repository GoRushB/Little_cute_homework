package generic;

import java.util.ArrayList;

public interface IRepository {
	boolean IsExisted(Object identifier);
	void Remove(Object identifier);
	Object Save(Object entity);
	Object FindOne(Object identifier);
	ArrayList<Object> FindAll();
}
