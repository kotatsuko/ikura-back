package ikura.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String filePath = getServletContext().getRealPath("/index.html");

		if (Files.exists(Paths.get(filePath))) {
		    response.setContentType("text/html");
		    Files.copy(Paths.get(filePath), response.getOutputStream());
		} else {
		    response.sendError(HttpServletResponse.SC_NOT_FOUND, "index.html not found");
		}
	}
}