package supersql.ctab;

import supersql.codegenerator.DecorateList;
import supersql.codegenerator.FuncArg;
import supersql.codegenerator.HTML.HTMLEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class Function {
	public Function() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public static void Func_third_tree(ExtList<FuncArg> args, HTMLEnv htmlEnv, DecorateList decos) {
		Log.info(args.get(3).getStr());
		if(decos.containsKey("third_node")){
			Log.info(decos.getStr("third_node"));
		}
		htmlEnv.code.append(args.get(3).getStr());
	}
}
