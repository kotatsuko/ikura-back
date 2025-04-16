package ikura.dto;

public class BrancheDto {
    private String branch_id;
    private String screen_id;
    private String button_label;
    private String next_screen_id;
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(String screen_id) {
		this.screen_id = screen_id;
	}
	public String getButton_label() {
		return button_label;
	}
	public void setButton_label(String button_label) {
		this.button_label = button_label;
	}
	public String getNext_screen_id() {
		return next_screen_id;
	}
	public void setNext_screen_id(String next_screen_id) {
		this.next_screen_id = next_screen_id;
	}

}