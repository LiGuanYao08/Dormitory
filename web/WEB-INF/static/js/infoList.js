//查询
$.ajax({
    url: "/getInfo",
    success: function (result) {
        var str1 = "";
        var str2 = "";
        var str3 = "";
        console.log(result);
        for (var i = 0; i < result.length; i++) {
            if (result[i].infoStatus == 0) {
                str1 += "<div class='panel-body'>" + result[i].message + "</div>" + "<a onclick='deleteInfo(" + result[i].id + ")'>" + "删除" + "</a>";
                document.getElementById("collapseOne").innerHTML = str1;
            } else if (result[i].infoStatus == 1) {
                str2 += "<div class='panel-body'>" + result[i].message + "</div>" + "<a onclick='deleteInfo(" + result[i].id + ")'>" + "删除" + "</a>";
                document.getElementById("collapseTwo").innerHTML = str2;
            } else if (result[i].infoStatus == 2) {
                str3 += "<div class='panel-body'>" + result[i].message + "</div>" + "<a onclick='deleteInfo(" + result[i].id + ")'>" + "删除" + "</a>";
                document.getElementById("collapseThree").innerHTML = str3;
            }
        }
    }
});

//删除
function deleteInfo(id) {
    $.ajax({
        type: "POST",
        url: "/deleteInfo",
        data: {
            _method: "DELETE",
            "id": id
        },
        success: function (result) {
            console.log("删除成功");
            //删除刷新当前页面
            window.location.href = "/infoList.jsp";
        }

    });
}

//新增设置,跳转页面
function addInfo() {
    window.location.href = "/infoAdd.jsp";
}