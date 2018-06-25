package db.Application;

import db.Domain.Valkyries;
import generic.ICommand;

public interface IValkyriesCommand extends ICommand<Valkyries>{
	public static final Valkyries Entity = null;
	IValkyriesCommand No (String no);
	IValkyriesCommand Name (String name);
	IValkyriesCommand Ratings (String ratings);
	IValkyriesCommand Level (int level);
	IValkyriesCommand Weapon (String weapon);
	IValkyriesCommand UpperStigmata (String upperStigmata);
	IValkyriesCommand CentreStigmata (String centreStigmata);
	IValkyriesCommand LowerStigmata (String lowerStigmata);
	Valkyries Save();
}
