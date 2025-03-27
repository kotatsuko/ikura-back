package ikura.dto;

import java.util.List;

public class SetScenarioDto {
    private List<ScreenDto> screens;
    private List<BrancheDto> branches;
    private List<LineDto> lines;

	public List<ScreenDto>  getScreen() {
		return screens;
	}
	public void setScreen(List<ScreenDto>  screens) {
		this.screens = screens;
	}
	public List<BrancheDto> getBranches() {
		return branches;
	}
	public void setBranches(List<BrancheDto > branches) {
		this.branches = branches;
	}
	public List<LineDto> getLines() {
		return lines;
	}
	public void setLines(List<LineDto > lines) {
		this.lines = lines;
	}
}