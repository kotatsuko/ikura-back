package ikura.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ikura.dao.BrancheDao;
import ikura.dao.LineDao;
import ikura.dao.ScreenDao;
import ikura.dto.BrancheDto;
import ikura.dto.LineDto;
import ikura.dto.ScreenDto;

/**
 * Servlet implementation class GetAllDate
 */
@WebServlet("/get")
public class GetAllDate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ✅ JSON レスポンスのエンコーディングを UTF-8 に設定
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // ✅ Dao インスタンスを生成
        ScreenDao screenDao = new ScreenDao();
        BrancheDao brancheDao = new BrancheDao();
        LineDao lineDao = new LineDao();

        // ✅ データを取得
        List<ScreenDto> screens = screenDao.getAllScreens();
        List<BrancheDto> branches = brancheDao.getAllBranches();
        List<LineDto> lines = lineDao.getAllLines();

        // ✅ データを JSON にまとめる
        Map<String, Object> gameData = new HashMap<>();
        gameData.put("screens", screens);
        gameData.put("branches", branches);
        gameData.put("lines", lines);

        // ✅ Gson を UTF-8 エンコーディングに対応させて変換
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = gson.toJson(gameData);

        // ✅ クライアントに JSON をレスポンスとして送信
        response.getWriter().write(json);
    }
}