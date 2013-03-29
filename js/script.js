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
    if (window.sidebar) {
        window.sidebar.addPanel(title, url,"");
    } else if( document.all ) {
        window.external.AddFavorite( url, title);
    } else if( window.opera && window.print ) {
        return true;
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
