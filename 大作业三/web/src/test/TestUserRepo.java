package test;

import java.util.List;

import lps.pojo.Answers;
import lps.pojo.Users;
import lps.repo.AnswersRepo;
import lps.repo.UsersRepo;

public class TestUserRepo {
	public static void main(String[] args) {
		UsersRepo uRepo = UsersRepo.getInstance();
		Users users = uRepo.getByUname("a");
		AnswersRepo aRepo = AnswersRepo.getInstance();
		List<Answers> anss = aRepo.retrieveByUsers(users);
		String qidString = "", gradeString = "";
		for (Answers answers : anss) {
			qidString += " " + answers.getQid();
			gradeString += " " + answers.getGrade();
		}
		qidString = qidString.trim().replace(' ', ',');
		gradeString = gradeString.trim().replace(' ', ',');
		String jsonString = "{\"qid:\":[" + qidString + "],\"grade\":["
				+ gradeString + "]}";
		System.out.print(jsonString);
	}
}