package supersql.common;

public class Utils {

	public static String getEncode() {
		if (getOs().contains("Windows")) {
			return "Shift_JIS";
		} else {
			return "EUC_JP";
		}
	}

	public static String getOs() {
		String osname = System.getProperty("os.name");
		return osname;
	}
	
}
