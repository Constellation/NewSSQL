/*
 * Created on 2004/12/06 by mai
 */
package supersql.codegenerator.SWF;

public class SWFWriter {
	SWFEnv swf_env;

	public SWFWriter(SWFEnv swf_env){
		this.swf_env = swf_env;
	}

	// edit tomo 2007.12.23
	public void writeHeader(){
		String header =
			"<?\n" +
			"set_time_limit(600);\n" +
			"Ming_setScale(20);\n" +
			"ming_useswfversion(7);\n" +
			"$moviewidth="+swf_env.movieWidth+";\n" +
			"$movieheight="+swf_env.movieHeight+";\n" +
			"$duration="+swf_env.duration+"/1000;\n" +
			"$rate="+swf_env.rate+";\n" +
			"$offset="+swf_env.offset+";\n" +
			"$movie = new SWFMovie();\n" +
			"$movie->setDimension($moviewidth, $movieheight);\n" +
			"$movie->setBackground(0xff,0xff,0xff);\n" +
			"$movie->setRate($rate);\n" +
			"$telops = array();\n" +  
			"$masks = array();\n" +  
			"$scrolls = array();\n\n";  
		//morya wrote
		if (swf_env.music != "false"){
			header = header +
			"$mp3name=\"" + swf_env.music + "\";\n" +
			"$mp3path=\"./\";\n" +
			"$snd = fopen($mp3path . $mp3name , \"rb\");\n" +
			"$movie->streamMp3($snd);\n" +
			"fclose($snd);\n\n";
		}
		if (swf_env.telop != "false"){
			header = header +
			"$time=0;\n\n";
		}
		//morya kokomade
		if (swf_env.transition != "false"){
			header = header +
			"// create Mask for transition\n" +
			"$maskshape=new SWFShape();\n" +
			"$maskshape->setRightFill(255,255,255);\n" +
			"$maskshape->drawLine($moviewidth,0);\n" +
			"$maskshape->drawLine(0,$movieheight);\n" +
			"$maskshape->drawLine((-1)*$moviewidth,0);\n" +
			"$maskshape->drawLine(0,(-1)*$movieheight);\n" +
			"$mask = $movie->add($maskshape);\n" +
			"$mask->setDepth(4444444);\n\n";
		}
//		Log.out("[SWFWriter:writeheader]" + header);
		swf_env.header.append(header);
	}
	public void writeFooter(){
		String footer;

		if(swf_env.dynamicFlag){
			if (swf_env.telop != "false"){
				footer =
					"for($i=0;$i<count($tname);$i++){\n" +
					"$tp =\"\n" +
					"_root['$tname[$i]'].removeTextField();\n" +
					"\";\n" +
					"$movie->add(new SWFAction($tp));\n" +
					"}\n\n" +
					"header(\"Content-type: application/x-shockwave-flash\");\n" +
					"$movie->output(9);\n" +
					"?>";
			}else {
				footer =
					"header(\"Content-type: application/x-shockwave-flash\");\n" +
					"$movie->output(9);\n" +
					"?>";
			}
		}

		else{
			if (swf_env.telop != "false"){
				footer =
					"for($i=0;$i<count($tname);$i++){\n" +
					"$tp =\"\n" +
					"_root['$tname[$i]'].removeTextField();\n" +
					"\";\n" +
					"$movie->add(new SWFAction($tp));\n" +
					"}\n\n";

				if(swf_env.loopFlag==false){
					footer +=
						"$movie->add(new SWFAction(\"stop(); stopped=true;\"));\n\n";
				}

				footer +=
					"$movie->save(\""+swf_env.filename+".swf\");\n" +
					"$revitalizer=rand();\n" +
					"print \"<OBJECT classid=\\\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\\\" codebase=\\\"http://active.macromedia.com/flash2/cabs/swflash.cab#version=4,0,0,0\\\" ID=objects WIDTH=$moviewidth HEIGHT=$movieheight>\n" +
					"<PARAM NAME=movie VALUE=\\\""+swf_env.filename+".swf?$revitalizer\\\">\n" +
					"<PARAM NAME=loop value="+swf_env.loopFlag+">\n" +
					"<EMBED src=\\\""+swf_env.filename+".swf?$revitalizer\\\" WIDTH=$moviewidth HEIGHT=$movieheight TYPE=\\\"application/x-shockwave-flash\\\" PLUGINSPAGE=\\\"http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash\\\">\n" +
					"</OBJECT>\";\n" +
					"?>";
			}else {
				footer = "";
				if(swf_env.loopFlag==false){
					footer +=
						"$movie->add(new SWFAction(\"stop(); stopped=true;\"));\n\n";
				}
				footer +=
					"$movie->save(\""+swf_env.filename+".swf\");\n" +
					"$revitalizer=rand();\n" +
					"print \"<OBJECT classid=\\\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\\\" codebase=\\\"http://active.macromedia.com/flash2/cabs/swflash.cab#version=4,0,0,0\\\" ID=objects WIDTH=$moviewidth HEIGHT=$movieheight>\n" +
					"<PARAM NAME=movie VALUE=\\\""+swf_env.filename+".swf?$revitalizer\\\">\n" +
					"<PARAM NAME=loop value="+swf_env.loopFlag+">\n" +
					"<EMBED src=\\\""+swf_env.filename+".swf?$revitalizer\\\" WIDTH=$moviewidth HEIGHT=$movieheight TYPE=\\\"application/x-shockwave-flash\\\" PLUGINSPAGE=\\\"http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash\\\">\n" +
					"</OBJECT>\";\n" +
					"?>";
			}
		}
		swf_env.footer.append(footer);
	}

	public void writeFunctions(){
		String ftype = swf_env.final_value.type;

		writeTFAS();
		writeTFFunc();
		// edit Tomo
		writeTelopFunc();
		writeScrollFunc();
		if (swf_env.controller != null) {
			writeButtonFunc(swf_env.controller.equals("visible"));
		}
		writeInteractionFunc();

		if(ftype.equals("G2")||ftype.equals("G1")){
			if(swf_env.containImg) writeAddImgFunc();
			writeDispFrameFunc2();
		}
		else {
			if(swf_env.containImg){
				writeAddImgFunc();
				writeRemoveIMGFunc();
			}
			//12/7 morya wrote
			writeAddIntT();
			writeAddIntI();
			writeAddITemp();
			//morya kokomade
			writeRemoveTFFunc();
			if(swf_env.transition.equalsIgnoreCase("fade")) writeFadeFunc();
			else if(swf_env.transition.equalsIgnoreCase("wipeUD")) writeWipeUDFunc();
			else if(swf_env.transition.equalsIgnoreCase("wipeLR")) writeWipeLRFunc();
			else writeNextFunc();
			writeDispFrameFunc();
		}
	}


