package ikura.dto;

public class BrancheDto {
    private int branch_id;
    private int screen_id;
    private String button_label;
    private int next_screen_id;
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public String getButton_label() {
		return button_label;
	}
	public void setButton_label(String button_label) {
		this.button_label = button_label;
	}
	public int getNext_screen_id() {
		return next_screen_id;
	}
	public void setNext_screen_id(int next_screen_id) {
		this.next_screen_id = next_screen_id;
	}
}