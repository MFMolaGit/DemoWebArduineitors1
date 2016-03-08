function deleteMessage(url){
	$.ajax({
	    url: url,
	    type: 'DELETE',
	    success: function(result) {
	    	alert(result);
//	        alert('que lo borrrooooo¡¡¡¡');
	    }
	});
}