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
			throw new Exception("女武神已存在");
		Valkyries entity = new Valkyries(no);
		repository.Create(no);
		return new ValkyriesCommand(entity,repository);
	}

	public void Delete(String no) {
		repository.Remove(no);
	}

	public Valkyries Get(String id) throws Exception {
		if(!repository.IsExisted(id))
			throw new Exception("女武神不存在");
		return (Valkyries) repository.FindOne(id);
	}

	public ArrayList<Valkyries> GetAll() {
		ArrayList<Valkyries> items = new ArrayList<>();
		ArrayList<Object> list = repository.FindAll();
		for(Object item :list){
			items.add((Valkyries)item);
		}
		return items;
	}

	public IValkyriesCommand Edit(String no) throws Exception {
		if(!repository.IsExisted(no))
			throw new Exception("女武神不存在");
		Valkyries entity = Get(no);
		return new ValkyriesCommand(entity,repository);
	}
}
