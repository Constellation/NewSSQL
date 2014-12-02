package supersql.codegenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import supersql.common.GlobalEnv;
import supersql.common.Log;

//added by goto 20141201
public class CopyJscss {
	static final String fs = GlobalEnv.OS_FS;
	
	public CopyJscss() {

	}
	
	//copy JSCSS to the output directory
	public static void copyJSCSS_to_outputDir() {
		String media = CodeGenerator.getMedia();
		String ep = GlobalEnv.EXE_FILE_PATH;
		
		File from = null;
		if (media.equalsIgnoreCase("html"))
			from = new File(ep+fs+"jscss"+fs+"forHTML"+fs+"jscss");
		else if (media.equalsIgnoreCase("mobile_html5"))
			from = new File(ep+fs+"jscss");
		String to = GlobalEnv.getoutdirectory();
		if (to == null)
			to = GlobalEnv.getfileparent();
		
		if (!directoryCopy(from, new File(to)))
			Log.err("<<Warning>> Copy JSCSS failed.");
	}

	//directoryCopy
	private static Boolean directoryCopy(File fromDir, File toDir) {
		File[] fromFile = fromDir.listFiles();
		toDir = new File(toDir.getPath() + fs + fromDir.getName());
		
		toDir.mkdir();

		if (fromFile != null) {
			for (File f : fromFile) {
				if (f.isFile()) {
					if (!fileCopy(f, toDir)) {
						return false;
					}
				} else {
					if (!directoryCopy(f, toDir)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	//fileCopy
	private static Boolean fileCopy(File file, File dir) {
		File copyFile = new File(dir.getPath() + fs + file.getName());
		
		if (!copyFile.isHidden()) {	//if it's not a hidden file
			FileChannel channelFrom = null;
			FileChannel channelTo = null;
			
			try {
				copyFile.createNewFile();
				channelFrom = new FileInputStream(file).getChannel();
				channelTo = new FileOutputStream(copyFile).getChannel();
				channelFrom.transferTo(0, channelFrom.size(), channelTo);
				return true;
			} catch (IOException e) {
				return false;
			} finally {
				try {
					if (channelFrom != null) {
						channelFrom.close();
					}
					if (channelTo != null) {
						channelTo.close();
					}
					copyFile.setLastModified(file.lastModified());	//copy the update date
				} catch (IOException e) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
//	// 20140625_masato 実習用　コピー元は/home/kyozai/toyama/SuperSQL/jscss/~　と/home/kyozai/toyama/SuperSQL/ssqltool~
//	public static void CopyJscss(){
////		String path = System.getProperty("java.class.path");
////		path = getWorkingDir(path);
//		
//		// コピーするjsファイル　実習専用
//		File jsFile1 = new File("/home/kyozai/toyama/SuperSQL/jscss/jquery.js");
//		File jsFile2 = new File("/home/kyozai/toyama/SuperSQL/jscss/jquery-p.js");
//		File jsFile3 = new File("/home/kyozai/toyama/SuperSQL/jscss/ssql-pagination.js");
//		File cssFile = new File("/home/kyozai/toyama/SuperSQL/jscss/ssql-pagination.css");
//
//		File destPath1 = new File(GlobalEnv.getoutdirectory() + GlobalEnv.OS_FS + "jscss" + GlobalEnv.OS_FS + "jquery.js");
//		File destPath2 = new File(GlobalEnv.getoutdirectory() + GlobalEnv.OS_FS + "jscss" + GlobalEnv.OS_FS + "jquery-p.js");
//		File destPath3 = new File(GlobalEnv.getoutdirectory() + GlobalEnv.OS_FS + "jscss" + GlobalEnv.OS_FS + "ssql-pagination.js");
//		File destPath4 = new File(GlobalEnv.getoutdirectory() + GlobalEnv.OS_FS + "jscss" + GlobalEnv.OS_FS + "ssql-pagination.css");
//		
//		copyTransfer(jsFile1, destPath1);
//		copyTransfer(jsFile2, destPath2);
//		copyTransfer(jsFile3, destPath3);
//		copyTransfer(cssFile, destPath4);
//	}
//	
////	public static String getWorkingDir(String path){
////		String workingDir = new File(path).getAbsolutePath(); // 実行jarファイルの絶対パスを取得
////		if (!System.getProperty("os.name").contains("Windows") && workingDir.contains(":")) {// ビルドバスの追加を行うと参照ライブラリ内のファイルのパスも付け加えてしまう仕様らしいので、:移行カット
////				workingDir = workingDir.substring(0, workingDir.indexOf(":"));
////		}
////		if (workingDir.endsWith(".jar")) { // jarファイルを実行した場合（Eclipseから起動した場合は入らない）
////			workingDir = workingDir.substring(0, workingDir.lastIndexOf(GlobalEnv.OS_FS));
////		}
////		return workingDir;
////	}
//	
//	public static void copyTransfer(final File src, final File dest) {
//		try {
//			File tmp = new File(dest.toString().substring(0, dest.toString().lastIndexOf("/")));
//			if (src.isDirectory()) {
//				// ディレクトリがない場合、作成
//				if(!dest.exists()){
//					dest.mkdir();
//				}
//	
//				String[] files = src.list();
//				for (String file : files) {
//					File srcFile = new File(src, file);
//					File destFile = new File(dest, file);
//					if(!srcFile.isHidden()){	//隠しファイルではない場合
//						copyTransfer(srcFile, destFile);
//					}
//				}
//			} else {
//				if(!tmp.exists()){
//					tmp.mkdir();
//				}
//				
//				FileChannel srcChannel = new FileInputStream(src).getChannel();
//				FileChannel destChannel = new FileOutputStream(dest).getChannel();
//				try {
//					srcChannel.transferTo(0, srcChannel.size(), destChannel);
//				} catch(Exception e){
//					System.err.println(e);
//				} finally {
//					srcChannel.close();
//					destChannel.close();
//				}
//			}
//		}catch (Exception e) {
//			//e.printStackTrace();
//		}
//	}
}
