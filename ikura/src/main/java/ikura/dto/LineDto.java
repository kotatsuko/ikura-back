package ikura.dto;

public class LineDto {
    private int line_id;
    private int screen_id;
    private String line;
    private int line_size;
    private int line_type;
	public int getLine_id() {
		return line_id;
	}
	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public int getLine_size() {
		return line_size;
	}
	public void setLine_size(int line_size) {
		this.line_size = line_size;
	}
	public int getLine_type() {
		return line_type;
	}
	public void setLine_type(int line_type) {
		this.line_type = line_type;
	}
}