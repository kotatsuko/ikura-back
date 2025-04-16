package ikura.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/images/list")
public class ImageListServlet extends HttpServlet {
    private static final String IMAGE_DIR_PATH = "C:/Users/koyuk/study/gitHub/ikura-back/ikura/src/main/webapp/images/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=UTF-8");

        File dir = new File(IMAGE_DIR_PATH);
        String[] imageFiles = dir.list((dir1, name) -> {
            String lower = name.toLowerCase();
            return lower.endsWith(".png") || lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".gif");
        });

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        response.getWriter().write(gson.toJson(imageFiles));
    }
}