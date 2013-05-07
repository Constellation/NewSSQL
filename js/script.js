$(document).on("pagebeforecreate",'[data-role=page]',function(e){
  $.ajaxSetup({cache : true});
  $.getScript('http://platform.twitter.com/widgets.js');
  $.ajaxSetup({cache : false});
});


$(document).on('pageshow', '[data-role=page]', function(e) {
  var src = '//www.facebook.com/plugins/like.php?href=';
  src += encodeURIComponent(location.href);
  src += '&send=false&layout=button_count&width=200&show_faces=true&action=like&colorscheme=light&height=21';
  $('.like-btn').attr('src', src);
});


function addBookmark(title,url) {
	//IE
	if(navigator.userAgent.indexOf("MSIE") > -1){
		window.external.AddFavorite(url, title);
	}
	//Firefox
	else if(navigator.userAgent.indexOf("Firefox") > -1){
		window.sidebar.addPanel(title, url, "");
	}
	//Opera
	else if(navigator.userAgent.indexOf("Opera") > -1){
		document.write('<div style="text-align:center"><a href="'+url+'" rel="sidebar" title="'+title+'">„Éñ„ÉÉ„ÇØ„Éû„Éº„ÇØ„Å´ËøΩÂä†</a></div><br>');
	}
	//Netscape
	else if(navigator.userAgent.indexOf("Netscape") > -1){
		document.write('<div style="text-align:center"><input type="button" value="„Éñ„ÉÉ„ÇØ„Éû„Éº„ÇØ„Å´ËøΩÂä†"');
		document.write(' onclick="window.sidebar.addPanel(\''+title+'\',\''+url+'\',\'\');"></div><br>');
	}
	else{
    	alert("„Åì„ÅÆ„Éñ„É©„Ç¶„Ç∂„Å∏„ÅÆ„ÅäÊ∞ó„Å´ÂÖ•„ÇäËøΩÂä†„Éú„Çø„É≥„ÅØ„ÄÅChrome/SafariÁ≠â„Å´„ÅØÂØæÂøú„Åó„Å¶„Åä„Çä„Åæ„Åõ„Çì„ÄÇ\nChrome/Safari„ÅÆÂ†¥Âêà„ÄÅCtrl„Ç≠„Éº„Å®D„Ç≠„Éº„ÇíÂêåÊôÇ„Å´Êäº„Åó„Å¶„Åè„Å†„Åï„ÅÑ„ÄÇ\n„Åù„ÅÆ‰ªñ„ÅÆÂ†¥Âêà„ÅØ„ÅîËá™Ë∫´„ÅÆ„Éñ„É©„Ç¶„Ç∂„Åã„Çâ„ÅäÊ∞ó„Å´ÂÖ•„Çä„Å∏ËøΩÂä†‰∏ã„Åï„ÅÑ„ÄÇ");
  	}
}

$(document).on('pageshow', '#p-gallery', function(e){
	var currentPage = $(e.target);
	photoSwipeInstance = $("ul.gallery a", e.target).photoSwipe({},  currentPage.attr('id'));
}).on('pagehide', '#p-gallery', function(e){
	var currentPage = $(e.target),
	photoSwipeInstance = window.Code.PhotoSwipe.getInstance(currentPage.attr('id'));
	if (typeof photoSwipeInstance != "undefined" && photoSwipeInstance != null) {
		window.Code.PhotoSwipe.detatch(photoSwipeInstance);
	}
});

$(document).ready(function() {
	$( "[id=tabs]" ).tabs();
});

