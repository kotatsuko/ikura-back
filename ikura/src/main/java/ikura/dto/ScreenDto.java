package ikura.dto;

public class ScreenDto {
    private int screen_id;
    private int screen_type;
    private String character_name;
    private String character_file_name;
    private String back_file_name;
    private int character_scene_type;
    private int character_exit_type;
    private int character_size;
    private int character_position;
    private String bgm_file_name;
    private Integer next_screen_id;
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public int getScreen_type() {
		return screen_type;
	}
	public void setScreen_type(int screen_type) {
		this.screen_type = screen_type;
	}
	public String getCharacter_name() {
		return character_name;
	}
	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}
	public String getCharacter_file_name() {
		return character_file_name;
	}
	public void setCharacter_file_name(String character_file_name) {
		this.character_file_name = character_file_name;
	}
	public String getBack_file_name() {
		return back_file_name;
	}
	public void setBack_file_name(String back_file_name) {
		this.back_file_name = back_file_name;
	}
	public int getCharacter_scene_type() {
		return character_scene_type;
	}
	public void setCharacter_scene_type(int character_scene_type) {
		this.character_scene_type = character_scene_type;
	}
	public int getCharacter_exit_type() {
		return character_exit_type;
	}
	public void setCharacter_exit_type(int character_exit_type) {
		this.character_exit_type = character_exit_type;
	}
	public int getCharacter_size() {
		return character_size;
	}
	public void setCharacter_size(int character_size) {
		this.character_size = character_size;
	}
	public int getCharacter_position() {
		return character_position;
	}
	public void setCharacter_position(int character_position) {
		this.character_position = character_position;
	}
	public String getBgm_file_name() {
		return bgm_file_name;
	}
	public void setBgm_file_name(String bgm_file_name) {
		this.bgm_file_name = bgm_file_name;
	}
	public Integer getNext_screen_id() {
		return next_screen_id;
	}
	public void setNext_screen_id(Integer next_screen_id) {
		this.next_screen_id = next_screen_id;
	}
}