	public void writeControlAS(){
		String control =
			"$strAction=\"\n" +
			"if(!init){\n" +
			"init=true;\n" +
			"stopped=false;\n" +
			"controls = {\n" +
			"onMouseDown: function () {\n" +
			"if(!stopped){\n" +
			"stop();\n" +
			"stopped=true;\n" +
			"}else{\n" +
			"play();\n" +
			"stopped=false;\n" +
			"}\n" +
			"}\n" +
			"};\n" +
			"Mouse.addListener(controls);\n" +
			"}\";\n" +
			"$movie->add(new SWFAction($strAction));\n";

		swf_env.controlAS.append(control);

	}

	public void writeTFAS(){
		String TFAS =
			"$as = \"\n" +
			"_global.depth = 1;\n" +
			"function textFieldAS(name,x,y,w,h,bgcolor,bdcolor,color,size,align,margin,str) {\n" +
			"depth+=2;\n" +
			"_root.createTextField(name,depth,x,y,w,h);\n" +
			"with (_root[name]){\n" +
			"multiline = true;\n" +
			"wordWrap = true;\n" +
			"hscroll = 0;\n" +
			"border = true;\n" +
			"borderColor = bdcolor;\n" +
			"background = true;\n" +
			"backgroundColor = bgcolor;\n" +
			"};\n" +
			"format = new TextFormat();\n" +
			"format.size = size;\n" +
			"format.align = align;\n" +
			"format.font = 'Arial';\n" +
			"format.color = color;\n" +
			"format.leftMargin = margin;\n" +
			"format.rightMargin = margin;\n" +
			"_root[name].setNewTextFormat(format);\n" +
			"_root[name].text = str;\n" +
			"};\n" +
			"\";\n\n" +
			"$movie->add(new SWFAction($as));\n\n";

		//morya wrote
		if (swf_env.telop != "false"){
			TFAS = TFAS +
			"//telopField Function\n" +
			"$tp = \"\n" +
			"_global.tdepth = 50000;\n" +
			"function telopField(name,x,y,w,h,color,size,str) {\n" +
			"tdepth += 3;\n" +
			"_root.createTextField(name,tdepth,x,y,w,h);\n" +
			"with (_root[name]){\n" +
			"multiline = true;\n" +
			"wordWrap = true;\n" +
			"hscroll = 0;\n" +
			"border = false;\n" +
			"background = false;\n" +
			"};\n" +
			"format = new TextFormat();\n" +
			"format.size = size;\n" +
			"format.align = align;\n" +
			"format.font = 'Arial';\n" +
			"format.color = color;\n" +
			"format.leftMargin = margin;\n" +
			"format.rightMargin = margin;\n" +
			"_root[name].setNewTextFormat(format);\n" +
			"_root[name].text = str;\n" +
			"};\n" +
			"\";\n\n" +
			"$movie->add(new SWFAction($tp));\n\n";
		}
		TFAS = TFAS +//12/7add by morya
		"//interactionField function\n" +
		"$as = \"\n" +
		"_global.idepth = 60000;\n" +
		"function interactionFieldAS(name,namet,x,y,w,h,bgcolor,bdcolor,color,alpha,size,align,margin,str) {\n" +
		"idepth+=2;\n" +
		"_root.createTextField(namet,idepth,x,y,w,h);\n" +
		"with (_root[namet]){\n" +
		"multiline = true;\n" +
		"wordWrap = true;\n" +
		"hscroll = 0;\n" +
		"border = true;\n" +
		"borderColor = bdcolor;\n" +
		"background = true;\n" +
		"backgroundColor = bgcolor;\n" +
		"};\n" +
		"format = new TextFormat();\n" +
		"_root[namet].embedFonts = true;\n" +
		"_root[namet].setNewTextFormat(format);\n" +
		"_root[namet]._alpha = alpha;\n" +
		"idepth+=2;\n" +
		"_root.createTextField(name,idepth,x,y,w,h);\n" +
		"with (_root[name]){\n" +
		"multiline = true;\n" +
		"wordWrap = true;\n" +
		"hscroll = 0;\n" +
		"border = false;\n" +
		"background = false;\n" +
		"};\n" +
		"format = new TextFormat();\n" +
		"format.size = size;\n" +
		"format.align = align;\n" +
		"format.font = 'Arial';\n" +
		"format.color = color;\n" +
		"format.leftMargin = margin;\n" +
		"format.rightMargin = margin;\n" +
		"_root[name].setNewTextFormat(format);\n" +
		"_root[name].text = str;\n" +
		"};\n" +
		"\";\n\n" +
		"$movie->add(new SWFAction($as));\n\n";
		//morya kokomade

		swf_env.function.append(TFAS);
	}

	// edit tomo 2007.12.23
	public void writeTFFunc(){
		String TFFunc =

//			"function addTextField($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str) {\n" +
			"function addTextField($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$texttype) {\n" +
			"$as = \"\";\n" +
			"for($i=0;$i<count($name);$i++){\n" +
			"if ($texttype[$i] == \"normal\") //\n" +
			"$as .= \" textFieldAS('$name[$i]',$x[$i],$y[$i],$w[$i],$h[$i],'$bgcolor[$i]','$bdcolor[$i]','$color[$i]',$size[$i],'$align[$i]',$margin[$i],'$str[$i]');\";\n" +
			"}\n" +
			"$movie->add(new SWFAction($as));\n" +
			"}\n\n";
		swf_env.function.append(TFFunc);
	}

	public void writeOpenImgFunc(){
		String IMGFunc =
			"function openImage($img,$openedImg){\n" +
			"for($i=0;$i<count($img);$i++){\n" +
			"if($img[$i]==\"noimage\") $openedImg[$i] = \"noimage\";\n" +
			"else $openedImg[$i] = new SWFBitmap(fopen(\"$img[$i]\",\"rb\"));\n" +
			"}\n" +
			"return $openedImg;\n" +
			"}\n\n";
		swf_env.function.append(IMGFunc);
	}

	public void writeGetImgWFunc(){
		String IMGFunc =
			"function getImageWidth($openedImg,$imgW){\n" +
			"for($i=0;$i<count($openedImg);$i++){\n" +
			"if($openedImg[$i]==\"noimage\") $imgW[$i] = 0;\n" +
			"else $imgW[$i] = ($openedImg[$i]->getwidth());\n" +
			"}\n" +
			"return $imgW;\n" +
			"}\n\n";
		swf_env.function.append(IMGFunc);
	}

