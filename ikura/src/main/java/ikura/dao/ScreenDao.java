package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ikura.dto.ScreenDto;

public class ScreenDao {
    private static final String DB_URL = "jdbc:sqlite:C:/pleiades-e4.5-java-jre_20160312/pleiades/workspace/ikura/src/main/webapp/db/ikura.db";

    public List<ScreenDto> getAllScreens() {
        List<ScreenDto> screens = new ArrayList<>();
        String sql = "SELECT screen_id, screen_type, character_file_name, back_file_name, next_screen_id FROM screen";

        try {
            // 🔹 JDBC ドライバを明示的にロード（Java 8 対策）
            Class.forName("org.sqlite.JDBC");

            // 🔹 データベース接続
            try (Connection conn = DriverManager.getConnection(DB_URL);
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    screens.add(new ScreenDto(
                            rs.getInt("screen_id"),
                            rs.getInt("screen_type"),
                            rs.getString("character_file_name"),
                            rs.getString("back_file_name"),
                            rs.getInt("next_screen_id")
                    ));
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC ドライバが見つかりません。JAR を追加してください。");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return screens;
    }
}
