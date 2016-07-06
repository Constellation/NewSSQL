package supersql.test;

import supersql.FrontEnd;

public class TestOptimizer {
	
	static final String testDir = "/Users/arnaudwolf/Desktop/Test_SSQL/";
	static final String outputDirWith = testDir + "outputs_with";
	static final String outputDirWithout = testDir + "outputs_without";
	static final String configFile = testDir + "config";
	
	public static void main(String[] args){
		
		for(int i=1; i<=7; i++){
			String file = testDir + "query" + i + ".ssql";
			String base = "-f " + file + " -c " + configFile;
			String with = base + " -d " + outputDirWith;
			String without = base + " -d " + outputDirWithout + " -O0";
			
			String[] argsWith = with.split(" ");
			String[] argsWithout = without.split(" ");
			
			new FrontEnd(argsWith);
			new FrontEnd(argsWithout);
		}
	}
}
