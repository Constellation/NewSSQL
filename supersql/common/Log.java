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
			// ɸ����Ϥؽ���
			System.out.println(o.toString());
			break;
		case 2:
			// ɸ�२�顼�ؽ���
			System.err.println(o.toString());
			break;
		case 3:
			// ɸ����Ϥ˥ɥåȤ����
		    if (dotcount >= 600) {
		        dotreturn();
		    }
		    if (dotcount % 10 == 9) {
		        System.out.print(".");
		    }
		    dotcount++;
			break;
		case 10:
			// buffer�˳�Ǽ
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

	// ɸ��Ū��ư��ǽ��Ϥ������ (-quiet���ˤϽФʤ�)
	public static void info(Object o) {

		switch (infoflag) {
		case 0:
			// do nothing
			break;
		case 1:
			// ɸ����Ϥؽ���
		    dotreturn();
			System.out.println(o.toString());
			break;
		case 2:
			// ɸ�२�顼�ؽ���
			System.err.println(o.toString());
			break;
		case 10:
			// buffer�˳�Ǽ
			buf.append(o.toString()).append('\n');
			break;
		}

	}


	
}