package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ikura.common.CommonEnums.Database;
import ikura.dto.ScreenDto;

public class ScreenDao {

    public List<ScreenDto> getAllScreens() {
        List<ScreenDto> screens = new ArrayList<>();
        String sql = "SELECT *FROM screen";

        try {
            // 🔹 JDBC ドライバを明示的にロード（Java 8 対策）
            Class.forName("org.sqlite.JDBC");

            // 🔹 データベース接続
            try (Connection conn = DriverManager.getConnection(Database.URL.getValue());
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    ScreenDto dto = new ScreenDto();
                    dto.setScreen_id(rs.getString("screen_id"));
                    dto.setScreen_type(rs.getString("screen_type"));
                    dto.setCharacter_name(rs.getString("character_name"));
                    dto.setCharacter_file_name(rs.getString("character_file_name"));
                    dto.setBack_file_name(rs.getString("back_file_name"));
                    dto.setCharacter_scene_type(rs.getString("character_scene_type"));
                    dto.setCharacter_exit_type(rs.getString("character_exit_type"));
                    dto.setCharacter_size(rs.getString("character_size"));
                    dto.setCharacter_position(rs.getString("character_position"));
                    dto.setBgm_file_name(rs.getString("bgm_file_name"));
                    dto.setParent_screen_id(rs.getString("parent_screen_id"));
                    dto.setFrom_branch_id(rs.getString("from_branch_id"));
                    dto.setDepth(rs.getString("depth"));
                    dto.setNext_screen_id(rs.getString("next_screen_id"));

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
