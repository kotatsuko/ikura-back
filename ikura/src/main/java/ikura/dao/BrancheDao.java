package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ikura.dto.BrancheDto;

public class BrancheDao {
    // 🔹 Java 8 で正しい JDBC URL（絶対パス推奨）
    private static final String DB_PATH = "C:/pleiades-e4.5-java-jre_20160312/pleiades/workspace/ikura/src/main/webapp/db/ikura.db";
    private static final String DB_URL = "jdbc:sqlite:" + DB_PATH;

    public List<BrancheDto> getAllBranches() {
        List<BrancheDto> branches = new ArrayList<>();
        String sql = "SELECT branch_id, screen_id, button_label, next_screen_id FROM branche";

        try {
            // 🔹 Java 8 対応: JDBC ドライバの明示的なロード
            Class.forName("org.sqlite.JDBC");

            // 🔹 データベース接続
            try (Connection conn = DriverManager.getConnection(DB_URL);
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    branches.add(new BrancheDto(
                            rs.getInt("branch_id"),
                            rs.getInt("screen_id"),
                            rs.getString("button_label"),
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
        return branches;
    }
}
