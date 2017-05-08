/**
 * AdminLTE Demo Menu
 * ------------------
 * You should not use this file in production.
 * This file is for demo purposes only.
 */
$(function () {
	
	"use strict";
	
	var ajax = new XMLHttpRequest();
	
	ajax.open("GET", "../service/getuniqueusers", true);
	ajax.onload = function() {
		var list = JSON.parse(ajax.responseText).map(function(i) { return i.userName; });	  	
		new Awesomplete(document.querySelector("#userid"),{ list: list });
	};
	ajax.send();
	
	var ajax2 = new XMLHttpRequest();
	
	ajax2.open("GET", "https://restcountries.eu/rest/v1/lang/fr", true);
	ajax2.onload = function() {
		var list = JSON.parse(ajax.responseText).map(function(i) { return i.name; });	  	
		new Awesomplete(document.querySelector("#loannumber"),{ list: list });
	};
	ajax2.send();

	var i = 1;
	
	function testAnim(x) {
	    $('#dtbox1').addClass(x + ' animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
	    	debugger;
	    	//$(this).removeClass(x + ' animated');
	    	$(this).removeClass(x);
	    });
	  };
	
	$( "#filter" ).click(function() {
		  
		// clone and append before running another test
		var newDtbox = $("#dtbox1").clone(); 
		//$("#dtbox1").clone().appendTo("#dtdiv");
		//$("#dtbox1").clone().attr("id", "newid" + i).appendTo("#dtdiv");
		//$("#dtbox1").clone().attr("id", "newid" + i).hide().appendTo("#dtdiv").show('slow');
		//$("#dtbox1").clone().attr("id", "newid" + i).hide().insertAfter("#dtbox1").slideDown('slow');
		$("#dtbox1").clone().attr("id", "newid" + i).insertAfter("#dtbox1");		
		
		$("#newid" + i + " > div > h3")[0].outerText = "Search History - " + $("#newid" + i + " > div > h3")[0].outerText;
		// remove hidden class from action buttons
		$("#newid" + i + " > div > div").removeClass("hide");
		$("#newid" + i).addClass("fadeInDown");
		debugger;
		
		/*
		var x = 'fadeInRight';
		$('#dtbox1').addClass(x + ' animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
			$(this).removeClass();
		});
		*/
		/*
		$("#dtbox1").addClass("fadeInRight" + " animated").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
							debugger;
							$(this).removeClass('fadeInRight');
		});
		*/
		var x = 'fadeInRight';
		testAnim(x);
		
		
		//$("#dtbox1").block({
		 //   message: '<img src="http://www.competencylibrary.com/Content/Images/ajax-loader.gif" />',
		 //   css: {
		 //       border:     'none',
		 //       backgroundColor:'transparent'
		 //   }
		//});
		
		//$("#dtbox1").block({ message: '<img src="dist/img/loading.gif" />'});
		
		//$("#dtbox1").block({ message: '<img src="dist/img/busy.gif" />' ,
		//	css: { width: '4%', border:'0px solid #FFFFFF',cursor:'wait',backgroundColor:'#FFFFFF'},
		//	  overlayCSS:  { backgroundColor: '#FFFFFF',opacity:0.0,cursor:'wait'} 
		//	}); 
		
		
		
		setTimeout(function(){$("#dtbox1").unblock(); }, 3000);
		
		//$(newDtbox).attr("id", "newid");
		//$("#newid > div > h3")[0].outerText = "new title";
		//$(newDtbox).appendTo("#dtdiv");
		
		  var loannum = $('#loannumber').val();
		  var userid = $('#userid').val();
		  var searchUrlBuilder = '../docview/search/';
		  //var searchUrlBuilder = '../docview/search/findByLoanNumber?loannumber=1';
			if(loannum=='' && userid==''){	
				searchUrlBuilder = '../docview'			
		  }else if(loannum==''){
			  searchUrlBuilder = searchUrlBuilder + 'findByUserName?name=' + userid;
		  } else if(userid==''){
			  searchUrlBuilder = searchUrlBuilder + 'findByLoanNumber?loannumber=' + loannum;
		  } else {
			  searchUrlBuilder = searchUrlBuilder + 'findByUserNameAndLoanNumber?loannumber=' + loannum + '&name=' + userid;
		  }
		  
		  var tb = $('#example2').DataTable();
		  //tb.ajax.url( '../docview/search/findByLoanNumber?loannumber=1' ).load(function(json){
		  tb.ajax.url( searchUrlBuilder ).load(function(json){
			  
			  return json._embedded.docview;
		  });
		});
	  
    $("#example1").DataTable();
    $('#example2').DataTable( {
        "ajax": {
            "url": "../docview/search/findByLoanNumber?loannumber=50",
            "dataSrc": function ( json ) {
                //debugger;
                return json._embedded.docview;
              }
        },
        "columns": [
        	{ "data": "userName" },
        	{ "data": "loanNumber" },
            { "data": "documentType" },
            { "data": "documentCreatedDate" },
            { "data": "mortracStatus" },
            { "data": "uwStatus" },
            { "data": "documentCreatedDate" }
        ]
    } );
  });
