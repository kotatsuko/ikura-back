package ikura.dto;

public class LineDto {
    public int screen_id;
    public int line_id;
    public String line;
    public Integer line_size;
    public Integer line_type;
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public int getLine_id() {
		return line_id;
	}
	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public Integer getLine_size() {
		return line_size;
	}
	public void setLine_size(Integer line_size) {
		this.line_size = line_size;
	}
	public Integer getLine_type() {
		return line_type;
	}
	public void setLine_type(Integer line_type) {
		this.line_type = line_type;
	}


}