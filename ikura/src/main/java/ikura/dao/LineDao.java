package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ikura.dto.LineDto;

public class LineDao {
    // 🔹 Java 8 で正しい JDBC URL（絶対パス推奨）
    private static final String DB_PATH = "C:/pleiades-e4.5-java-jre_20160312/pleiades/workspace/ikura/src/main/webapp/db/ikura.db";
    private static final String DB_URL = "jdbc:sqlite:" + DB_PATH;

    public List<LineDto> getAllLines() {
        List<LineDto> lines = new ArrayList<>();
        String sql = "SELECT line_id, screen_id, line, line_size FROM line";

        try {
            // 🔹 Java 8 対応: JDBC ドライバの明示的なロード
            Class.forName("org.sqlite.JDBC");

            // 🔹 データベース接続
            try (Connection conn = DriverManager.getConnection(DB_URL);
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                	LineDto dto = new LineDto();
                    dto.setLine_id(rs.getInt("line_id"));
                    dto.setScreen_id(rs.getInt("screen_id"));
                    dto.setLine(rs.getString("line"));
                    dto.setLine_size(rs.getInt("line_size"));
                    dto.setLine_type(rs.getInt("line_type"));

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
