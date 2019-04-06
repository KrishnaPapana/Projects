
var request = require('request');
var cheerio = require('cheerio');
var URL = require('url-parse');
var http = require('http');
var fs = require('fs');

http.createServer(function(req,res){

var i=1;

fs.writeFile('crawl.html','<html><head><title>Crawler</title><style>body{font-family:arial}#head{background-color:#00ccff;margin-top:-22px;padding:20px;}</style></head>',function(err)
{
	if(err) throw err;
});

fs.appendFile('crawl.html','<body><div id="head"><h1 style="color: red"><center>Web Crawler</center></h1></div><div id="linkhead"><h3>Crawled Links</h3></div><div id="links">',function(err)
	{
		if(err) throw err;
	});
var page="http://www.w3schools.com";
var maxPageVisit=10;
var pagesVisited={};
var numPagesVisited =0;
var pagesToVisit = [];
var url = new URL(page);
var baseURL =url.protocol +"//"+url.hostname;

pagesToVisit.push(page);
crawl();
function crawl(){
	 
	if(numPagesVisited>=maxPageVisit){
		console.log("Reached max limit of pages to visit.");
		fs.appendFile('crawl.html','</div></body></html>',function(err)
{
	if(err) throw err;
});

	fs.readFile('crawl.html',function(err,data)
  {
    res.write(data);
    res.end();
    return;
  });
		
		
	}
	var nextPage = pagesToVisit.pop();
	if(nextPage in pagesVisited){
		crawl();

	}
	else{
		visitPage(nextPage,crawl);
	}
}
function visitPage(url , callback){
	pagesVisited[url]=true;
	numPagesVisited++;

console.log(url);
fs.appendFile('crawl.html','<p>'+i+'. '+'<a href="'+url+'">'+url+'</a></p>',function(err)
{
	if(err) throw err;
});

i++;
request(url,function(error, response,body)
{
	if(error){
		console.log("Error : " + error);
		
	}
	
	if(response.statusCode !== 200){
		callback();
	    return;
	}
	var $ = cheerio.load(body);

		collectInternalLinks($);
		callback();
});
}

function searchWord($, word) {
  var bodyText = $('html > body').text().toLowerCase();
  return(bodyText.indexOf(word.toLowerCase()) !== -1);
}

function collectInternalLinks($) {
    var relativeLinks = $("a[href^='/']");

    relativeLinks.each(function() {
       pagesToVisit.push(baseURL + $(this).attr('href'));
    });

}

}).listen(8081);


