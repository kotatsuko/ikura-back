package ikura.common;

public class CommonEnums {

	public enum Database {
		URL("jdbc:sqlite:C:/Users/koyuk/study/gitHub/ikura-back/ikura/src/main/webapp/db/ikura.db");

	    private final String value;

	    Database(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	}
}
