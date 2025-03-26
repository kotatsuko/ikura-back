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
                    ScreenDto dto = new ScreenDto();
                    dto.setScreen_id(rs.getInt("screen_id"));
                    dto.setScreen_type(rs.getInt("screen_type"));
                    dto.setCharacter_name(rs.getString("character_name"));
                    dto.setCharacter_file_name(rs.getString("character_file_name"));
                    dto.setBack_file_name(rs.getString("back_file_name"));
                    dto.setCharacter_scene_type(rs.getInt("character_scene_type"));
                    dto.setCharacter_exit_type(rs.getInt("character_exit_type"));
                    dto.setCharacter_size(rs.getInt("character_size"));
                    dto.setCharacter_position(rs.getInt("character_position"));
                    dto.setBgm_file_name(rs.getString("bgm_file_name"));

                    int nextScreenId = rs.getInt("next_screen_id");
                    if (rs.wasNull()) {
                        dto.setNext_screen_id(null);
                    } else {
                        dto.setNext_screen_id(nextScreenId);
                    }

                    screens.add(dto);
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
