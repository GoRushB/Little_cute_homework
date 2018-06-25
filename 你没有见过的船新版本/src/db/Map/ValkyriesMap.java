package db.Map;

public class ValkyriesMap {
	public static String Create(String no,String name,String ratings,int level,String weapon,String upperStigmata,String centreStigmata,String lowerStigmata){
		return String.format("insert into valkyries(no,name,ratings,level,weapon,upperStigmata,centreStigmata,lowerStigmata) values('%s','%s','%s',%d,'%s','%s','%s','%s')",
				no,name,ratings,level,weapon,upperStigmata,centreStigmata,lowerStigmata);
	}
	
	public static String Delete(String no){
		return String.format("delete from valkyries where no ='%s'", no);
	}
	
	public static String Get(String no){
		return String.format("select * from valkyries where no ='%s'",no);
	}
	
	public static String GetAll(){
		return String.format("select * from valkyries ");
	}
	
	public static String Edit(String no,String name,String ratings,int level,String weapon,String upperStigmata,String centreStigmata,String lowerStigmata){
		return String.format("update valkyries set name='%s',ratings='%s',level=%d,weapon='%s',upperStigmata='%s',centreStigmata='%s',lowerStigmata='%s' where no ='%s'",
				name,ratings,level,weapon,upperStigmata,centreStigmata,lowerStigmata,no);
	}
}