	public void writeGetImgHFunc(){
		String IMGFunc =
			"function getImageHeight($openedImg,$imgH){\n" +
			"for($i=0;$i<count($openedImg);$i++){\n" +
			"if($openedImg[$i]==\"noimage\") $imgH[$i] = 0;\n" +
			"else $imgH[$i] = ($openedImg[$i]->getheight());\n" +
			"}\n" +
			"return $imgH;\n" +
			"}\n\n";
		swf_env.function.append(IMGFunc);
	}


	public void writeAddImgFunc(){
		String IMGFunc =

			"function addImage($movie,$imgpath,$x,$y,$margin){\n" +
			"$depth = 100000;\n" +
			"for($i=0;$i<count($imgpath);$i++){\n" +
			"if($imgpath[$i]==\"noimage\"){\n" +
			"$addedImg[$i] = \"noimage\";\n" +
			"}\n" +
			"else{\n" +
			"$openedImg[$i] = new SWFBitmap(fopen(\"$imgpath[$i]\",\"rb\"));\n" +
			"$addedImg[$i] = $movie->add($openedImg[$i]);\n" +
			"$addedImg[$i]->setDepth($depth);\n" +
			"$addedImg[$i]->scaleTo(0.9958,0.9896);\n" +
			"$addedImg[$i]->MoveTo($x[$i]+$margin[$i],$y[$i]+$margin[$i]);\n" +
			"$depth+=8;\n" +
			"}\n" +
			"}\n" +
			"return $addedImg;\n" +
			"}\n\n";

		swf_env.function.append(IMGFunc);

	}

	// edit tomo 2007.12.23
	public void writeRemoveTFFunc(){
		String rmTFFunc =
			"function removeTextField($movie,$name,$texttype){\n" +
//			add
			"global $telops,$masks,$scrolls;\n" +
			"for($i=0;$i<count($name);$i++){\n" +
			"if($texttype[$i] == \"normal\") {\n" +
			"$as .= \"_root['$name[$i]'].removeTextField(); \";\n" +
			"} elseif ($texttype[$i] == \"telop\") {\n" +
			"$telops[$i]->remove();\n"+
			"} else {\n"+
			"$masks[$i]->remove();\n"+
			"$scrolls[$i]->remove();\n"+
			"}\n" +
			"}\n" +
			"$movie->add(new SWFAction($as));\n" +
			"}\n\n";

		swf_env.function.append(rmTFFunc);
	}

	public void writeRemoveIMGFunc(){
		String rmIMGFunc =
			"function removeImage($movie,$addedImg){\n" +
			"for($i=0;$i<count($addedImg);$i++){\n" +
			"if($addedImg[$i]!=\"noimage\") $movie->remove($addedImg[$i]);\n" +
			"}\n" +
			"}\n\n";

		swf_env.function.append(rmIMGFunc);
	}

