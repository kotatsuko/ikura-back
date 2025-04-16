package ikura.servlet;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import ikura.dao.GameDao;
import ikura.dto.SetScenarioDto;

/**
 * Servlet implementation class SetScenario
 */
@MultipartConfig
@WebServlet("/scenario")
public class SetScenario extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
    response.setContentType("application/json;charset=UTF-8");

    try {
      // 画像保存
      for (Part part : request.getParts()) {
        String name = part.getName();
        if (name.startsWith("character_file_") || name.startsWith("back_file_")) {
          String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
          part.write("C:/Users/koyuk/study/gitHub/ikura-back/ikura/src/main/webapp/images/" + fileName);
        }
      }

      // JSON受け取り
      Part jsonPart = request.getPart("json");
      Gson gson = new Gson();
      SetScenarioDto data = gson.fromJson(new java.io.InputStreamReader(jsonPart.getInputStream(), "UTF-8"), SetScenarioDto.class);

      GameDao dao = new GameDao();
      dao.allInsert(data);

      response.getWriter().write("{\"status\":\"ok\"}");
    } catch (Exception e) {
      e.printStackTrace();
      response.getWriter().write("{\"status\":\"error\"}");
    }
  }
}