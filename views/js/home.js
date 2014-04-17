'use strict';

// var Main = (function($) {

// 	function methodName() {
// 		console.log("22");
// 	}

// 	return {
// 		methodName:methodName
// 	};

// 	return Main;

// }(jQuery));

var init = {
	mode: "normal",
	searchEngine: "",
	searchPhrase: ""
};

var WeatherModule = (function() {
	'use strict';

	function weatherDisplay() {
		$.simpleWeather({
			location: 'Atlanta, GA',
			woeid: '',
			unit: 'f',
			success: function(weather) {
			var html = '<h2><i class="icon-'+weather.code+'"></i> '+weather.temp+'&deg;'+weather.units.temp+'</h2>';
			html += '<ul><li>'+weather.city+', '+weather.region+'</li>';
			html += '<li class="currently">'+weather.currently+'</li>';
			html += '<li>'+weather.wind.direction+' '+weather.wind.speed+' '+weather.units.speed+'</li></ul>';
				  
			$("#weather").html(html);
			$("#weather").addClass("animated flipInX");
			},
			error: function(error) {
				$("#weather").html('<p>'+error+'</p>');
			}
		});
	} 

	return {
		weatherDisplay:weatherDisplay
	};

}());

// This module provides functionality 
var ConversationModerator = (function (win, doc, $, wea) {

	var chattingwindow = $("#chatting-window");

	win.setTimeout(function() {
		var chatContent="Hello, this is Billy, How are you today, sir?";
		chattingwindow.append('<p><span class="chat-bot-left">'+chatContent+'</span></p>');
	},2000);

	function userPostMessage(content, inputBar) {
		if (content.trim() && init.mode == "normal") {
			chattingwindow.append('<p class="text-right"><span class="user-chat-right">'+content+'</span></p>');
			inputBar.val("");
			// content parsing starts here
			// in real case, it should send Ajax to server and parse it
			if (content.indexOf("weather") >= 0) {
				$("#welcomeFiller").addClass('animated fadeOut');
				win.setTimeout(function() {
                $("#welcomeFiller").addClass('element-invisible');
                wea.weatherDisplay();
				}, 500);
			}
			//how are you?
			if (content.indexOf("well") >= 0) {
				var chatContent = "How may I be of your service today?";
				win.setTimeout(function() {
					chattingwindow.append('<p><span class="chat-bot-left">'+chatContent+'</span></p>');
				}, 1000);
			}
		}
		if (content.trim() && init.mode == "search") {
			$(".weather-module").addClass('fadeOut');
			$("#welcomeFiller").addClass('animated fadeOut');
			win.setTimeout(function() {
			  $("#welcomeFiller").addClass('element-invisible');
              $(".weather-module").addClass('element-invisible');
              $("#weather").addClass('element-invisible');
			}, 500);
			// window.location.replace("http://www.google.com/#q="+content);
			$("#searchFrame").attr("src", "http://www.bing.com/?q="+content);
		}
	}

	return {
		 userPost:userPostMessage
	};

}(window, document, jQuery, WeatherModule));


// This module spies on every action of the input bar
var InputSpy = (function (win, doc, $, con) {

	var inputBar = $("#input-area input");	
	inputBar.keydown(function (e) {
		switch (e.keyCode) {
			case 9: //tab
				e.preventDefault();
	            modeDetermine(e.target.value);
	            break;
	         case 13: // enter
	            e.preventDefault();
                con.userPost(e.target.value, inputBar);
                break;
		}
	});

	function modeDetermine(modeString) {
		var inputModeArea = $("#input-area span");
		var modeString = modeString.toLowerCase();
		switch (modeString) {
			case "search": //search mode
				inputModeArea.replaceWith('<span class="prefix mode-green animated flipInX">Search Mode: </span>');
				inputBar.val("").attr('placeholder','Start enhanced searching...');
				init.mode = "search";
				break;
			case "normal": //normal mode
				inputModeArea.replaceWith('<span class="prefix animated flipInX">Normal Mode: </span>');
				inputBar.val("").attr('placeholder','Start your conversation...');
				init.mode = "normal";
				break;
			case "edit": //edit mode
				inputModeArea.replaceWith('<span class="prefix mode-maroon animated flipInX">Edit Mode: </span>');
				inputBar.val("").attr('placeholder','Start editing your space...');
				init.mode = "edit";
				break;
		}
	}

	return {
		// methodName:methodName
	};

}(window, document, jQuery, ConversationModerator));





