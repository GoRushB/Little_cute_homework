package db.Application.lmp;

import java.util.ArrayList;

import db.Application.IValkyriesCommand;
import db.Application.IValkyriesService;
import db.Domain.Valkyries;
import db.Repository.ValkyriesRepository;
import generic.IRepository;

public class ValkyriesService implements IValkyriesService{
	private IRepository repository;
	public ValkyriesService(){
		repository = new ValkyriesRepository();
	}
	public IValkyriesCommand Create(String no) throws Exception {
		if(repository.IsExisted(no))
			throw new Exception("Ů�����Ѵ���");
		Valkyries entity = new Valkyries(no);
		return new ValkyriesCommand(entity,repository);
	}

	public void Delete(String no) {
		repository.Remove(no);
	}

	public Valkyries Get(String id) throws Exception {
		if(!repository.IsExisted(id))
			throw new Exception("Ů���񲻴���");
		return (Valkyries) repository.FindOne(id);
	}

	public ArrayList<Object> GetAll() {		
		return repository.FindAll();
	}

	public IValkyriesCommand Edit(String no) throws Exception {
		if(!repository.IsExisted(no))
			throw new Exception("Ů���񲻴���");
		Valkyries entity = Get(no);
		return new ValkyriesCommand(entity,repository);
	}
}
