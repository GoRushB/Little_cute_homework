package lps.logic;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.helper.JsonHelper;
import lps.pojo.Course;
import lps.repo.CourseRepository;
import lps.repo.ScRepository;

public class CourseLogic {
	private static CourseLogic instance = null;

	public static CourseLogic getInstance() {
		if (instance == null)
			instance = new CourseLogic();
		return instance;
	}

	public void GetAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Course> courses = CourseRepository.getInstance().retrieve();
			PrintWriter pw = response.getWriter();
			pw.print("{" + JsonHelper.ListToJson("Courses", courses) + "}");
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Create(HttpServletRequest request,
			HttpServletResponse response, ServletContext context) {
		try {
			String nextUrl = "/jsp/CreateCourse.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Edit(HttpServletRequest request, HttpServletResponse response,
			ServletContext context, String id) {
		try {
			request.setAttribute("Course", CourseRepository.getInstance()
					.getById(id));
			String nextUrl = "/jsp/EditCourse.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Delete(HttpServletRequest request,
			HttpServletResponse response, ServletContext context, String id) {
		try {
			if (ScRepository.getInstance().deleteByCourseId(id)) {
				CourseRepository.getInstance().delete(id);
			}
			String nextUrl = "/jsp/Course.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}