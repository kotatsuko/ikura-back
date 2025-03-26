package ikura.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ikura.dao.GameDao;
import ikura.dto.SetScenarioDto;

/**
 * Servlet implementation class SetScenario
 */
@WebServlet("/scenario")
public class SetScenario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        try {
	        BufferedReader reader = request.getReader();
	        Gson gson = new Gson();
	        SetScenarioDto data = gson.fromJson(reader, SetScenarioDto.class);

	        GameDao dao = new GameDao();
	        dao.insertScreen(data.getScreen());
	        dao.insertBrancheList(data.getBranches());
	        dao.insertLineList(data.getLines());

	        response.getWriter().write("{\"status\":\"ok\"}");
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}