package supersql.common;

public class Log {

	static int flag = 0;
	static int infoflag = 1;
	
	static int dotcount = 0;

	static StringBuffer buf = new StringBuffer();

	public static void setLog(int f) {
		flag = f;
	}
	public static void setinfoLog(int f) {
		infoflag = f;
	}

	public static void out(Object o) {

		switch (flag) {
		case 0:
			// do nothing
			break;
		case 1:
			// 標準出力へ出力
			System.out.println(o.toString());
			break;
		case 2:
			// 標準エラーへ出力
			System.err.println(o.toString());
			break;
		case 3:
			// 標準出力にドットを出力
		    if (dotcount >= 600) {
		        dotreturn();
		    }
		    if (dotcount % 10 == 9) {
		        System.out.print(".");
		    }
		    dotcount++;
			break;
		case 10:
			// bufferに格納
			buf.append(o.toString()).append('\n');
			break;
		}

	}

	private static void dotreturn() {
	    if (flag == 3 && dotcount >= 9) {
	        System.out.print("\n");
	        dotcount = 0;
	    }
	}
	
	public static void initBuffer() {
		buf = new StringBuffer();
	}

	public static String getBuffer() {
		return buf.toString();
	}

	// 標準的な動作で出力されるもの (-quiet時には出ない)
	public static void info(Object o) {

		switch (infoflag) {
		case 0:
			// do nothing
			break;
		case 1:
			// 標準出力へ出力
		    dotreturn();
			System.out.println(o.toString());
			break;
		case 2:
			// 標準エラーへ出力
			System.err.println(o.toString());
			break;
		case 10:
			// bufferに格納
			buf.append(o.toString()).append('\n');
			break;
		}

	}


	
}