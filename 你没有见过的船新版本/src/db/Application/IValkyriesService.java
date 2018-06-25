package db.Application;

import java.util.ArrayList;

import db.Domain.Valkyries;

public interface IValkyriesService {
	IValkyriesCommand Create(String no) throws Exception;
	void Delete(String no);
	Valkyries Get(String id) throws Exception;
	ArrayList<Object> GetAll();
	IValkyriesCommand Edit(String no) throws Exception;
}
