$(document).ready(function(){
	window.onload = function()
	{
		var $li = $('#tab li');
		var $ul = $('#content ul');
					
		$li.mouseover(function(){
			var $this = $(this);
			var $t = $this.index();
			$li.removeClass();
			$this.addClass('current');
			$ul.css('display','none');
			$ul.eq($t).css('display','block');
		})
	}
});
