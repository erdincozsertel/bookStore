package com.erdincozsertel.bookstore.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html");
//
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String genderParameter = request.getParameter("gender");
//		Gender gender = Gender.valueOf(genderParameter);
////		java.util.Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthDate"));
////		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate localBirthDate = LocalDate.parse(request.getParameter("birthDate"));
//		Date birthDate = Date.valueOf(localBirthDate);
//
//		if (username.isEmpty() || password.isEmpty() || genderParameter.isEmpty() || birthDate == null) {
//			RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/register.html");
//			req.include(request, response);
//		} else {
//			boolean insertSuccess = false;
//			User user = new User(username, password, gender, birthDate);
//
//			UserDao userDao = new UserDaoImpl();
//			insertSuccess = userDao.save(user);
//
//			if (insertSuccess) {
//				response.sendRedirect("/bookDatabase");
//			} else {
//				RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/register.html");
//				req.include(request, response);
//			}
//		}
//	}
}
