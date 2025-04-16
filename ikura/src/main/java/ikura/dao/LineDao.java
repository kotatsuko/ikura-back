package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ikura.common.CommonEnums.Database;
import ikura.dto.LineDto;

public class LineDao {

    public List<LineDto> getAllLines() {
        List<LineDto> lines = new ArrayList<>();
        String sql = "SELECT * FROM line";

        try {
            // 🔹 Java 8 対応: JDBC ドライバの明示的なロード
            Class.forName("org.sqlite.JDBC");

            // 🔹 データベース接続
            try (Connection conn = DriverManager.getConnection(Database.URL.getValue());
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                	LineDto dto = new LineDto();
                    dto.setLine_id(rs.getString("line_id"));
                    dto.setScreen_id(rs.getString("screen_id"));
                    dto.setLine(rs.getString("line"));
                    dto.setLine_size(rs.getString("line_size"));
                    dto.setLine_type(rs.getString("line_type"));

                    lines.add(dto);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC ドライバが見つかりません。JAR を追加してください。");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
