var voteurl = 'http://www.xtremetop100.com/in.php?site=1132512425';
var votesite = '';
var continent = '';
function ajaxpost(url,poststr,div) {
	$.ajax({
		type:"POST",
		url:url,
		data:poststr,
		cache:false,
		success:function(msg){
			//document.getElementById(div).innerHTML=msg;
			alert(msg);
		}
	});
}

//Creates a cookie - From http://www.quirksmode.org/
function createCookie(name,value,mins) {
	if (mins) {
		var date = new Date();
		date.setTime(date.getTime()+(mins*60*1000));
		var expires = "; expires="+date;
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}

//Reads a cookie's value - From http://www.quirksmode.org/
function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

//Removes a cookie - From http://www.quirksmode.org/
function eraseCookie(name) {
	createCookie(name,"",-1);
}

function checkVote() {

	var lastvoted = null;
	var top100arena = null;
	var mmorpgtoplist = null;
	var topofgames = null;

	lastvoted = readCookie('ghlastvote');

	if (lastvoted == null || lastvoted == undefined) {
		top100arena = readCookie('ghtop100arena');
		mmorpgtoplist = readCookie('ghmmorpgtoplist');
		topofgames = readCookie('ghtopofgames');

		 if (mmorpgtoplist == null) {			//mmorpgtoplist
			mmorpgtoplistF();				//mmorpgtoplistF
		} else if (top100arena == null) {				//top100arena
			top100areanaF();				//top100areanaF
		} else if (topofgames == null) {
			topofgamesF();
		}

		var disptype = (navigator.appName.indexOf('Microsoft') != -1 ? 'block' : 'table');

		if (document.getElementById)
			document.getElementById('votebg').style.display = disptype;
		else
			document.all('votebg').style.display = disptype;
	} else {

		document.getElementById('votebg').style.display = 'none';
		loadLocalClient();
	}
}
function showVote() {
	if(readCookie('ghiff')==null) {
		document.getElementById('trans').style.display = 'block';
		document.getElementById('popup').style.display = 'block';
		document.getElementById('popup').innerHTML='Earn $5 million for every FaceBook friend you invite to play GodzHell<br /><form id="iffform" name="iffform" style="border-style:solid;border-width:2px;">Player Name:<input type="text" id="iffusername" name="iffusername" /><br /><a href="javascript:void(0)" onclick="iff();">Invite friends</a></form><br /><a href="javascript:void(0)" onclick="dontiff();">or I just want to play</a>';
	} else {
		dontiff()
	}
}
function dontiff() {
	document.getElementById('popup').style.display = 'none';
	document.getElementById('trans').style.display = 'none';
	loadClient();
	window.open('http://www.godzhell.com/novote.htm','','width=900,height=600,menubar=yes,status=yes,scrollbars=yes,resizable=yes');
}
function loadClient() {
	document.getElementById('client').innerHTML = '<div valign="top"><applet class="client" valign="top" code="client.class" name="GodzHell.com" width="765" height="503" archive="http://godzhell.webatu.com/clients/current.jar" id="GodzHell.com"><param name="java_arguments" value="-client"><param name="java_arguments" value="-Xmx512m"><param name="separate_jvm" value="true"><PARAM NAME="image" VALUE="images/ghloading.html"><PARAM name="location" value="na"></applet></div>';
}
function iff() {
	var un=document.iffform.elements['iffusername'].value;
	if(un=='' || un=='undef' || un==null) {
		alert('Please enter your player name');
		return;
	}
	FB.ui({
			method: 'apprequests',
			message: 'Join me on GodzHell.com and battle to rule the world!!!',
			title: 'Send your friends an application request'
		},function (response) {
			if(response && response.request_ids) {
				var requestsize=response.request_ids.length;
				dontiff();
				ajaxpost('makeapprequest.html','requestsize='+requestsize+'&un='+un,'hidden');
				createCookie('ghiff', (new Date()).getTime(), 10080);
			}
	});
}
function goVote() {
	var currentTimeMillis = (new Date()).getTime();

	var top100arena = null;
	var mmorpgtoplist = null;
	var topofgames = null;
	top100arena = readCookie('ghtop100arena');
	mmorpgtoplist = readCookie('ghmmorpgtoplist');
	topofgames = readCookie('ghtopofgames');

	if(mmorpgtoplist == null) { //ghmmorpgtoplist //ghtop100arena
		createCookie('ghmmorpgtoplist', currentTimeMillis, 720);
	} else if(top100arena == null) {
		createCookie('ghtop100arena', currentTimeMillis, 1440);
	} else if(topofgames == null) {
		createCookie('ghtopofgames', currentTimeMillis, 720);
		createCookie('ghlastvote', currentTimeMillis, 480);
	}

	if (document.getElementById)
		document.getElementById('votebg').style.display = 'none';
	else
		document.all('votebg').style.display = 'none';
	loadLocalClient();
}
function dontVote() {
	if (document.getElementById)
		document.getElementById('votebg').style.display = 'none';
	else
		document.all('votebg').style.display = 'none';


loadLocalClient();
	launchAd();
}

function contact() {
	var disptype = (navigator.appName.indexOf('Microsoft') != -1 ? 'block' : 'table');
	document.getElementById('votebg').style.display = disptype;
}

function top100areanaF() {

                var top100areanaLink = 'Receive $100,000gh for voting !<br /> Enter you player name below and <br /> click the vote image.<br /><form><input type="text" name="usernamev" id="usernamev" size="25" /><br /><img src="http://www.topmmolist.com/images/topmmolist.gif" title="Click here to vote" alt="Click here to vote" width="88" height="43" border="0" onclick="vi(document.getElementById(\'myform\'));" /></form><br />You can get the $100,00gh<br />once evey day.<br />So keep voting everyday';

                //var top100areanaLink = '<a onclick="goVote();" href="http://runescape.top100arena.com/in.asp?id=23574"  target="_blank"><img width="300" height="335" src="http://clients.godzhell.com/vote/clear.gif"/></a>';
                //var top100areanaLink = '<a onclick="goVote();" href="http://runescape.top100arena.com/in.asp?id=48966"  target="_blank"><img width="300" height="335" src="http://clients.godzhell.com/vote/clear.gif"/></a>';
                //var top100areanaLink = '<a href="http://runescape.top100arena.com/" title="rs servers" onclick="goVote();" target="_blank"><img src="http://www.top100arena.com/hit.asp?id=34937&c=RuneScape&t=2" title="rs servers" alt="rs servers" width="88" height="56" border="0"><br />Click on the above logo to vote</a>';

	document.getElementById('votelink').innerHTML = top100areanaLink; //50904 //
}

function mmorpgtoplistF() {

	var mmorpgtoplistLink = '<a onclick="goVote();" href="http://www.mmorpgtoplist.com/in.php?site=14858"  target="_blank">Click here to vote<br /><img src="../www.godzhell.com/images/mmorpgtoplist.jpg" /></a><br /><br /><br /><br /><br />';
	document.getElementById('votelink').innerHTML = mmorpgtoplistLink; //gh=14858 ts=26207
}

function topofgamesF() {
	var topofgamesLink = '<a onclick="goVote();" href="http://www.mmorpgtoplist.com/in.php?site=14858"  target="_blank">Click here to vote</a>';
	document.getElementById('votelink').innerHTML = topofgamesLink;
}

function loadLocalClient() {

	document.getElementById("client").innerHTML = '<div valign="top"><applet class="client" valign="top" code="client.class" name="GodzHell.com" width="765" height="503" archive="http://godzhell.webatu.com/clients/current.jar" id="GodzHell.com"><param name="java_arguments" value="-client"><param name="java_arguments" value="-Xmx512m"><PARAM name="location" value="na"></applet></div>';
}

function launchAd() {

	window.open('http://www.godzhell.com/novote.htm','','width=900,height=600,menubar=yes,status=yes,scrollbars=yes,resizable=yes');
}

function loadPlayNow() {

	document.getElementById("client").innerHTML = '<img src="http://www.godzhell.com/images/playnowNA.gif" width="765" height="503" onclick="checkVote();" /></a>';
}

function vi(obj) {

                var username = encodeURI(document.getElementById("usernamev").value);
   	username=username.replace(/%20/g,"^");
	var voteurl = 'http://runescape.top100arena.com/in.asp?id=23574&amp;incentive=';     //23574 //50904 //'http://runescape.top100arena.com/in.asp?id=23574&incentive='
	window.open(voteurl+username);                                                    //'http://www.topmmolist.com/ghvote.php?incentive='
                goVote();

}


