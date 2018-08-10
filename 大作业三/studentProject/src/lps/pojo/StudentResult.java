package lps.pojo;

import java.util.ArrayList;
import java.util.List;

import lps.repo.CourseRepository;
import lps.repo.ScRepository;

public class StudentResult {
	private String sno;
	private List<ACourseResult> courses;

	public StudentResult(String sno) {
		this.sno = sno;
	}

	private void InitCourses() {
		courses = new ArrayList<>();
		ScRepository scr = new ScRepository();
		CourseRepository cr = new CourseRepository();
		List<Sc> sclist = scr.retrieve();
		List<Course> clist = cr.retrieve();
		for (Sc sc : sclist) {
			if (sc.getSno().equals(sno)) {
				ACourseResult acr = new ACourseResult();
				acr.setCno(sc.getCno());
				acr.setGrade(sc.getGrade());
				for (Course course : clist) {
					if (course.getCno().equals(sc.getCno())) {
						acr.setCname(course.getCname());
						acr.setCprior(course.getCprior());
						break;
					}
				}
				courses.add(acr);
			}
		}
	}

	public List<ACourseResult> getCourses() {
		InitCourses();
		return courses;
	}
}
