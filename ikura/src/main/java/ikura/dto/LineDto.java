package ikura.dto;

public class LineDto {
    private int lineId;
    private int screenId;
    private String line;
    private int lineSize;

    public LineDto(int lineId, int screenId, String line, int lineSize) {
        this.lineId = lineId;
        this.screenId = screenId;
        this.line = line;
        this.lineSize = lineSize;
    }

    public int getLineId() { return lineId; }
    public int getScreenId() { return screenId; }
    public String getLine() { return line; }
    public int getLineSize() { return lineSize; }
}