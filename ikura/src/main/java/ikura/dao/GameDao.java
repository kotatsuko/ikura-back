package ikura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ikura.dto.BrancheDto;
import ikura.dto.LineDto;
import ikura.dto.ScreenDto;
import ikura.dto.SetScenarioDto;

public class GameDao {

	public void allInsert(SetScenarioDto data) {
	    Connection conn = null;
	    try {
	        conn = DBUtil.getConnection();
	        conn.setAutoCommit(false); // トランザクション開始

	        insertScreen(conn, data.getScreen());
	        insertBrancheList(conn, data.getBranches());
	        insertLineList(conn, data.getLines());

	        conn.commit(); // 成功したらコミット
	    } catch (Exception e) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                conn.rollback(); // エラー発生時にロールバック
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	        }
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close(); // 接続を閉じる
	            } catch (SQLException closeEx) {
	                closeEx.printStackTrace();
	            }
	        }
	    }
	}

    private void insertScreen(Connection conn, List<ScreenDto> screen) throws SQLException {
    	String deleteSql = "delete from screen";
    	PreparedStatement ps = conn.prepareStatement(deleteSql);
    	ps.executeUpdate();

        String sql = "INSERT INTO screen VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        for (ScreenDto s : screen) {
        	ps = conn.prepareStatement(sql);
            ps.setString(1, s.getScreen_id());
            ps.setString(2, s.getScreen_type());
            if (s.getCharacter_name() != null){
            	ps.setString(3, s.getCharacter_name());
            } else {
            	ps.setString(3, "");
            }
            if (s.getCharacter_file_name() != null){
            	ps.setString(4, s.getCharacter_file_name());
            } else {
            	ps.setString(4, "");
            }
            ps.setString(5, s.getBack_file_name());
            ps.setString(6, s.getCharacter_scene_type());
            ps.setString(7, s.getCharacter_exit_type());
            ps.setString(8, s.getCharacter_size());
            ps.setString(9, s.getCharacter_position());
            if (s.getBgm_file_name() != null){
            	ps.setString(10, s.getBgm_file_name());
            } else {
            	ps.setString(10, "");
            }
            if (s.getParent_screen_id() != null){
            	ps.setString(11, s.getParent_screen_id());
            } else {
            	ps.setString(11, "");
            }
            if (s.getFrom_branch_id() != null){
            	ps.setString(12, s.getFrom_branch_id());
            } else {
            	ps.setString(12, "");
            }
            ps.setString(13, s.getDepth());
            if (s.getNext_screen_id() != null){
            	ps.setString(14, s.getNext_screen_id());
            } else {
            	ps.setString(14, "");
            }
            ps.executeUpdate();
        }
    }

    private void insertBrancheList(Connection conn, List<BrancheDto> branches) throws SQLException {
    	String deleteSql = "delete from branche";
    	PreparedStatement ps = conn.prepareStatement(deleteSql);
    	ps.executeUpdate();

        String sql = "INSERT INTO branche VALUES (?, ?, ?, ?)";
        for (BrancheDto b : branches) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBranch_id());
            ps.setString(2, b.getScreen_id());
            ps.setString(3, b.getButton_label());
            ps.setString(4, b.getNext_screen_id());
            ps.executeUpdate();
            }
    }

    private void insertLineList(Connection conn, List<LineDto> lines) throws SQLException {
    	String deleteSql = "delete from line";
    	PreparedStatement ps = conn.prepareStatement(deleteSql);
    	ps.executeUpdate();

        String sql = "INSERT INTO line VALUES (?, ?, ?, ?, ?)";
        for (LineDto l : lines) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, l.getLine_id());
            ps.setString(2, l.getScreen_id());
            ps.setString(3, l.getLine());
            ps.setString(4, l.getLine_size());
            ps.setString(5, l.getLine_type());
            ps.executeUpdate();
        }
    }
}
