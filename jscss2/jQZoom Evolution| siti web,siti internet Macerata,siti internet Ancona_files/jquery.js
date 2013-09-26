(function($){
	//creating GLOBAL VARIABLES
	var isIE6	 = ($.browser.msie && $.browser.version < 7);
	var isIE	 = $.browser.msie;
	var $body	 = $(document.body);
	var $window	 = $(window);
	var $overlay = null;
	var $cbox = null;
	var $wrap = null;
	var $loadingBay = null;
	var $content = null;
	var $loaded =  null;
	var $loadingOverlay =  null;
	var $loadingGraphic =  null;
	var $title =  null;
	var $current =  null;
	var $slideshow =  null;
	var $next =  null;
	var $prev =  null;
	var $close =  null;
	var hover = 'hover';
	var	TRUE = true;
	var FALSE = false;
	var settings = null;
	var open = false;
	// Variables for cached values or use across multiple functions
	var interfaceHeight = 0;
	var interfaceWidth = 0;
	var loadedHeight = 0;
	var loadedWidth = 0;
	var element = null;
	var bookmark = null;
	var index = 0;
	var settings = null;
	var open = false;
	var active = false;

	// Event Strings (to increase compression)
	var colorbox = 'colorbox';
	var cbox_open = 'cbox_open';
	var cbox_load = 'cbox_load';
	var cbox_complete = 'cbox_complete';
	var cbox_cleanup = 'cbox_cleanup';
	var cbox_closed = 'cbox_closed';
	var cbox_resize = 'resize.cbox_resize';

	// ColorBox Default Settings.
	// See http://colorpowered.com/colorbox for details.
	DEFAULTS = {
		transition: "elastic",
		speed: 350,
		width: false,
		height: false,
		innerWidth: false,
		innerHeight: false,
		initialWidth: "200",
		initialHeight: "100",
		maxWidth: false, //**potrebbero essre eliminate o meglio,se non � settata un precisa dimensione prendo quello della pagina
		maxHeight: false,//**potrebbero essre eliminate
		scalePhotos: true, //ridimensiona le photo
		scrolling: true,  //**potrebbero essre eliminate
		inline: false,//**potrebbero essre eliminate
		html: false,//**potrebbero essre eliminate
		iframe: false,
		photo: false,//**potrebbero essre eliminate
		href: false,
		title: false,
		rel: false,
		opacity: 0.75,
		preloading: true, //da analizzare meglio sarebbe da fare anceh il rpeload delle immagini
		current: "{current}/{total}",
		previous: "previous",
		next: "next",
		close: "close",
		//open: false,
		overlayClose: true,

		//linkList: [],
		content : '',
		fixed: true,
		showOverlay:true,
		formatResponse: function(data){return data;}, //#MOD formatta la risposta ajax
		json:false,

		slideshow: false, ////**potrebbero essre eliminato,tanto se ce ne sono + di una lascio scegliere all'utente dice se mostrare la modalit� e il pulsante slideshow
		slideshowAutoStart: true, //dice se avviare lo slideshow
		slideshowSpeed: 5000,
		slideshowStart: "start slideshow",
		slideshowStop: "stop slideshow",

		onOpen: false,
		onLoad: false,
		onComplete: false,
		onCleanup: false,
		onClosed: false
	};

	$.fn.jqbox = function(options)
	{

		return this.each(function() {
			var node = this.nodeName.toLowerCase();
			 if (node == 'a') {
			 	$(this).addClass('jqbox_elem');
			 	$(this).bind('click', function (e) {
					if (e.button !== 0 && typeof e.button !== 'undefined') {// checks to see if it was a non-left mouse-click.
						return true;
					} else {
				 		var temp_opts = $.extend({},{trigger_element : this,title : this.title}, options || {});
						new jqbox(false,temp_opts);
						$(this).blur();
						return false;
					}
				 	//vado a recuperare i contenuti per passarli alla funzione
				 	//passo o il contenuto secco o un array di title/href

			 	});
			 }



		});

	}

	var jqbox = function(content,options)
	{
		var obj = this;
		this.settings = settings = $.extend({},DEFAULTS, options || {});
		var boxContent = content;
		obj.firsttime = true;

		//this.element = settings.trigger_element;
		//settings.rel = settings.rel || element.rel;
		//settings.href = settings.href || element.href;
		//settings.title = settings.title || element.title;

		/*1) verifico se non � settato il content che ha la precedenza su ogni cosa
		1) verifico se � settato settings.href
		2) SI: allora verifico se settings.href � un oggetto o singolo link
		3) NO: verifico se � settato settings.trigger_element
		3) NO: verifico se mi � stato passato del contenuto diretto nel content
		*/







		/*if (settings.rel && settings.rel !== 'nofollow') {
			$related = $('.cboxElement').filter(function () {
				var relRelated = $(this).data(colorbox).rel || this.rel;
				return (relRelated === settings.rel);
			});
			//trova a che indice sta l'emento cliccato
			index = $related.index(element);


			// Check direct calls to ColorBox.
			if (index < 0) {
				$related = $related.add(element);
				index = $related.length - 1;
			}
		} else {
			$related = $(element);
			index = 0;
		}*/



		$.extend(obj,{
			init: function() //Init function creating the box and the overlay
			{
				//alert('init');
				// jQuery object generator to save a bit of space
				function $div(id) {
					return $('<div id="cbox' + id + '"/>');
				}

				/*
				<div id="cboxOverlay" style="display: block; cursor: pointer; opacity: 0.9;"></div>
				<div id="colorbox" style="padding-bottom: 42px; padding-right: 42px; display: block; width: 769px; height: 643px; top: 0px; left: 226.5px;" class="fixed">
					<div id="cboxWrapper" style="height: 685px; width: 811px;">
						<div>
							<div id="cboxTopLeft" style="float: left;"></div>
							<div id="cboxTopCenter" style="float: left; width: 769px;"></div>
							<div id="cboxTopRight" style="float: left;"></div>
						</div>
						<div>
							<div id="cboxMiddleLeft" style="float: left; height: 643px;"></div>
							<div id="cboxContent" style="float: left; width: 769px; height: 643px;">
								<div id="cboxLoadedContent" style="display: block; width: 769px; overflow: auto; height: 615px;">
									<img width="769" height="615" src="http://127.0.0.1/colorbox/content/Modifiche.jpg" id="cboxPhoto" style="margin: auto; border: medium none; display: block; float: none; cursor: pointer;">
								</div>
								<div id="cboxLoadingOverlay" class="" style="height: 643px; display: none;"></div>
								<div id="cboxLoadingGraphic" class="" style="height: 643px; display: none;"></div>
								<div id="cboxTitle" class="" style="display: block;">Me and my grandfather on the Ohoopee.</div>
								<div id="cboxCurrent" class="" style="display: block;">image 1 of 4</div>
								<div id="cboxSlideshow" class="" style="display: none;"></div>
								<div id="cboxNext" class="" style="display: block;">next</div>
								<div id="cboxPrevious" class="" style="display: block;">previous</div>
								<div id="cboxClose" class="">close</div>
							</div>
							<div id="cboxMiddleRight" style="float: left; height: 643px;"></div>
						</div>
						<div>
							<div id="cboxBottomLeft" style="float: left;"></div>
							<div id="cboxBottomCenter" style="float: left; width: 769px;"></div>
							<div id="cboxBottomRight" style="float: left;"></div>
						</div>
					</div>
					<div style="position: absolute; top: 0pt; left: 0pt; width: 9999px; height: 0pt;"></div>
				</div>
				*/

				// Create & Append jQuery Objects
				$cbox = $('<div id="colorbox"/>');

				$overlay = $div("Overlay").hide();
				$wrap = $div("Wrapper");
				$content = $div("Content").append(
				$loaded = $div("LoadedContent").css({width: 0, height: 0}),
				$loadingOverlay = $div("LoadingOverlay"),
				$loadingGraphic = $div("LoadingGraphic"),
				$title = $div("Title"),
				$current = $div("Current"),
				$slideshow = $div("Slideshow"),
				$next = $div("Next"),
				$prev = $div("Previous"),
				$close = $div("Close")
				);
				$wrap.append( // The 3x3 Grid that makes up ColorBox
					$('<div/>').append(
						$div("TopLeft"),
						$topBorder = $div("TopCenter"),
						$div("TopRight")
					),
					$('<div/>').append(
						$leftBorder = $div("MiddleLeft"),
						$content,
						$rightBorder = $div("MiddleRight")
					),
					$('<div/>').append(
						$div("BottomLeft"),
						$bottomBorder = $div("BottomCenter"),
						$div("BottomRight")
					)
				).children().children().css({'float': 'left'});

				//barra appesa al top
				$loadingBay = $("<div style='position:absolute; top:0; left:0; width:9999px; height:0;'/>");


        $('body').prepend($overlay, $cbox.append($wrap, $loadingBay));

				//$('body').prepend($cbox.append($wrap, $loadingBay)); //#MOD potrei decidere di non mostrare l'verlay

				if (isIE) {
					$cbox.addClass('cboxIE');
					if (isIE6) {
						$overlay.css('position', 'absolute');
					}
				}


				// Add rollover event to navigation elements
				$content.children()
				.bind('mouseover mouseout', function(){
					$(this).toggleClass(hover);
				}).addClass(hover);

				// Cache values needed for size calculations
				interfaceHeight = $topBorder.height() + $bottomBorder.height() + $content.outerHeight(TRUE) - $content.height();//Subtraction needed for IE6
				interfaceWidth = $leftBorder.width() + $rightBorder.width() + $content.outerWidth(TRUE) - $content.width();
				loadedHeight = $loaded.outerHeight(TRUE);
				loadedWidth = $loaded.outerWidth(TRUE);

				// Setting padding to remove the need to do size conversions during the animation step.
				$cbox.css({"padding-bottom": interfaceHeight, "padding-right": interfaceWidth});
        $cbox.hide();

				// Setup button & key events.
				$next.click(this.next);
				$prev.click(this.prev);
				$close.click(this.close);

				// Adding the 'hover' class allowed the browser to load the hover-state
				// background graphics.  The class can now can be removed.
				$content.children().removeClass(hover);

				$cbox.data('jqbox',obj);


				/*$('.cboxElement').live('click', function (e) {
					if (e.button !== 0 && typeof e.button !== 'undefined') {// checks to see if it was a non-left mouse-click.
						return TRUE;
					} else {
						alert('launch');
						launch(this);
						return FALSE;
					}
				});*/
			},
			process: function()
			{
				//alert('process');
				//da elaborare e sistemare,magari settando l'array degli href e del title per ognuno

				if($.isFunction(settings.content) || settings.content.length > 0)//contenuto passato per funzione o testo statico
				{
					boxContent = ($.isFunction(settings.content)) ? settings.content() : settings.content;

				}else
				{

					//costruisco il vettore degli href
					//1) vedo se � un array
					//2) vedo se settings.href � un vettore
					//3) vedo se � settato settings.trigger_elemet
					//4) se nulla del precedente allora setto href = null
					index = 0;
					$related = new Array();

					if(typeof settings.href == 'object') //object
					{

            $.each(settings.href,function(i,el){
							var temp = new Array();
              temp['title'] = (el.title) ? el.title : settings.title;
							temp['href'] = el.href;
							$related.push(temp);
							//$related[i-1] =  temp;
						});

					}else if(settings.href.length > 0) //single href
					{
						var temp = new Array();
            temp['title'] = settings.title;
						temp['href'] = settings.href;
						$related.push(temp);

					}else if(typeof settings.trigger_element == 'object') //lanciato da link
					{
            var temp = new Array();
						el =  settings.trigger_element;

						if (el.rel && el.rel !== 'nofollow') {

              var temp_related = $('.jqbox_elem').filter(function () {
							return (this.rel === el.rel);
						});




						//trova a che indice sta l'emento cliccato
						index = temp_related.index(el);
						$.each(temp_related,function(i,el){
							var temp = new Array();
							temp['title'] = (settings.titleGroup && settings.titleGroup.length > 0) ? settings.titleGroup : el.title;
							temp['href'] = el.href;
							$related.push(temp);
						});


						}else
						{
							var temp = new Array();
              temp['title'] = settings.title || el.title;
							temp['href'] = el.href;
							$related.push(temp);
						}
						//trovo gli elementi con attributo rel
						//verifico i related con attr rel
						/*$related = [
										{
											title :
											href :
										}
								   ]*/
					}else
					{
							var temp = new Array();
            temp['title'] = '';
						temp['href'] = null;
						$related.push(temp);

					}
					/*$related = [
									{
										title: 'titolo1',
										href: '../content/ohoopee1.jpg'
									},
									{
										title: 'titolo2',
										href: './ajax_content.html'
									},
									{
										title: 'titolo3',
										href: '../content/ohoopee3.jpg'
									}
								];*/

				}
				/*alert(typeof settings.href);
				if (settings.rel && settings.rel !== 'nofollow') {
						$related = $('.cboxElement').filter(function () {
							var relRelated = $(this).data(colorbox).rel || this.rel;
							return (relRelated === settings.rel);
						});
						//trova a che indice sta l'emento cliccato
						index = $related.index(element);


						// Check direct calls to ColorBox.
						if (index < 0) {
							$related = $related.add(element);
							index = $related.length - 1;
						}
					} else {
						$related = $(element);
						index = 0;
					}
				*/

			},
			launch : function() //richiamata al click dell'elemento in pratica fa il posizionamento e setta le impostazioni iniziali
			{
					if (!open) { //la faccio ogni volta che clicco se non � aperto
						open = TRUE;

						active = TRUE; // Prevents the page-change action from queuing up if the visitor holds down the left or right keys.

						//bookmark = element;

						//bookmark.blur(); // Remove the focus from the calling element.

						// Set Navigation Key Bindings
						$(document).bind("keydown.cbox_close", function (e) {
							if (e.keyCode === 27) {
								e.preventDefault();
								this.close();
							}
						}).bind("keydown.cbox_arrows", function (e) {
							if ($related.length > 1) {
								if (e.keyCode === 37) {
									e.preventDefault();
									$prev.click();
								} else if (e.keyCode === 39) {
									e.preventDefault();
									$next.click();
								}
							}
						});

						if (settings.overlayClose) {
							$overlay.css({"cursor": "pointer"}).one('click', this.close);
						}

						$.event.trigger(cbox_open);
						if (settings.onOpen) {
							settings.onOpen.call(element);
						}


						if(settings.showOverlay)
						{
							$overlay.css({"opacity": settings.opacity}).show();
						}
						// Opens inital empty ColorBox prior to content being loaded.
						settings.w = setSize(settings.initialWidth, 'x');
						settings.h = setSize(settings.initialHeight, 'y');

            obj.position(0);


						if (isIE6) {
							$window.bind('resize.cboxie6 scroll.cboxie6', function () {
								$overlay.css({width: $window.width(), height: $window.height(), top: $window.scrollTop(), left: $window.scrollLeft()});
							}).trigger("scroll.cboxie6");
						}
					}

					$current.add($prev).add($next).add($slideshow).add($title).hide();

					$close.html(settings.close).show();

					this.slideshow();

					//this.load();

					//se fixed aggiungo la classe
					if(!isIE6 && settings.fixed)
					{
						$cbox.addClass('fixed');
					}else
					{
						$cbox.removeClass('fixed');
					}

			},
			load : function() {
				//alert('load');
				active = TRUE;

				$.event.trigger(cbox_load);

				if(!boxContent &&  settings.transition != 'fade'){
          				$empty = $('<div/>').css({width:100, height:100});
          				//obj.resize($empty,'');
        		}
				/* funzione da caricare al load
				if (settings.onLoad) {
					settings.onLoad.call(element);
				}
				*/
				// Evaluate the height based on the optional height and width settings.
				settings.h = settings.height ?
						setSize(settings.height, 'y') - loadedHeight - interfaceHeight :
						settings.innerHeight ?
							setSize(settings.innerHeight, 'y') :
							FALSE;
				settings.w = settings.width ?
						setSize(settings.width, 'x') - loadedWidth - interfaceWidth :
						settings.innerWidth ?
							setSize(settings.innerWidth, 'x') :
							FALSE;

				// Sets the minimum dimensions for use in image scaling
				settings.mw = settings.w;
				settings.mh = settings.h;

				// Re-evaluate the minimum width and height based on maxWidth and maxHeight values.
				// If the width or height exceed the maxWidth or maxHeight, use the maximum values instead.

				//in base al discorso del position fixed o auto setto entrambi o solo la larghezza

				settings.maxWidth = $(window).width() -20;
				settings.maxHeight = $(window).height() -20;
				if(settings.maxWidth){
					settings.mw = setSize(settings.maxWidth, 'x') - loadedWidth - interfaceWidth;
					settings.mw = settings.w && settings.w < settings.mw ? settings.w : settings.mw;
				}
				if(settings.maxHeight){
					settings.mh = setSize(settings.maxHeight, 'y') - loadedHeight - interfaceHeight;
					settings.mh = settings.h && settings.h < settings.mh ? settings.h : settings.mh;
				}



        $loaded.empty();
        //nascondo titolo e altri
        $title.hide();
        $next.hide();
        $prev.hide();
        $current.hide();
        $slideshow.hide();

				$loadingOverlay.show();

				$loadingGraphic.show();


				if(!boxContent) //se non � presente il contenuto allora lo setto
				{
          setTimeout(function(){
             current_content = obj.fetchContent();
          },1000);

				}else
				{
          current_content = boxContent;
					obj.resize(current_content,settings.title);
				}

				//carico il nuovo conenuto


				//chiamo la resize

				//faccio il resto


				/*
				    - ( ) Passaggio di immagini inline come fancybox
				    - ( ) preload immagini,capire quando immagine � caricata
				    - (x) modalit� modal or not //se showOverlay = TRUE allora mostro l'overlay
					- ( ) iframe per select in  caso di ie6 //ricreare il layout html
					- (x) pngfix come tooltip //fatto da css
					- (x) gestire ajax per datatype = json (ok fato sopra con formatResponse e json)

					es:     	$("#manual2").click(function() {
					$.fancybox([
						'http://farm5.static.flickr.com/4044/4286199901_33844563eb.jpg',
						'http://farm3.static.flickr.com/2687/4220681515_cc4f42d6b9.jpg',
						{
							'href'	: 'http://farm5.static.flickr.com/4005/4213562882_851e92f326.jpg',
							'title'	: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'
						}
					], {
						'padding'			: 0,
						'transitionIn'		: 'none',
						'transitionOut'		: 'none',
						'type'              : 'image',
						'changeFade'        : 0
					});

					- (x) aggiungo l'open    (ok vedi boxy)
					- (x) aggiungo il close  (ok vedi boxy)
					- (x) aggiungo l'update  (ok vedi boxy)

			});

					recupero il parametro href,se non � passato tra i parametri allora prendo quello dell'url
					salvo il title
					1) verifico se c� il bodyHandler � specificata
						1.1) se � una funzione allora la eseguo
						1.2) se � contenuto html allora lo mostro
					2) verifico se  � del contenuto href � inline var target_pattern = /^#.+/;
					3) verifico se � un'immagine se si do la possibilit� di effettuare slideshow o scroll
					4) verifico se � un URL deve iniziare con ./ oppure con http
						4.1) se � specifica to iframe = TRUE allora carico l'url in un  iframe
					    4.2) faccio la chiamata ajax
					5) carico il title

					//per aggiornare i contenuti come faccio?
				*/

			},
			fetchContent : function () //setta il content
			{

        //if(!boxContent)
				//{

          element = $related[index]; //dentro related metto l'array dei title e href
          var href = element.href; //recupero l'elemento

          var title = '';
          if(element.title){
             title = element.title; 
          }
          

					var inline_pattern = /^#.+/;
					var target = href.match(inline_pattern);
					if(target && $(target[0]).length > 0) //vedo se esite ed il contenuto � un elemento inline;
					{
						// Inserts an empty placeholder where inline content is being pulled from.
						// An event is bound to put inline content back when ColorBox closes or loads new content.
						/*$('<div id="cboxInlineTemp" />').hide().insertBefore($(target[0])).bind(cbox_load+' '+cbox_cleanup, function(){
							$(this).replaceWith($loaded.children());
						});*/

						content_element = $(target[0],document.body).get(0);
						var temp_content = $(content_element).clone().show();
						obj.resize(temp_content,title);
						//gli passo l'elemento


					} else if (isImage(href))    //il contenuto � un immagine
					{
            img = new Image();
						img.onerror = function() //#MOD
						{
							obj.resize(obj.showError(href),''); //mostro l'errore
						}
						img.onload = function(){

							var percent;
							img.onload = null;
							img.id = 'cboxPhoto';

							$(img).css({margin:'auto', border:'none', display:'block', cssFloat:'left'});

							if(settings.scalePhotos){

								setResize = function(){
									img.height -= img.height * percent;
									img.width -= img.width * percent;
								};

								//alert('resize'); //fa il resize dell'immagine se sono settate altezza massimo o larghezza max
								if(settings.mw && img.width > settings.mw){
									percent = (img.width - settings.mw) / img.width;
									setResize();
								}
								if(settings.mh && img.height > settings.mh){
									percent = (img.height - settings.mh) / img.height;
									setResize();
								}
							}

							//setta l'altezza dell'immagine puo' acnche essere rimosso
							if (settings.h) {
								img.style.marginTop = Math.max(settings.h - img.height,0)/2 + 'px';
							}


							if($related.length > 1){
								$(img).css({cursor:'pointer'}).click(this.next);
							}

							if(isIE){
								img.style.msInterpolationMode='bicubic';
							}

							obj.resize(img,title);
						};
						img.src = href;
					}else
					{
						if(settings.iframe){ //IFRAME
							obj.resize($("<iframe id='cboxIframe'" + (settings.scrolling ? " " : "scrolling='no'") + " name='iframe_"+new Date().getTime()+"' frameborder=0 src='"+href+"' " + (isIE ? "allowtransparency='true'" : '') + " />"));
						}else
						{
							//AJAX
							//#MOD AGGIUNTO	MODIFICATO DA GET AD AJAX
							var target = href.split('?')[0];
							var params = href.split('?')[1];
							$.ajax({
								type: "POST",
								url : target,
								data : params,
								//dataType: (settings.json == TRUE) ? "json" : "text", //MOD
								async: false, //devo aspettare la risposta
								success: function(data) {
									if($.isFunction(settings.formatResponse)) //formatto la risposta ajax
									{
										data = settings.formatResponse(data);
									}

									if(data.length > 0)
									{
										obj.resize($('<div />').appendTo($loadingBay).html(data),title);
									}
								}
								,error:function (xhr){
					              if(xhr.status != 200)
					                {
					                	alert('Network error.Try again.');
					                	return false;
					                	obj.resize(obj.showError(href),'');
					                }
								}
							});
						}

					}

				//}

			},
			resize : function (object,title) {

          if(!open){ return; }

					//object = "<div style='width:800px;height:400px;border:1px solid red;'>ciao</div>";

					var topMargin,
					prev,
					prevSrc,
					next,
					nextSrc,
					photo,
				//	timeout,
					speed = settings.transition==="none" ? 0 : settings.speed;

					$window.unbind(cbox_resize);


					if(!object){
						timeout = setTimeout(function(){ // timer allows IE to render the dimensions before attempting to calculate the height
							var $child = $loaded.wrapInner("<div style='overflow:auto'></div>").children(); // temporary wrapper to get an accurate estimate of just how high the total content should be.
							settings.h = $child.height();
							$loaded.css({height:settings.h});
							$child.replaceWith($child.children()); // ditch the temporary wrapper div used in height calculation

							obj.position(speed);
						}, 1);
						return;
					}


					$loaded.remove();
					$loaded = $('<div id="cboxLoadedContent"/>').html(object);


					function getWidth(){
						settings.w = settings.w || $loaded.width();
						settings.w = settings.mw && settings.mw < settings.w ? settings.mw : settings.w;
						return settings.w;
					}
					function getHeight(){
						settings.h = settings.h || $loaded.height();
						settings.h = settings.mh && settings.mh < settings.h ? settings.mh : settings.h;
						return settings.h;
					}




					$loaded.hide()
					.appendTo($loadingBay)// content has to be appended to the DOM for accurate size calculations.  Appended to an absolutely positioned element, rather than BODY, which avoids an extremely brief display of the vertical scrollbar in Firefox that can occur for a small minority of websites.
					.css({width:getWidth(), overflow:settings.scrolling ? 'auto' : 'hidden'})
					.css({height:getHeight()})// sets the height independently from the width in case the new width influences the value of height.
					.prependTo($content);




					$('#cboxPhoto').css({cssFloat:'none'});// floating the IMG removes the bottom line-height and fixed a problem where IE miscalculates the width of the parent element as 100% of the document width.

					// Hides SELECT elements in IE6 because they would otherwise sit on top of the overlay.
					if (isIE6) {
						$('select:not(#colorbox select)').filter(function(){
							return this.style.visibility !== 'hidden';
						}).css({'visibility':'hidden'}).one(cbox_cleanup, function(){
							this.style.visibility = 'inherit';
						});
					}



					function setPosition (s) {

						obj.position(s, function(){
							if (!open) { return; }

							if (isIE) {
								//This fadeIn helps the bicubic resampling to kick-in.
								if( photo ){$loaded.fadeIn(100);}
								//IE adds a filter when ColorBox fades in and out that can cause problems if the loaded content contains transparent pngs.
								$cbox[0].style.removeAttribute("filter");
							}

							//Waited until the iframe is added to the DOM & it is visible before setting the src.
							//This increases compatability with pages using DOM dependent JavaScript.
							/*if(settings.iframe){
								$loaded.append("<iframe id='cboxIframe'" + (settings.scrolling ? " " : "scrolling='no'") + " name='iframe_"+new Date().getTime()+"' frameborder=0 src='"+settings.href+"' " + (isIE ? "allowtransparency='true'" : '') + " />");
							}*/


							//#mod PRIMA NASCONDO IL LOADER
							$loadingOverlay.hide();
							$loadingGraphic.hide();
              //setTimeout(function(){
                $loaded.show();
              //},150);


							//mostro il titolo
							if(title && title.length > 0)
							{
								$title.show().html(title);
							}


							if ($related.length>1) {
								$current.html(settings.current.replace(/\{current\}/, index+1).replace(/\{total\}/, $related.length)).show();
								$next.html(settings.next).show();
								$prev.html(settings.previous).show();

								if(settings.slideshow){
									$slideshow.show();
								}
							}




							$.event.trigger(cbox_complete);
							if (settings.onComplete) {
								settings.onComplete.call(element);
							}

							if (settings.transition === 'fade'){
								$cbox.fadeTo(speed, 1, function(){
									if(isIE){$cbox[0].style.removeAttribute("filter");}
								});
							}

							$window.bind(cbox_resize, function(){
								obj.position(0);
							});
						});
					}

        $loadingOverlay.hide();
				$loadingGraphic.hide();


              if(settings.transition === 'fade'){
                  $cbox.fadeTo(speed, 0, function(){setPosition(0);})
              }else{
                   setPosition(speed);
              }


      					// Preloads images within a rel group
      					if (settings.preloading && $related.length>1) {
      						prev = index > 0 ? $related[index-1] : $related[$related.length-1];
      						next = index < $related.length-1 ? $related[index+1] : $related[0];
      						nextSrc = next.href;
      						prevSrc = prev.href;

      						if(isImage(nextSrc)){
      							$('<img />').attr('src', nextSrc);
      						}

      						if(isImage(prevSrc)){
      							$('<img />').attr('src', prevSrc);
      						}
      					}








				},

			position : function (speed, loadedCallback) { //aggiorna la posizione del box


				var animate_speed,
				winHeight = $window.height();
				// keeps the top and left positions within the browser's viewport.

				if(settings.fixed)
				{
					var posTop = Math.max(winHeight - settings.h - loadedHeight - interfaceHeight,0)/2;
					var posLeft = Math.max(document.documentElement.clientWidth - settings.w - loadedWidth - interfaceWidth,0)/2;
				}else
				{
					var posTop = Math.max(winHeight - settings.h - loadedHeight - interfaceHeight,0)/2 + $window.scrollTop();
					var posLeft = Math.max(document.documentElement.clientWidth - settings.w - loadedWidth - interfaceWidth,0)/2 + $window.scrollLeft();
				}

				// setting the speed to 0 to reduce the delay between same-sized content.
				animate_speed = ($cbox.width() === settings.w+loadedWidth && $cbox.height() === settings.h+loadedHeight) ? 0 : speed;

				posTop = Math.max(winHeight - settings.h - loadedHeight - interfaceHeight,0)/2;


				// this gives the wrapper plenty of breathing room so it's floated contents can move around smoothly,
				// but it has to be shrank down around the size of div#colorbox when it's done.  If not,
				// it can invoke an obscure IE bug when using iframes.
				$wrap[0].style.width = $wrap[0].style.height = "9999px";

				function modalDimensions (that) {
					// loading overlay size has to be sure that IE6 uses the correct height.
					$topBorder[0].style.width = $bottomBorder[0].style.width = $content[0].style.width = that.style.width;
					$loadingGraphic[0].style.height = $loadingOverlay[0].style.height = $content[0].style.height = $leftBorder[0].style.height = $rightBorder[0].style.height = that.style.height;
				 }


        $cbox.show();

        //lo centro

        /*var win_w = jQuery(window).width();
        var win_h = jQuery(window).height();
        var loadertop =   (win_h -100)/2
        var loaderleft =  (win_w -100)/2
        $cbox.css({width:100, height:100, top: loadertop, left:loaderleft});
        $content[0].style.width = 100;
        $empty = $('<div/>').css({width:100, height:100});
        obj.resize($empty,'');*/


        //setTimeout(function(){
             // return false;

              $cbox.dequeue().animate({width:settings.w+loadedWidth, height:settings.h+loadedHeight, top:posTop, left:posLeft}, {duration: animate_speed,
      					complete: function(){

                  modalDimensions(this);

      						active = FALSE;

      						// shrink the wrapper down to exactly the size of colorbox to avoid a bug in IE's iframe implementation.
      						$wrap[0].style.width = (settings.w +loadedWidth+interfaceWidth) + "px";
      						$wrap[0].style.height = (settings.h +loadedHeight+interfaceHeight) + "px";

      						if (loadedCallback) {loadedCallback();}
      					},
      					step: function(){
      						modalDimensions(this);
      					}
				    });
       // },3000);
			},
			slideshow : function () {

				var stop, timeOut, className = 'cboxSlideshow_';

				$slideshow.bind(cbox_closed, function(){
					$slideshow.unbind();
					clearTimeout(timeOut);
					$cbox.removeClass(className+"off"+" "+className+"on");
				});

				start = function(){

          $slideshow.removeClass('slideshowStart');
					$slideshow.addClass('slideshowStop');

          $slideshow
					.text(settings.slideshowStop)
					.bind(cbox_complete, function(){
						timeOut = setTimeout(function(){obj.next()}, settings.slideshowSpeed);
					})
					.bind(cbox_load, function(){
						clearTimeout(timeOut);
					}).one("click", function(){
						stop();
						$(this).removeClass(hover);
					});
					$cbox.removeClass(className+"off").addClass(className+"on");
				}

				stop = function(){
				  // alert('stop');
          clearTimeout(timeOut);
          $slideshow.removeClass('slideshowStop');
					$slideshow.addClass('slideshowStart');
          $slideshow
					.text(settings.slideshowStart)
					.unbind(cbox_complete+' '+cbox_load)
					.one("click", function(){
						start();

						timeOut = setTimeout(function(){obj.next()}, settings.slideshowSpeed);
						$(this).removeClass(hover);
					});
					$cbox.removeClass(className+"on").addClass(className+"off");
				};

				if(settings.slideshow && $related.length>1){
					if(settings.slideshowAutoStart){
						start();
					} else {
						stop();
					}
				}
			},
			// Note: to use this within an iframe use the following format: parent.$.fn.colorbox.close();
			close : function () {

				$.event.trigger(cbox_cleanup);
				if (settings.onCleanup) {
					settings.onCleanup.call(element);
				}

				open = FALSE;
				$(document).unbind("keydown.cbox_close keydown.cbox_arrows");
				$window.unbind(cbox_resize+' resize.cboxie6 scroll.cboxie6');
				$overlay.css({cursor: 'auto'}).fadeOut('fast');

				$cbox
				.stop(TRUE, FALSE)
        .css({'opacity': 0})
        .show()
        //.fadeIn('fast')
				.fadeOut('fast', function () {
					$('#colorbox iframe').attr('src', 'about:blank');
					$loaded.remove();
					$cbox.css({'opacity': 1});

					/*
					try{
						bookmark.focus();
					} catch (er){
						// do nothing
					}*/

					$.event.trigger(cbox_closed);
					if (settings.onClosed) {
						settings.onClosed.call(element);
					}
				});
			},
			// Navigates to the next page/image in a set.
			next: function()
			{

        if(!active){
					index = index < $related.length-1 ? index+1 : 0;
					obj.load();
				}
			},
			prev: function()
			{
				if(!active){
					index = index > 0 ? index-1 : $related.length-1;
					obj.load();
				}
			},
			close: function()
			{
				$.event.trigger(cbox_cleanup);
				if (settings.onCleanup) {
					settings.onCleanup.call(element);
				}

				open = FALSE;
				$(document).unbind("keydown.cbox_close keydown.cbox_arrows");
				$window.unbind(cbox_resize+' resize.cboxie6 scroll.cboxie6');
				$overlay.css({cursor: 'auto'}).fadeOut('fast');

        $cbox
				.stop(TRUE, FALSE)
        .css({'opacity': 0})
        .show()
				.fadeOut('fast', function () {
					$('#colorbox iframe').attr('src', 'about:blank');
					$loaded.remove();
					$cbox.css({'opacity': 1});

					/*try{
						bookmark.focus();
					} catch (er){
						// do nothing
					}*/

					$.event.trigger(cbox_closed);
					if (settings.onClosed) {
						settings.onClosed.call(element);
					}
				});
			},
			//#MOD funzione aggiunta in caso di errori
			showError : function(href){
					this.resize('<p id="colorbox_error">The requested content from <strong>' + href +'</strong> cannot be loaded.<br />Please try again later.</p>');
			}

		});
		/*
		var inline_pattern = /^#.+/;
		var target = url.match(inline_pattern);
		if($.isFunction(settings.content) OR settings.content.length > 0)//contenuto passato per funzione o testo statico
		{


		}else if($(target[0]).length > 0) //esite ed il contenuto � un elemento inline;
		{


		} else if (isImage(href)){


				img = new Image();
				img.onerror = function() //#MOD
				{
					cboxPublic.showError(href); //mostro l'errore
				}
				img.onload = function(){
					var percent;
					img.onload = null;
					img.id = 'cboxPhoto';

					$(img).css({margin:'auto', border:'none', display:'block', cssFloat:'left'});

					if(settings.scalePhotos){

						setResize = function(){
							img.height -= img.height * percent;
							img.width -= img.width * percent;
						};

						//alert('resize'); //fa il resize dell'immagine se sono settate altezza massimo o larghezza max
						if(settings.mw && img.width > settings.mw){
							percent = (img.width - settings.mw) / img.width;
							setResize();
						}
						if(settings.mh && img.height > settings.mh){
							percent = (img.height - settings.mh) / img.height;
							setResize();
						}
					}

					//setta l'altezza dell'immagine puo' acnche essere rimosso
					if (settings.h) {
						img.style.marginTop = Math.max(settings.h - img.height,0)/2 + 'px';
					}

					resize(img);

					if($related.length > 1){
						$(img).css({cursor:'pointer'}).click(cboxPublic.next);
					}

					if(isIE){
						img.style.msInterpolationMode='bicubic';
					}
				};
				img.src = href;
			} else {

					//#MOD AGGIUNTO	MODIFICATO DA GET AD AJAX
					var target = href.split('?')[0];
					var params = href.split('?')[1];
					$.ajax({
						type: "POST",
						url : target,
						data : params,
						//dataType: (settings.json == true) ? "json" : "text", //MOD
						async: false, //devo aspettare la risposta
						success: function(data) {



							if($.isFunction(settings.formatResponse)) //formatto la risposta ajax
							{
								data = settings.formatResponse(data);
							}

							if(data.length > 0)
							{
								resize($('<div />').appendTo($loadingBay).html(data));
							}
						},
						error:function(){
							cboxPublic.showError(href);
						}
					});
			}
		*/


		if(!$cbox)//launching only the first time
		{
			obj.init();
		}

		obj.process(); //processa la tipologia per settare gli href

		obj.launch(); //fa il setting iniziale nel caso il box sia ancora chiuso

		obj.load(); //carica il contenuto

	}

	// ****************
	// PROTOTYPE FUNCTIONS
	// ****************
	jqbox.prototype = {

		init223: function() //Init function creating the box and the overlay
		{

			// jQuery object generator to save a bit of space
			function $div(id) {
				return $('<div id="cbox' + id + '"/>');
			}

			/*
			<div id="cboxOverlay" style="display: block; cursor: pointer; opacity: 0.9;"></div>
			<div id="colorbox" style="padding-bottom: 42px; padding-right: 42px; display: block; width: 769px; height: 643px; top: 0px; left: 226.5px;" class="fixed">
				<div id="cboxWrapper" style="height: 685px; width: 811px;">
					<div>
						<div id="cboxTopLeft" style="float: left;"></div>
						<div id="cboxTopCenter" style="float: left; width: 769px;"></div>
						<div id="cboxTopRight" style="float: left;"></div>
					</div>
					<div>
						<div id="cboxMiddleLeft" style="float: left; height: 643px;"></div>
						<div id="cboxContent" style="float: left; width: 769px; height: 643px;">
							<div id="cboxLoadedContent" style="display: block; width: 769px; overflow: auto; height: 615px;">
								<img width="769" height="615" src="http://127.0.0.1/colorbox/content/Modifiche.jpg" id="cboxPhoto" style="margin: auto; border: medium none; display: block; float: none; cursor: pointer;">
							</div>
							<div id="cboxLoadingOverlay" class="" style="height: 643px; display: none;"></div>
							<div id="cboxLoadingGraphic" class="" style="height: 643px; display: none;"></div>
							<div id="cboxTitle" class="" style="display: block;">Me and my grandfather on the Ohoopee.</div>
							<div id="cboxCurrent" class="" style="display: block;">image 1 of 4</div>
							<div id="cboxSlideshow" class="" style="display: none;"></div>
							<div id="cboxNext" class="" style="display: block;">next</div>
							<div id="cboxPrevious" class="" style="display: block;">previous</div>
							<div id="cboxClose" class="">close</div>
						</div>
						<div id="cboxMiddleRight" style="float: left; height: 643px;"></div>
					</div>
					<div>
						<div id="cboxBottomLeft" style="float: left;"></div>
						<div id="cboxBottomCenter" style="float: left; width: 769px;"></div>
						<div id="cboxBottomRight" style="float: left;"></div>
					</div>
				</div>
				<div style="position: absolute; top: 0pt; left: 0pt; width: 9999px; height: 0pt;"></div>
			</div>
			*/

			// Create & Append jQuery Objects
			$cbox = $('<div id="colorbox"/>');

			$overlay = $div("Overlay").hide();
			$wrap = $div("Wrapper");
			$content = $div("Content").append(
				$loaded = $div("LoadedContent").css({width: 0, height: 0}),
				$loadingOverlay = $div("LoadingOverlay"),
				$loadingGraphic = $div("LoadingGraphic").html('Loading...'),
				$title = $div("Title"),
				$current = $div("Current"),
				$slideshow = $div("Slideshow"),
				$next = $div("Next"),
				$prev = $div("Previous"),
				$close = $div("Close")
			);
			$wrap.append( // The 3x3 Grid that makes up ColorBox
				$('<div/>').append(
					$div("TopLeft"),
					$topBorder = $div("TopCenter"),
					$div("TopRight")
				),
				$('<div/>').append(
					$leftBorder = $div("MiddleLeft"),
					$content,
					$rightBorder = $div("MiddleRight")
				),
				$('<div/>').append(
					$div("BottomLeft"),
					$bottomBorder = $div("BottomCenter"),
					$div("BottomRight")
				)
			).children().children().css({'float': 'left'});

			//barra appesa al top
			$loadingBay = $("<div style='position:absolute; top:0; left:0; width:9999px; height:0;'/>");

			$('body').prepend($overlay, $cbox.append($wrap, $loadingBay));
			//$('body').prepend($cbox.append($wrap, $loadingBay)); //#MOD potrei decidere di non mostrare l'verlay

			if (isIE) {
				$cbox.addClass('cboxIE');
				if (isIE6) {
					$overlay.css('position', 'absolute');
				}
			}


			// Add rollover event to navigation elements
			$content.children()
			.bind('mouseover mouseout', function(){
				$(this).toggleClass(hover);
			}).addClass(hover);

			// Cache values needed for size calculations
			interfaceHeight = $topBorder.height() + $bottomBorder.height() + $content.outerHeight(TRUE) - $content.height();//Subtraction needed for IE6
			interfaceWidth = $leftBorder.width() + $rightBorder.width() + $content.outerWidth(TRUE) - $content.width();
			loadedHeight = $loaded.outerHeight(TRUE);
			loadedWidth = $loaded.outerWidth(TRUE);

			// Setting padding to remove the need to do size conversions during the animation step.
			$cbox.css({"padding-bottom": interfaceHeight, "padding-right": interfaceWidth}).hide();

			// Setup button & key events.
			$next.click(this.next);
			$prev.click(this.prev);
			$close.click(this.close);

			// Adding the 'hover' class allowed the browser to load the hover-state
			// background graphics.  The class can now can be removed.
			$content.children().removeClass(hover);

			/*$('.cboxElement').live('click', function (e) {
				if (e.button !== 0 && typeof e.button !== 'undefined') {// checks to see if it was a non-left mouse-click.
					return TRUE;
				} else {
					alert('launch');
					launch(this);
					return FALSE;
				}
			});*/
		}

	}



	// ****************
	// EXPOSED FUNCTIONS
	// ****************
	$.jqbox = {
		load: function(content,options)
		{
			new jqbox(content,options);
		},
		close: function()
		{
			var jqbox = $('#colorbox').data('jqbox');
			jqbox.close();
		}
	}





	// ****************
	// HELPER FUNCTIONS
	// ****************

	// Convert % values to pixels
	function setSize(size, dimension) {
		dimension = dimension === 'x' ? $window.width() : $window.height();//document.documentElement.clientWidth : document.documentElement.clientHeight;
		return (typeof size === 'string') ? Math.round((size.match(/%/) ? (dimension / 100) * parseInt(size, 10) : parseInt(size, 10))) : size;
	}

	// Checks an href to see if it is a photo.
	// There is a force photo option (photo: true) for hrefs that cannot be matched by this regex.
	function isImage(url) {
		url = $.isFunction(url) ? url.call(element) : url;
		return  url.match(/\.(gif|png|jpg|jpeg|bmp)(?:\?([^#]*))?(?:#(\.*))?$/i);
	}



	$(jqbox.init);

})(jQuery);
