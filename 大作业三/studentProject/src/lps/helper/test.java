package lps.helper;

import java.lang.reflect.InvocationTargetException;
import lps.pojo.StudentResult;
import lps.repo.StudentRepository;

public class test {

	public static void main(String[] args) throws NoSuchMethodException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		System.out.println(JsonHelper.ListToJson("Stduent", StudentRepository
				.getInstance().retrieve()));
		System.out.println("------------------------------------------------");
		System.out.println(JsonHelper.ListToJson("StudentResult",
				new StudentResult("201601").getCourses()));
	}
}
