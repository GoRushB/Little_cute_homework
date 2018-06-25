package db.Application.lmp;

import db.Application.IValkyriesCommand;
import db.Domain.Valkyries;
import generic.Command;
import generic.IRepository;

public class ValkyriesCommand extends Command<Valkyries> implements IValkyriesCommand{

	protected ValkyriesCommand(Valkyries entity,IRepository repository) {
		super(entity,repository);
	}

	public IValkyriesCommand No(String no) {
		entity.No = no;
		return this;
	}

	public IValkyriesCommand Name(String name) {
		entity.Name = name;
		return this;
	}

	public IValkyriesCommand Ratings(String ratings) {
		entity.Ratings = ratings;
		return this;
	}

	public IValkyriesCommand Level(int level) {
		entity.Level = level;
		return this;
	}

	public IValkyriesCommand Weapon(String weapon) {
		entity.Weapon = weapon;
		return this;
	}

	public IValkyriesCommand UpperStigmata(String upperStigmata) {
		entity.UpperStigmata = upperStigmata;
		return this;
	}

	public IValkyriesCommand CentreStigmata(String centreStigmata) {
		entity.CentreStigmata = centreStigmata;
		return this;
	}

	public IValkyriesCommand LowerStigmata(String lowerStigmata) {
		entity.LowerStigmata = lowerStigmata;
		return this;
	}

	@Override
	public Valkyries Save() {
		return (Valkyries) repository.Save(entity);
	}
}
