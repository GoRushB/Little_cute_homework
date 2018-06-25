package logic;


import db.Application.lmp.ValkyriesService;
import display.AddValkyries;

public class AddValkyriesLogic {
	AddValkyries display;
	ValkyriesService service;
	public AddValkyriesLogic(AddValkyries display){
		this.display = display;
		service = new ValkyriesService();
	}
	public void addCourse(String no,String name,String ratings,int level,String weapon,String upperStigmata,String centreStigmata,String lowerStigmata){
		try {
			service.Create(no)
			.Name(name)
			.Ratings(ratings)
			.Ratings(ratings)
			.Level(level)
			.Weapon(weapon)
			.UpperStigmata(upperStigmata)
			.CentreStigmata(centreStigmata)
			.LowerStigmata(lowerStigmata)
			.Save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
