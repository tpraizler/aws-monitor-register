$(document).ready(function()
{
    $("#registerBtn").click(function(){

        var _username =         $("#username").val();
        var _phone =            $("#phone").val();
        var _secretAccessKey =  $("#secretAccessKey").val();
        var _accessKey =        $("#accessKey").val();

        $.ajax({
            type: "GET",
            url: 'http://localhost:8082/monitor-register/register/info',
            data: { "name"              : _username,
                    "phoneNumber"       : _phone,
                    "accessKey"         : _accessKey,
                    "secretAccessKey"   : _secretAccessKey
                    },
            success: function () {

                alert("Success!");
            },
            fail:function()
            {
                alert("Request Failed!");
            },
            dataType: "json"
        });
    });

});