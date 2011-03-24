function createRequestObject(){
 var tmpXmlHttpObject;

    if (window.XMLHttpRequest) {
        tmpXmlHttpObject = new XMLHttpRequest();

    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return tmpXmlHttpObject;

}
var http = createRequestObject();

function login() {
    var user = document.getElementById("user");
    var pswd = document.getElementById("pswd");
    var url = "Apply?user=" + user.value + "&pswd=" + pswd.value;
    http.open("GET",url,true);
    http.onreadystatechange = handleServerResponse;
    http.send(null);
}

function handleServerResponse() {
   if (http.readyState == 4) {
     if(http.status == 200) {
        link = document.getElementById("apply");
        save = document.getElementById("save");
        link.innerHTML = "Apply";
        link.setAttribute("class","");
        link.setAttribute("href","save.jsp");
        link.setAttribute("style","display:none")
        save.setAttribute("style","display:inline")
        document.getElementById("welcome").innerHTML = "Welcome " + http.responseText;
     }
     else {
        alert("Error during AJAX call. Please try again");
     }
   }
}