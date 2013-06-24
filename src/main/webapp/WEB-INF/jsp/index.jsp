<%--
  Created by IntelliJ IDEA.
  User: sn1
  Date: 4/24/13
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<script type="text/javascript">
    function callSameDomain(){
        var xmlhttpreq;
        if (window.XMLHttpRequest)
        {
            xmlhttpreq=new XMLHttpRequest();
        }
        else{
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttpreq.onreadystatechange=function(){
            if (xmlhttpreq.readyState==4 && xmlhttpreq.status==200)
            {
                document.getElementById("first").innerHTML=xmlhttpreq.responseText;
            }
        }
        xmlhttpreq.open("GET","test/get",true);
        xmlhttpreq.send();
    }

    function callCrossDomain(){
        var xmlhttpreq1;
        if (window.XMLHttpRequest)
        {
            xmlhttpreq1=new XMLHttpRequest();
        }
        else{
            xmlhttpreq1=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttpreq1.onreadystatechange=function(){
            if (xmlhttpreq1.readyState==4 && xmlhttpreq1.status==200)
            {
                alert("inside block");

                document.getElementById("second").innerHTML=xmlhttpreq1.responseText;
            }
        }
        xmlhttpreq1.open("POST","http://localhost:8082/so/test2/get",true);
        xmlhttpreq1.send();
    }
</script>

<body>
<div id="first"> <h2>before calling same domain</h2> </div>
<div id="second"> <h2>before calling cross domain</h2> </div>

<button type="button" onclick="callSameDomain()" >Call internal</button>
<button type="button" onclick="callCrossDomain()" >Call cross domain</button>

</body>
</html>