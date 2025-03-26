package ikura.dto;

import java.util.List;

public class SetScenarioDto {
    private List<ScreenDto> screen;
    private List<BrancheDto> branches;
    private List<LineDto> lines;

	public List<ScreenDto>  getScreen() {
		return screen;
	}
	public void setScreen(List<ScreenDto>  screen) {
		this.screen = screen;
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