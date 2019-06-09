window.onload = function (){
    function GetUrlParam(paraName) {
        var url = document.location.toString();
        var arrObj = url.split("?");
    
        if (arrObj.length > 1) {
            var arrPara = arrObj[1].split("&");
            var arr;
    
            for (var i = 0; i < arrPara.length; i++) {
                arr = arrPara[i].split("=");
    
                if (arr != null && arr[0] == paraName) {
                    return arr[1];
                }
            }
            return "";
        } else {
            return "";
        }
    }
    
    // $.ajax({
    //     type: "POST",
    //     url: "/Wireless/Wireless/AttendMeetingServlet",
    //     data: {'usernum':GetUrlParam('usernum')},
    //     async: false,
    //     error: function (request) {
    //         alert("error");
    //     },
    //     success: function (data) {
    //         var parsedJson = jQuery.parseJSON(data); 
    //         alert(parsedJson.name);
    //     }
    // });
    

    $.getJSON("/Wireless/Wireless/AttendMeetingServlet", {'usernum':GetUrlParam('usernum')},function(json){
        alert("JSON Data: " + json[1].id);

        $(".school-timetable > ul").append("<li>"+
        "<img class=\"img-circle round_small\" src=\""+json[1].userImg+"\" alt=\"\">"+ 
        "<br><span>"+json[1].userName+"</span>"+
        "</li>");
        
      });

}