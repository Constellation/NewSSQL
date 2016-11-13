package supersql.codegenerator.Compiler;

import supersql.codegenerator.Compiler.PHP.PHP;

public class Compiler {
	
	public Compiler() {

	}

	public static boolean isCompiler = false;
	
	public static String getExtension() {
		String e = ".html";
		if(PHP.isPHP) e = ".php";
		return e;
	}
}
