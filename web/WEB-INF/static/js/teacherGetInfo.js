//接收一个值
var id;
var url = window.location.search;
if (url.indexOf("?") != -1) {
    id = url.substr(url.indexOf("=") + 1);
    getInfo(id);
}

//获取信息
function getInfo(id) {
    $.ajax({
        url: "/getTeacherInfo/" + id + "",
        success: function (result) {
            document.getElementById("teaId").value = result.id;
            document.getElementById("imgURL").src = result.teaImgUrl;

            document.getElementById("exampleInputName2").value = result.teaName;
            document.getElementById("exampleInputName3").value = result.teaNumber;
            document.getElementById("exampleInputName4").value = result.teaGender;

            document.getElementById("exampleInputName5").value = result.teaPassword;

            document.getElementById("inputText3").value = result.teaCollege + '学院';
            document.getElementById("inputText4").value = result.teaMajor;

            document.getElementById("exampleInputName7").value = result.teaSubjects;

            document.getElementById("exampleInputName8").value = result.teaWork;

            document.getElementById("teaInfo").innerHTML = result.teaInfo;

            document.getElementById("teaPhone").value = result.teaPhone;
            document.getElementById("teaRegistration").value = result.teaRegistration;
            console.log(result);
            //查询所有职位信息,传入当前职位
            getTeaJob(result.teacherJob.teaStatus, result.teacherJob.teaPositionInfo);
        }
    });
};

//查询所有职位信息，连带查询,status表示当前职位
function getTeaJob(teaSta, status) {
    $.ajax({
        type: "GET",
        url: "/getTea",
        success: function (result) {
            var str = "";
            console.log(result);
            //遍历
            str += "<option>" + teaSta + ":" + status + "</option>";
            for (var i = 0; i < result.length; i++) {
                //教师职位集合
                str += "<option>" + result[i].teaStatus + ":" + result[i].teaPositionInfo + "</option>";
                document.getElementById("exampleInputName6").innerHTML = str;
            }
        }
    });
};
//修改信息
//更新
function updateTea(id) {
    var jobStatus = document.getElementById("exampleInputName6").value;
    var teaSta = jobStatus.substr(0, 1);
    $.ajax({
        type: "POST",
        url: "/updateTeacher",
        data: {
            _method: "PUT",
            "id": id,
            "teaName": $("#exampleInputName2").val(),
            "teaPassword": $("#exampleInputName5").val(),
            "teaJobStatus": teaSta,
            "teaSubjects": $("#exampleInputName7").val(),
            "teaPhone": $("#teaPhone").val(),
            "teaWork": $("#exampleInputName8").val(),
            "teaInfo": $("#teaInfo").val(),
        },
        dataType: "json",
        success: function (result) {
        }
    });
};