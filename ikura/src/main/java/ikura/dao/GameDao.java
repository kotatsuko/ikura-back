package ikura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ikura.dto.BrancheDto;
import ikura.dto.LineDto;
import ikura.dto.ScreenDto;

public class GameDao {

    public void insertScreen(List<ScreenDto> screen) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO screen VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (ScreenDto s : screen) {
	            ps.setInt(1, s.getScreen_id());
	            ps.setInt(2, s.getScreen_type());
	            ps.setString(3, s.getCharacter_name());
	            ps.setString(4, s.getCharacter_file_name());
	            ps.setString(5, s.getBack_file_name());
	            ps.setInt(6, s.getCharacter_scene_type());
	            ps.setInt(7, s.getCharacter_exit_type());
	            ps.setInt(8, s.getCharacter_size());
	            ps.setInt(9, s.getCharacter_position());
	            ps.setString(10, s.getBgm_file_name());
	            ps.setInt(11, s.getNext_screen_id());
	            ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBrancheList(List<BrancheDto> branches) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO branche VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (BrancheDto b : branches) {
                ps.setInt(1, b.getBranch_id());
                ps.setInt(2, b.getScreen_id());
                ps.setString(3, b.getButton_label());
                ps.setInt(4, b.getNext_screen_id());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLineList(List<LineDto> lines) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO line VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (LineDto l : lines) {
                ps.setInt(1, l.getLine_id());
                ps.setInt(2, l.getScreen_id());
                ps.setString(3, l.getLine());
                ps.setInt(4, l.getLine_size());
                ps.setInt(5, l.getLine_type());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
