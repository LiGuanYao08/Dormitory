$.ajax({
    url: "/getStudentInfoList",
    success: function (result) {

        var str = "";
        var tBody = document.getElementById("tbody");
        for (var i = 0; i < result.length; i++) {
            str += "<tr>" +
                "<td>" + result[i].stuNumber + "</td>" +
                "<td>" + result[i].stuName + "</td>" +
                "<td>" + result[i].stuGender + "</td>" +
                "<td>" + result[i].stuClass + "</td>";
            for (var j = 0; j < result[i].studentJobList.length; j++) {
                console.log(result[i].studentJobList[j].stuPositionInfo);
                str = str + "<td>" + result[i].studentJobList[j].stuPositionInfo + "</td>";
            }
            str = str + "<td>" + result[i].stuPhone + "</td>" +
                "<td>" +
                "<button type='button' class='btn btn-xs btn-info' onclick='get(" + result[i].id + ")'>查看</button>" +
                "<button type='button' class='btn btn-xs btn-danger' onclick='del(" + result[i].id + ")'>删除</button>" +
                "</tr>";
        }
        tBody.innerHTML = str;
    }
});

//搜索
function d() {
    if ($("#dim").val() == "") {
        alert("请先输入关键字再搜索");
    } else {
        $.ajax({
            url: "getDimStudentList/" + $("#dim").val() + "",
            success: function (result) {
                var str = "";
                var tBody = document.getElementById("tbody");
                for (var i = 0; i < result.length; i++) {
                    str += "<tr>" +
                        "<td>" + result[i].stuNumber + "</td>" +
                        "<td>" + result[i].stuName + "</td>" +
                        "<td>" + result[i].stuGender + "</td>" +
                        "<td>" + result[i].stuClass + "</td>";
                    for (var j = 0; j < result[i].studentJobList.length; j++) {
                        console.log(result[i].studentJobList[j].stuPositionInfo);
                        str = str + "<td>" + result[i].studentJobList[j].stuPositionInfo + "</td>";
                    }
                    str = str + "<td>" + result[i].stuPhone + "</td>" +
                        "<td>" +
                        "<button type='button' class='btn btn-xs btn-info' onclick='get(" + result[i].id + ")'>查看</button>" +
                        "<button type='button' class='btn btn-xs btn-danger' onclick='del(" + result[i].id + ")'>删除</button>" +
                        "</tr>";
                }
                tBody.innerHTML = str;
            }
        });
    }
};

//删除
function del(id) {
    $.ajax({
        type: "POST",
        url: "/deleteStudent",
        data: {
            _method: "DELETE",
            "id": id
        },
        success: function (result) {
            console.log("删除成功");
            //删除刷新当前页面
            window.location.href = "/studentList.jsp";
        }
    });
};

//查看跳转
function get(id) {
    window.location.href = "/studentInfo.jsp?id=" + id;
}

//添加学生
function addStudent() {
    window.location.href = "/studentAdd.jsp";
}