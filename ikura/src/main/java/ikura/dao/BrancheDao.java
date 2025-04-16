package ikura.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ikura.common.CommonEnums.Database;
import ikura.dto.BrancheDto;

public class BrancheDao {

    public List<BrancheDto> getAllBranches() {
        List<BrancheDto> branches = new ArrayList<>();
        String sql = "SELECT * FROM branche";

        try {
            // 🔹 Java 8 対応: JDBC ドライバの明示的なロード
            Class.forName("org.sqlite.JDBC");

            // 🔹 データベース接続
            try (Connection conn = DriverManager.getConnection(Database.URL.getValue());
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                	BrancheDto dto = new BrancheDto();
                	dto.setBranch_id(rs.getString("branch_id"));
                	dto.setScreen_id(rs.getString("screen_id"));
                	dto.setButton_label(rs.getString("button_label"));
                	dto.setNext_screen_id(rs.getString("next_screen_id"));
                    branches.add(dto);
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
