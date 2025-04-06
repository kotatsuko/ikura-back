package ikura.dto;

public class ScreenDto {
    public int screen_id;
    public Integer screen_type;
    public String character_name;
    public String character_file_name;
    public String back_file_name;
    public Integer character_scene_type;
    public Integer character_exit_type;
    public Integer character_size;
    public Integer character_position;
    public String bgm_file_name;
    public Integer next_screen_id;
    public Integer parent_screen_id;
    public Integer from_branch_id;
    public int depth;
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public Integer getScreen_type() {
		return screen_type;
	}
	public void setScreen_type(Integer screen_type) {
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
	public Integer getCharacter_scene_type() {
		return character_scene_type;
	}
	public void setCharacter_scene_type(Integer character_scene_type) {
		this.character_scene_type = character_scene_type;
	}
	public Integer getCharacter_exit_type() {
		return character_exit_type;
	}
	public void setCharacter_exit_type(Integer character_exit_type) {
		this.character_exit_type = character_exit_type;
	}
	public Integer getCharacter_size() {
		return character_size;
	}
	public void setCharacter_size(Integer character_size) {
		this.character_size = character_size;
	}
	public Integer getCharacter_position() {
		return character_position;
	}
	public void setCharacter_position(Integer character_position) {
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
	public Integer getParent_screen_id() {
		return parent_screen_id;
	}
	public void setParent_screen_id(Integer parent_screen_id) {
		this.parent_screen_id = parent_screen_id;
	}
	public Integer getFrom_branch_id() {
		return from_branch_id;
	}
	public void setFrom_branch_id(Integer from_branch_id) {
		this.from_branch_id = from_branch_id;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}


}