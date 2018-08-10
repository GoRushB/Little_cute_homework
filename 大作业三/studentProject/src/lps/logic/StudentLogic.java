package lps.logic;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lps.helper.JsonHelper;
import lps.pojo.Student;
import lps.pojo.StudentResult;
import lps.repo.ScRepository;
import lps.repo.StudentRepository;

public class StudentLogic {
	private static StudentLogic instance = null;

	public static StudentLogic getInstance() {
		if (instance == null)
			instance = new StudentLogic();
		return instance;
	}

	public void GetAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Student> students = StudentRepository.getInstance().retrieve();
			PrintWriter pw = response.getWriter();
			pw.print("{" + JsonHelper.ListToJson("Students", students) + "}");
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GetGradeByStudent(HttpServletRequest request,
			HttpServletResponse response, ServletContext context, String id) {
		try {
			request.setAttribute("sno", id);
			request.setAttribute("sname", StudentRepository.getInstance()
					.getById(id).getSname());
			PrintWriter pw = response.getWriter();
			pw.print("{"
					+ JsonHelper.ListToJson("Courses",
							new StudentResult(id).getCourses()) + "}");
			pw.flush();
			pw.close();
			String nextUrl = "/jsp/Grade.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Create(HttpServletRequest request,
			HttpServletResponse response, ServletContext context) {
		try {
			String nextUrl = "/jsp/CreateStudent.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Edit(HttpServletRequest request, HttpServletResponse response,
			ServletContext context, String id) {
		try {
			request.setAttribute("Student", StudentRepository.getInstance()
					.getById(id));
			String nextUrl = "/jsp/EditStudent.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Delete(HttpServletRequest request,
			HttpServletResponse response, ServletContext context, String id) {
		try {
			if (ScRepository.getInstance().deleteByStudentId(id)) {
				StudentRepository.getInstance().delete(id);
			}
			String nextUrl = "/jsp/Student.jsp";
			context.getRequestDispatcher(nextUrl).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