	public void writeFadeFunc(){
		String fade =
		"//\n";
		//morya wrote
		if (swf_env.telop != "false"){
			fade = fade +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$tname,$tx,$ty,$tw,$th,$tcolor,$tsize,$timefrom,$timeto,$tstr){\n" +

			"global $time;\n";
		}else {
			fade = fade +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset){\n";
		}
		fade = fade +
		//morya kokomade
			"for($i=0; $i<$offset; $i++)  {\n" +
		  	"$mask->multColor(1.0, 1.0, 1.0, ($offset-$i)/$offset);\n";

		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			fade = fade +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		fade = fade +
		//morya kokomade
		  	"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			fade = fade +
			"$time++;\n";
		}
		fade = fade +
		//morya kokomade
			"}\n" +
			"for($i=0;$i<$rate*$duration;$i++){\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			fade = fade +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		fade = fade +
		//morya kokomade
				"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			fade = fade +
			"$time++;\n";
		}
		fade = fade +
		//morya kokomade
			"}\n" +
			"for($i=0; $i<$offset; $i++)   {\n" +
		  	"$mask->multColor(1.0, 1.0, 1.0, $i/$offset);\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			fade = fade +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		fade = fade +
		//morya kokomade
		  	"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			fade = fade +
			"$time++;\n";
		}
		fade = fade +
		//morya kokomade
			"}\n" +
		"}\n\n";
		swf_env.function.append(fade);
	}

	public void writeWipeUDFunc(){
		String wipeUD = "//\n";
		
		if (swf_env.telop != "false"){
			wipeUD = wipeUD +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$tname,$tx,$ty,$tw,$th,$tcolor,$tsize,$timefrom,$timeto,$tstr){\n" +

			"global $time;\n";
		}else {
			wipeUD = wipeUD +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset){\n";
		}
		wipeUD = wipeUD +
		//morya kokomade
			"for($i=0; $i<$offset; $i++)  {\n" +
		  	"$mask->move(0,$movieheight/$offset);\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			wipeUD = wipeUD +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		wipeUD = wipeUD +
		//morya kokomade
		  	"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			wipeUD = wipeUD +
			"$time++;\n";
		}
		wipeUD = wipeUD +
		//morya kokomade
			"}\n" +
			"for($i=0;$i<$rate*$duration;$i++){\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			wipeUD = wipeUD +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		wipeUD = wipeUD +
		//morya kokomade
				"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			wipeUD = wipeUD +
			"$time++;\n";
		}
		wipeUD = wipeUD +
		//morya kokomade
			"}\n" +
			"for($i=0; $i<$offset; $i++)   {\n" +
		  	"$mask->move(0,(-1)*$movieheight/$offset);\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			wipeUD = wipeUD +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		wipeUD = wipeUD +
		//morya kokomade
		  	"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			wipeUD = wipeUD +
			"$time++;\n";
		}
		wipeUD = wipeUD +
		//morya kokomade
			"}\n" +
		"}\n\n";
		swf_env.function.append(wipeUD);
	}

	public void writeWipeLRFunc(){
		String wipeLR =
		"//\n";
		//morya wrote
		if (swf_env.telop != "false"){
			wipeLR = wipeLR +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$tname,$tx,$ty,$tw,$th,$tcolor,$tsize,$timefrom,$timeto,$tstr){\n" +

			"global $time;\n";
		}else {
			wipeLR = wipeLR +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset){\n";
		}
		wipeLR = wipeLR +
		//morya kokomade
			"for($i=0; $i<$offset; $i++)  {\n" +
		  	"$mask->move($moviewidth/$offset,0);\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			wipeLR = wipeLR +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		wipeLR = wipeLR +
		//morya kokomade
		  	"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			wipeLR = wipeLR +
			"$time++;\n";
		}
		wipeLR = wipeLR +
		//morya kokomade
			"}\n" +
			"for($i=0;$i<$rate*$duration;$i++){\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			wipeLR = wipeLR +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		wipeLR = wipeLR +
		//morya kokomade
				"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			wipeLR = wipeLR +
			"$time++;\n";
		}
		wipeLR = wipeLR +
		//morya kokomade
			"}\n" +
			"for($i=0; $i<$offset; $i++)   {\n" +
		  	"$mask->move((-1)*$moviewidth/$offset,0);\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			wipeLR = wipeLR +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		wipeLR = wipeLR +
		//morya kokomade
		  	"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			wipeLR = wipeLR +
			"$time++;\n";
		}
		wipeLR = wipeLR +
		//morya kokomade
			"}\n" +
		"}\n\n";
		swf_env.function.append(wipeLR);
	}

	public void writeNextFunc(){
		String next =
		"//\n";
		//morya wrote
		if (swf_env.telop != "false"){
			next = next +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$tname,$tx,$ty,$tw,$th,$tcolor,$tsize,$timefrom,$timeto,$tstr){\n" +

			"global $time;\n";
		}else {
			next = next +
			"function toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset){\n";
		}
		next = next +
		//morya kokomade
			"for($i=0;$i<$rate*$duration;$i++){\n";
		//morya wrote telopFieldCall
		if (swf_env.telop != "false"){
			next = next +
			"$stime = (float)$time / (float)$rate;\n" +
			"for($k=0;$k<count($tname);$k++){\n" +
			"if($stime==(float)$timefrom[$k]){\n" +
			"$tp = \"\n" +
			"telopField('$tname[$k]',$tx[$k],$ty[$k],$tw[$k],$th[$k],'$tcolor[$k]',$tsize[$k],'$tstr[$k]');\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"if($stime==(float)$timeto[$k]){\n" +
			"$tp = \"\n" +
			"_root['$tname[$k]'].removeTextField();\n" +
			"\";\n" +
			"$movie->add(new SWFAction($tp));\n" +
			"}\n" +
			"}\n";
		}
		next = next +
		//morya kokomade
				"$movie->nextFrame();\n";
		//morya wrote
		if (swf_env.telop != "false"){
			next = next +
			"$time++;\n";
		}
		next = next +
		//morya kokomade
			"}\n" +
		"}\n\n";
		swf_env.function.append(next);
	}

	// edit tomo 2007.12.23
	public void writeDispFrameFunc(){
		String frame;
		//morya modify
		if (swf_env.telop != "false"){
			frame =
				"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype,$mw,$tname,$tx,$ty,$tw,$th,$tcolor,$tsize,$timefrom,$timeto,$tstr){\n";
		}else {
			frame =
				"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype,$mw){\n";
		}
		//morya kokomade
		//String frame =
		//"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath){\n";
		frame = frame +
//			"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath){\n" +

//			"addTextField($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str);\n";
//			"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype){\n" +
			//"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype,$mw){\n" +
			"// \n" +
			"addTextField($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$texttype);\n" +
//			"addTelop($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$texttype,$rate);\n" +
			"addTelop($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$texttype,$rate,$mw);\n" +
			"addScroll($movie, $name, $x, $y, $w, $h, $bgcolor, $bdcolor, $color, $size, $align, $margin, $str, $texttype,$rate);\n";
		if(swf_env.containImg){
			frame += "// \n" +
			"$addedImg = addImage($movie,$imgpath,$x,$y,$margin);\n";
		}
		//morya modify
		if (swf_env.telop != "false"){
			frame += "// \n" +
			"toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$tname,$tx,$ty,$tw,$th,$tcolor,$tsize,$timefrom,$timeto,$tstr);\n" +
			"// \n"+
			"removeTextField($movie,$name,$texttype);\n";
		}else {
			frame += "// \n" +
			"toNext($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset);\n" +
			"// \n"+
			"removeTextField($movie,$name,$texttype);\n";
		}
		//morya kokomade
		if(swf_env.containImg){
			frame += "removeImage($movie,$addedImg);\n";
		}
		frame += "}\n\n";
		swf_env.function.append(frame);
	}

	// edit tomo 2007.12.23
	public void writeDispFrameFunc2(){
		String frame =
//			"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath){\n" +

//			"addTextField($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str);\n";
//			"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype){\n" +
			"function frame($movie,$mask,$moviewidth,$movieheight,$rate,$duration,$offset,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$imgpath,$texttype,$mw){\n" +

			"addTextField($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$texttype);\n" +
//			"addTelop($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$texttype,$rate);\n" +
			"addTelop($movie,$name,$x,$y,$w,$h,$bgcolor,$bdcolor,$color,$size,$align,$margin,$str,$texttype,$rate,$mw);\n" +
			"addScroll($movie, $name, $x, $y, $w, $h, $bgcolor, $bdcolor, $color, $size, $align, $margin, $str, $texttype,$rate);\n";
		if(swf_env.containImg){
			frame += "// \n" +
			"$addedImg = addImage($movie,$imgpath,$x,$y,$margin);\n";
		}
		frame += "}\n\n";
		swf_env.function.append(frame);
	}
//	2007.12.16 tomo
	public void writeButtonFunc(boolean visible){
		if (visible) {
			String str =
				"function createController() {\n"+
				"global $movie, $duration, $rate;\n"+
				"$cnt = $duration * $rate;\n" +
//				"$cnt = 1 * $rate;" +
				"\n"+
				"$sh_button_next=new SWFShape(); \n"+
				"$sh_button_next->setLine(2,0,0,0);\n"+
				"$sh_button_next->setRightFill(0,255,0);\n"+
				"$sh_button_next->movePenTo(0,5);\n"+
				"$sh_button_next->drawLine(0,14);\n"+
				"$sh_button_next->drawLine(10,-7);\n"+
				"$sh_button_next->drawLine(0,7);\n"+
				"$sh_button_next->drawLine(10,-7);\n"+
				"$sh_button_next->drawLine(-10,-7);\n"+
				"$sh_button_next->drawLine(0,7);\n"+
				"$sh_button_next->drawLine(-10,-7);\n"+
				"$button_next = new SWFButton();\n"+
				"$button_next->addShape($sh_button_next, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n"+
//				"$button_next->addAction(new SWFAction(\"nextframe();play();\"), SWFBUTTON_MOUSEUP);\n"+
				"$button_next->addAction(new SWFAction(\"gotoAndPlay(( int(_currentframe / $cnt) + 1) * $cnt);\"), SWFBUTTON_MOUSEUP);\n"+
				"$ib1=$movie->add($button_next);\n"+
				"$ib1->moveTo(115,3);\n"+
				"\n"+
				"$sh_button_play=new SWFShape(); \n"+
				"$sh_button_play->setLine(2,0,0,0); \n"+
				"$sh_button_play->setRightFill(0,255,0);\n"+
				"$sh_button_play->movePenTo(0,5);\n"+
				"$sh_button_play->drawLine(0,20);\n"+
				"$sh_button_play->drawLine(20,-10);\n"+
				"$sh_button_play->drawLine(-20,-10);\n"+
				"$button_play = new SWFButton();\n"+
				"$button_play->addShape($sh_button_play, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n"+
				"$button_play->addAction(new SWFAction(\"play();\"), SWFBUTTON_MOUSEUP);\n"+
				"$ib2=$movie->add($button_play);\n"+
				"$ib2->moveTo(80,0);\n"+
				"\n"+
				"$sh_button_stop=new SWFShape(); \n"+
				"$sh_button_stop->setLine(2,0,0,0); \n"+
				"$sh_button_stop->setRightFill(0,255,0);\n"+
				"$sh_button_stop->movePenTo(0,5);\n"+
				"$sh_button_stop->drawLine(0,20);\n"+
				"$sh_button_stop->drawLine(20,0);\n"+
				"$sh_button_stop->drawLine(0,-20);\n"+
				"$sh_button_stop->drawLine(-20,0);\n"+
				"$button_stop = new SWFButton();\n"+
				"$button_stop->addShape($sh_button_stop, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n"+
				"$button_stop->addAction(new SWFAction(\"stop();\"), SWFBUTTON_MOUSEUP);\n"+
				"$ib3=$movie->add($button_stop);\n"+
				"$ib3->moveTo(45,0);\n"+
				"\n"+
				"$sh_button_prev=new SWFShape(); \n"+
				"$sh_button_prev->setLine(2,0,0,0); \n"+
				"$sh_button_prev->setRightFill(0,255,0);\n"+
				"$sh_button_prev->movePenTo(20,5);\n"+
				"$sh_button_prev->drawLine(0,14);\n"+
				"$sh_button_prev->drawLine(-10,-7);\n"+
				"$sh_button_prev->drawLine(0,7);\n"+
				"$sh_button_prev->drawLine(-10,-7);\n"+
				"$sh_button_prev->drawLine(10,-7);\n"+
				"$sh_button_prev->drawLine(0,7);\n"+
				"$sh_button_prev->drawLine(10,-7);\n"+
				"$button_prev = new SWFButton();\n"+
				"$button_prev->addShape($sh_button_prev, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n"+
//				"$button_prev->addAction(new SWFAction(\"prevframe();play();\"), SWFBUTTON_MOUSEUP);\n" +
				"$button_prev->addAction(new SWFAction(\"gotoAndPlay( ((int(_currentframe / $cnt) - 1) * $cnt) +1);prevFrame();play();\"), SWFBUTTON_MOUSEUP);" +
//				"$button_prev->addAction(new SWFAction(\"gotoAndPlay(( int(_currentframe / $cnt) - 1) * $cnt);\"), SWFBUTTON_MOUSEUP);\n"+
				"$ib4=$movie->add($button_prev);\n"+
				"$ib4->moveTo(10,3);\n"+
				"}\n";
			str += "createController();\n";

			swf_env.function.append(str);
		} else {

			String str ="function createController() {\n"+
			"global $movie, $duration, $rate, $moviewidth, $movieheight;\n" +
			"$cnt = $duration * $rate;\n" +
			"//$cnt = 1 * $rate;\n" +
			"\n" +
			"$sh_button_next=new SWFShape(); \n" +
			"$sh_button_next->setLine(2,0,0,0);\n" +
			"$sh_button_next->setRightFill(0,255,0);\n" +
			"$sh_button_next->movePenTo(0,0);\n" +
			"$sh_button_next->drawLine($moviewidth / 2, 0);\n" +
			"$sh_button_next->drawLine(0, $movieheight);\n" +
			"$sh_button_next->drawLine(-($moviewidth / 2), 0);\n" +
			"$sh_button_next->drawLine(0, -($movieheight));\n" +
			"$button_next = new SWFButton();\n" +
			"$button_next->addShape($sh_button_next, SWFBUTTON_HIT);\n" +
			"$button_next->addAction(new SWFAction(\"gotoAndPlay(( int(_currentframe / $cnt) + 1) * $cnt);\"), SWFBUTTON_MOUSEUP);\n" +
			"$ib1=$movie->add($button_next);\n" +
			"$ib1->moveTo($moviewidth / 2, 0);\n" +
			"\n" +
			"$sh_button_prev=new SWFShape(); \n" +
			"$sh_button_prev->setLine(2,0,0,0); \n" +
			"$sh_button_prev->setRightFill(0,255,0);\n" +
			"$sh_button_prev->movePenTo(0,0);\n" +
			"$sh_button_prev->drawLine($moviewidth / 2, 0);\n" +
			"$sh_button_prev->drawLine(0, $movieheight);\n" +
			"$sh_button_prev->drawLine(-($moviewidth / 2), 0);\n" +
			"$sh_button_prev->drawLine(0, -($movieheight));\n" +
			"$button_prev = new SWFButton();\n" +
			"$button_prev->addShape($sh_button_prev, SWFBUTTON_HIT);\n" +
//			"$button_prev->addAction(new SWFAction(\"gotoAndPlay(( int(_currentframe / $cnt) - 1) * $cnt);\"), SWFBUTTON_MOUSEUP);\n" +
			"$button_prev->addAction(new SWFAction(\"gotoAndPlay( ((int(_currentframe / $cnt) - 1) * $cnt) +1);prevFrame();play();\"), SWFBUTTON_MOUSEUP);" +
			"$ib4=$movie->add($button_prev);\n" +
			"$ib4->moveTo(0,0);\n" +
			"}\n" +
			"createController();\n";
			swf_env.function.append(str);
		}
	}

	//12/7 morya wrote
	public void writeInteractionFunc(){
		String str =
			"function createInteractionButton($visibleflag,$lx,$ly,$lw,$lh,$lstop,$int_name,$int_namet,$lnum,$inter_name,$tmp,$limgnum){\n" +
			"global $movie;\n" +
			"for($i=0;$i<count($visibleflag);$i++){\n" +
			"$linkmask = new SWFShape();\n" +
			"$linkmask->setLine(0,0,0,0,0);\n" +
			"$linkmask->setRightFill(0, 0, 0, 0);\n" +
			"$linkmask->movePenTo($lx[$i], $ly[$i]);\n" +
			"$linkmask->drawLine($lw[$i], 0);\n" +
			"$linkmask->drawLine(0,$lh[$i]); \n" +
			"$linkmask->drawLine(-$lw[$i],0);\n" +
			"$linkmask->drawLine(0,-$lh[$i]);\n" +
			"$linkbutton = new SWFButton();\n" +
			"$linkbutton->addShape($linkmask, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n\n" +
			"$vf .= \"if($visibleflag[$i]==0){ \";\n" +
			"for($j=0;$j<count($lnum);$j++){\n" +
			"if($lnum[$j]==$i){\n" +
			"$vf .= \"_root['$int_name[$j]']._visible =true;\n" +
			"_root['$int_namet[$j]']._visible =true; \";\n" +
			"}\n" +
			"}\n" +
			"for($j=0;$j<count($limgnum);$j++){\n" +
			"if($limgnum[$j]==$i){\n" +
			"$vf .= \"_root.$inter_name[$j]._visible =true;\n" +
			"$tmp[$j] = _root.$inter_name[$j]._visible; \";\n" +
			"}\n" +
			"}\n" +
			"$vf .= \"$visibleflag[$i] = 1; \";\n" +
			"if($lstop[$i]==0){\n" +
			"$vf .= \"stopped=false;\n" +
			"play(); \";\n" +
			"}else{\n" +
			"$vf .= \"stopped=true;\n" +
			"stop(); \";\n" +
			"}\n" +
			"$vf .= \"}else{ \";\n" +
			"for($j=0;$j<count($lnum);$j++){\n" +
			"if($lnum[$j]==$i){\n" +
			"$vf .= \"_root['$int_name[$j]']._visible =false;\n" +
			"_root['$int_namet[$j]']._visible =false; \";\n" +
			"}\n" +
			"}\n" +
			"for($j=0;$j<count($limgnum);$j++){\n" +
			"if($limgnum[$j]==$i){\n" +
			"$vf .= \"_root.$inter_name[$j]._visible =false;\n" +
			"$tmp[$j] = _root.$inter_name[$j]._visible; \";\n" +
			"}\n" +
			"}\n" +
			"$vf .= \"$visibleflag[$i] = 0;\n" +
			"stopped=false;\n" +
			"play();" +
			"} \";\n" +
			"$linkbutton->addAction(new SWFAction($vf), SWFBUTTON_MOUSEUP);\n" +
			"$vf = \"\";\n\n" +
			"$lbswf = $movie->add($linkbutton);\n" +
			"$lbswf->setDepth(50000+$i);\n" +
			"}\n" +
			"}\n\n";
		swf_env.function.append(str);
	}

	//12/7 morya wrote
	public void writeAddIntT(){
		String str =
			"function addInteractionText($int_name,$int_namet,$int_x,$int_y,$int_w,$int_h,$int_bgcolor,$int_bdcolor,$int_color,$int_alpha,$int_size,$int_align,$int_margin,$int_str){\n" +
			"global $movie;\n" +
			"for($i=0;$i<count($int_name);$i++){\n" +
			"$vf .= \"interactionFieldAS('$int_name[$i]','$int_namet[$i]',$int_x[$i],$int_y[$i],$int_w[$i],$int_h[$i],'$int_bgcolor[$i]','$int_bdcolor[$i]','$int_color[$i]','$int_alpha[$i]',$int_size[$i],'$int_align[$i]',$int_margin[$i],'$int_str[$i]'); \";\n" +
			"}\n" +
			"$movie->add(new SWFAction($vf));\n" +
			"}\n\n";
		swf_env.function.append(str);
	}
	//12/7 morya wrote
	public void writeAddIntI(){
		String str =
			"function addInteractionImage($movie,$imgpath,$x,$y,$w,$h,$name){\n" +
			"for($i=0;$i<count($imgpath);$i++){\n" +
			"$openedImga = new SWFBitmap(fopen(\"$imgpath[$i]\",\"rb\"));\n" +
			"$shape = new SWFShape();\n" +
			"$fill = $shape->addFill($openedImga);\n" +
			"$shape->setRightFill($fill);\n" +
			"$shape->movepento(0, 0);\n" +
			"$shape->drawlineto($openedImga->getWidth(), 0);\n" +
			"$shape->drawlineto($openedImga->getWidth(), $openedImga->getHeight());\n" +
			"$shape->drawlineto(0, $openedImga->getHeight());\n" +
			"$shape->drawlineto(0, 0);\n" +
			"$shbu = new SWFButton();\n" +
			"$shbu->addShape($shape, SWFBUTTON_UP | SWFBUTTON_DOWN);\n" +
			"$addedImga[$i] = $movie->add($shbu);\n" +
			"$addedImga[$i]->setDepth(300000+$i);\n" +
			"$addedImga[$i]->scaleTo($w[$i]/$openedImga->getWidth(),$h[$i]/$openedImga->getHeight());\n" +
			"$addedImga[$i]->MoveTo($x[$i],$y[$i]);\n" +
			"$addedImga[$i]->setName($name[$i]);\n" +
			"}\n" +
			"return $addedImga;\n" +
			"}\n\n";
		swf_env.function.append(str);
	}
	//12/7 morya wrote
	public void writeAddITemp(){
		String str =
			"function addImageTemp($inter_name,$tmp){\n" +
			"global $movie;\n" +
			"for($i=0;$i<count($inter_name);$i++){\n" +
			"$vf .= \"_root.$inter_name[$i]._visible = $tmp[$i]; \";\n" +
			"}\n" +
			"$movie->add(new SWFAction($vf));\n" +
			"}\n\n";
		swf_env.function.append(str);
	}


	private void writeTelopFunc(){
		String str =
//			"function addTelop($movie, $name, $x, $y, $w, $h, $bgcolor, $bdcolor, $color, $size, $align, $margin, $str, $texttype,$rate) {\n" +
			"function addTelop($movie, $name, $x, $y, $w, $h, $bgcolor, $bdcolor, $color, $size, $align, $margin, $str, $texttype,$rate,$mw) {\n" +
			"global $telops,$duration;\n" +
			"for ($i = 0; $i < count($name); $i++){\n" +
			"// \n" +
			"if ($texttype[$i] == \"telop\") { // \n" +
			"// \n" +
			"$mask = new SWFShape();\n" +
			"$mask->setLine(2,0,0,0); \n" +
			"$mask->setRightFill(0xff, 0xff, 0xff);\n" +
			"$mask->movePenTo($x[$i], $y[$i]); \n" +
			"$mask->drawLine($w[$i], 0); \n" +
			"$mask->drawLine(0,$h[$i]); \n" +
			"$mask->drawLine(-($w[$i]),0);\n" +
			"$mask->drawLine(0,-($h[$i])); \n" +
			"\n" +
			"//\n" +
			"$font = new SWFFont(\"Bitstream Vera Sans.fdb\");\n" +
			"$text = new SWFText();\n" +
			"$text->setFont($font);\n" +
			"//$text->setColor($color[$i]);\n" +
			"$text->setColor(0,0,0);\n" +
			"//$text->moveTo($x[$i], $y[$i]); \n" +
			"$text->setHeight($h[$i] * 0.7);\n" +
			"$text->addString($str[$i]);\n" +
			"\n" +
			"$telopmovie = new SWFSprite();\n" +
			"$item = $telopmovie->add($mask);\n" +
			"$item->setMaskLevel(444444);\n" +
			"$item = $telopmovie->add($mask);\n" +
			"$item1 = $telopmovie->add($text);\n" +
			"\n" +
			"$telopmovie->add(new SWFAction(\"stop();\"));\n" +
			"$button = new SWFButton();\n" +
			"$button->addshape($mask, SWFBUTTON_HIT);\n" +
			"$button->addAction(new SWFAction(\"stop();\"), SWFBUTTON_OVER);\n" +
			"$button->addAction(new SWFAction(\"play();\"), SWFBUTTON_UP);\n" +
			"$item2 = $telopmovie->add($button);\n" +
			"\n" +
			"for ($len = 0;$len < $w[$i]; $len = $len + ($w[$i])/($rate*$duration)){\n" +
//			"for ($len = -($w[$i]);$len < $w[$i]; $len = $len + ($w[$i])/$rate){\n" +
			//"for ($len = -100;$len < 100; $len = $len + 10){\n" +
			"$item1->moveTo($x[$i] - $len, $y[$i] + $h[$i]*0.72);\n" +
			"$telopmovie->nextframe();\n" +
			"}\n" +
			"$telops[$i] = $movie->add($telopmovie);\n" +
			"}\n" +
			"}\n" +
			"}\n\n";
		swf_env.function.append(str);
	}
//	private void writeScrollFunc(){
//	String str =
//	"function addScroll($movie, $name, $x, $y, $w, $h, $bgcolor, $bdcolor, $color, $size, $align, $margin, $str, $texttype,$rate) {\n" +
//	"global $telops,$movieheight;\n" +
//	"\n" +
//	"for ($i = 0; $i < count($name); $i++) {\n" +

//	"\n" +
//	"$mask = new SWFShape();\n" +
//	"$mask->setLine(2,0,0,0); \n" +
//	"$mask->setRightFill(0xff, 0xff, 0xff);\n" +
//	"$mask->movePenTo($x[$i], $y[$i]); \n" +
//	"$mask->drawLine($w[$i]+10, 0); \n" +
//	"$mask->drawLine(0,$h[$i]); \n" +
//	"$mask->drawLine(-($w[$i]+10),0);\n" +
//	"$mask->drawLine(0,-($h[$i])); \n" +
//	"\n" +
//	"$button_scroll_up = new SWFShape();\n" +
//	"$button_scroll_up->setRightFill(0,0,0);\n" +
//	"$button_scroll_up->setLine(2,0,0,0);\n" +
//	"$button_scroll_up->movePenTo($x[$i] + $w[$i], $y[$i]);\n" +
//	"$button_scroll_up->drawLine(-8,0);\n" +
//	"$button_scroll_up->drawLine(0,3);\n" +
//	"$button_scroll_up->drawLine(8,0);\n" +
//	"$button_scroll_up->drawLine(0,-3);\n" +
//	"\n" +
//	"$button_scroll_down = new SWFShape();\n" +
//	"$button_scroll_down->setRightFill(0,0,0);\n" +
//	"$button_scroll_down->setLine(2,0,0,0);\n" +
//	"$button_scroll_down->movePenTo($x[$i] + $w[$i], $y[$i] + $h[$i]);\n" +
//	"$button_scroll_down->drawLine(-8,0);\n" +
//	"$button_scroll_down->drawLine(0,-3);\n" +
//	"$button_scroll_down->drawLine(8,0);\n" +
//	"$button_scroll_down->drawLine(0,3);\n" +
//	"\n" +
//	"$downbutton = new SWFButton();\n" +
//	"$downbutton->addShape($button_scroll_down, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n" +
//	"$upbutton = new SWFButton();\n" +
//	"$upbutton->addShape($button_scroll_up, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n" +
//	"\n" +

//	"$font = new SWFFont(\"Bitstream Vera Sans.fdb\");\n" +
//	"//$text = new SWFTextField(SWFTEXTFIELD_HTML);\n" +
//	"$text = new SWFText();\n" +
//	"$text->setFont($font);\n" +
//	"$text->setColor(0,0,0);\n" +
//	"$text->setHeight($h[$i] * 0.7);\n" +
//	"$text->addString($str[$i]);\n" +
//	"\n" +
//	"$scrmovie = new SWFSprite();\n" +
//	"$item = $scrmovie->add($mask);\n" +
//	"$item->setMaskLevel(444444);\n" +
//	"$item = $scrmovie->add($mask);\n" +
//	"\n" +
//	"$scrmovie->add(new SWFAction('stop();'));\n" +
//	"$downbutton->addAction(new SWFAction('nextFrame();_root.stop();'), SWFBUTTON_MOUSEDOWN);\n" +
//	"$upbutton->addAction(new SWFAction('prevFrame();_root.stop();'), SWFBUTTON_MOUSEDOWN);\n" +
//	"$scrmovie->add($downbutton);\n" +
//	"$scrmovie->add($upbutton);\n" +
//	"$item1 = $scrmovie->add($text);\n" +
//	"\n" +
//	"for ($hei = 0;$hei < $h[$i]; $hei = $hei + ($h[$i])/$rate*2){\n" +
//	"$item1->moveTo($x[$i], $y[$i] + $h[$i]*0.72 - $hei);\n" +
//	"$scrmovie->nextframe();\n" +
//	"}\n" +
//	"$telops[$i] = $movie->add($scrmovie);\n" +
//	"\n" +
//	"}\n" +
//	"}\n" +
//	"\n" +
//	"}\n" ;
//	swf_env.function.append(str);
//	}

//	edit tomo 2007.12.29
	private void writeScrollFunc() {
		String str =
			"function addScroll($movie, $name, $x, $y, $w, $h, $bgcolor, $bdcolor, $color, $size, $align, $margin, $str, $texttype,$rate) {\n" +
			"global $masks,$scrolls;\n" +
			"\n" +
			"for ($i = 0; $i < count($name); $i++) {\n" +
			"if ($texttype[$i] == \"scroll\") { // \n" +
			"//\n" +
			"$button_scroll_up = new SWFShape();\n" +
			"$button_scroll_up->setRightFill(0,0,0);\n" +
			"$button_scroll_up->setLine(2,0,0,0);\n" +
			"$button_scroll_up->movePenTo($x[$i] + $w[$i] + 4, $y[$i]);\n" +
			"$button_scroll_up->drawLine(-4,8);\n" +
			"$button_scroll_up->drawLine(8,0);\n" +
			"$button_scroll_up->drawLine(-4,-8);\n" +
			"// \n" +
			"$button_scroll_down = new SWFShape();\n" +
			"$button_scroll_down->setRightFill(0,0,0);\n" +
			"$button_scroll_down->setLine(2,0,0,0);\n" +
			"$button_scroll_down->movePenTo($x[$i] + $w[$i] + 4, $y[$i] + $h[$i]);\n" +
			"$button_scroll_down->drawLine(-4,-8);\n" +
			"$button_scroll_down->drawLine(8,0);\n" +
			"$button_scroll_down->drawLine(-4,8);\n" +
			"\n" +
			"$downbutton = new SWFButton();\n" +
			"$downbutton->addShape($button_scroll_down, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n" +
			"$upbutton = new SWFButton();\n" +
			"$upbutton->addShape($button_scroll_up, SWFBUTTON_HIT | SWFBUTTON_UP | SWFBUTTON_DOWN | SWFBUTTON_OVER);\n" +
			"\n" +
			"\n" +
			"$strAction=\"\n" +
			"_global.len = 0;\n" +
			"this.createTextField('scr\".$name[$i].\"',100,\".$x[$i].\",\".$y[$i].\",\".$w[$i].\",\".$h[$i].\");\n" +
			"with(scr\".$name[$i].\"){ \n" +
			"border = false; \n" +
			"html = true; \n" +
			"wordWrap=true;\n" +
			"scrollWheelEnabled=true;\n" +
			"htmlText = '\".$str[$i].\"';\n" +
			"}\n" +
			"\";\n" +
			"$downAction.=\"\n" +
			"this.scr\".$name[$i].\".scroll++;\n" +
//
//			"this.scr\".$name[$i].\".removetextField();\n" +
//			"_global.len = _global.len + 3;\n" +
//			"if(_global.len >= \".$h[$i].\"){\n" +
//			"_global.len = \".$h[$i].\";\n" +
//			"}\n" +
//			"this.createTextField('scr\".$name[$i].\"',100,\".$x[$i].\",\".$y[$i].\"- _global.len,\".$w[$i].\",\".$h[$i].\");\n" +
//			"with(scr\".$name[$i].\"){ \n" +
//			"border = false; \n" +
//			"html = true; \n" +
//			"wordWrap=true;\n" +
//			"scrollWheelEnabled=true;\n" +
//			"htmlText = '\".$str[$i].\"';\n" +
//			"}\n" +
//			"//_root.stop();\n" +
			"_root.play();\n" +
			"\";\n" +
			"$upAction.=\"\n" +
			"this.scr\".$name[$i].\".scroll--;\n" +
//			"this.scr\".$name[$i].\".removetextField();\n" +
//			"_global.len = _global.len - 3;\n" +
//			"if(_global.len <= 0){\n" +
//			"_global.len = 0;\n" +
//			"}\n" +
//			"this.createTextField('scr\".$name[$i].\"',100,\".$x[$i].\",\".$y[$i].\"- _global.len,\".$w[$i].\",\".$h[$i].\");\n" +
//			"with(scr\".$name[$i].\"){ \n" +
//			"border = false; \n" +
//			"html = true; \n" +
//			"wordWrap=true;\n" +
//			"scrollWheelEnabled=true;\n" +
//			"htmlText = '\".$str[$i].\"';\n" +
//			"}\n" +
//			"//_root.stop();\n" +
			"_root.play();\n" +
			"\";\n" +
			"\n" +
			"$mask = new SWFShape();\n" +
			"$mask->setRightFill(0xff, 0xff, 0xff);\n" +
			"$mask->setLine(2,0,0,0);\n" +
			"$mask->movePenTo($x[$i], $y[$i]);\n" +
			"$mask->drawLine($w[$i]+10, 0);\n" +
			"$mask->drawLine(0, ($h[$i]));\n" +
			"$mask->drawLine(-($w[$i]+10),0);\n" +
			"$mask->drawLine(0,-($h[$i]));\n" +
			"\n" +
			"$maskmovie = new SWFSprite();\n" +
			"$maskmovie->add($mask);\n" +
			"$maskmovie->nextFrame();\n" +
			"\n" +
			"$masks[$i] = $movie->add($maskmovie);\n" +
			"$masks[$i]->setName(\"mask\".$name[$i]);\n" +
			"\n" +
			"$scrmovie = new SWFSprite();\n" +
			"\n" +
			"$scrmovie->add(new SWFAction($strAction));\n" +
			"$scrmovie->add(new SWFAction(\"this.setMask('mask\".$name[$i].\"');\"));\n" +
			"$downbutton->addAction(new SWFAction($downAction), SWFBUTTON_MOUSEDOWN);\n" +
			"$upbutton->addAction(new SWFAction($upAction), SWFBUTTON_MOUSEDOWN);\n" +
			"$scrmovie->add($mask);\n" +
			"$scrmovie->add($downbutton);\n" +
			"$scrmovie->add($upbutton);\n" +
			"\n" +
			"$scrmovie->nextFrame();\n" +
			"$scrolls[$i] = $movie->add($scrmovie);\n" +
			"\n" +
			"}\n" +
			"}\n" +
			"\n" +
			"}\n";
		swf_env.function.append(str);
	}

}
