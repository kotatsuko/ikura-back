package ikura.dto;

public class BrancheDto {
    private int branchId;
    private int screenId;
    private String buttonLabel;
    private int nextScreenId;

    public BrancheDto(int branchId, int screenId, String buttonLabel, int nextScreenId) {
        this.branchId = branchId;
        this.screenId = screenId;
        this.buttonLabel = buttonLabel;
        this.nextScreenId = nextScreenId;
    }

    public int getBranchId() { return branchId; }
    public int getScreenId() { return screenId; }
    public String getButtonLabel() { return buttonLabel; }
    public int getNextScreenId() { return nextScreenId; }
}