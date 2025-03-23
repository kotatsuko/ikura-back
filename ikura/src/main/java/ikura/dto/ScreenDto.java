package ikura.dto;

public class ScreenDto {
    private int screenId;
    private int screenType;
    private String characterFileName;
    private String backFileName;
    private Integer nextScreenId;

    // コンストラクタ
    public ScreenDto(int screenId, int screenType, String characterFileName, String backFileName, Integer nextScreenId) {
        this.screenId = screenId;
        this.screenType = screenType;
        this.characterFileName = characterFileName;
        this.backFileName = backFileName;
        this.nextScreenId = nextScreenId;
    }

    // ゲッター
    public int getScreenId() { return screenId; }
    public int getScreenType() { return screenType; }
    public String getCharacterFileName() { return characterFileName; }
    public String getBackFileName() { return backFileName; }
    public Integer getNextScreenId() { return nextScreenId; }
}