//接收一个值
var id;
var url = window.location.search;
if (url.indexOf("?") != -1) {
    id = url.substr(url.indexOf("=") + 1);
    get(id);
}

function get(id) {
    $.ajax({
        type: "GET",
        url: "/getStudentInfo",
        data: {
            _method: "GET",
            "id": id
        },
        success: function (result) {
            document.getElementById("stuId").value = result.id;
            document.getElementById("exampleInputName2").value = result.stuName;
            document.getElementById("exampleInputName3").value = result.stuNumber;
            document.getElementById("exampleInputName4").value = result.stuGender;

            for (var i = 0; i < result.studentJobList.length; i++) {
                document.getElementById("exampleInputName5").value = result.studentJobList[i].stuPositionInfo;
                document.getElementById("stuJobStatus").value = result.studentJobList[i].stuStatus;
            }
            document.getElementById("inputText3").value = result.stuCollege + '学院';
            document.getElementById("inputText4").value = result.stuMajor;

            document.getElementById("exampleInputName6").value = result.stuGrade;
            document.getElementById("exampleInputName7").value = result.stuClass;
            document.getElementById("exampleInputName8").value = result.stuHouseAddress;

            document.getElementById("stuInfo").innerHTML = result.stuRemark;

            document.getElementById("stuPhone").value = result.stuPhone;
            document.getElementById("stuRegistration").value = '入学时间：' + result.stuRegistration;
            console.log(result);
        }
    });
};

//更新
function update(id) {
    $.ajax({
        type: "POST",
        url: "/updateStudent",
        data: {
            _method: "PUT",
            "id": id,
            "stuName": $("#exampleInputName2").val(),
            "stuGender": $("#exampleInputName4").val(),
            "stuJobStatus": $("#stuJobStatus").val(),
            "stuHouseAddress": $("#exampleInputName8").val(),
            "stuPhone": $("#stuPhone").val(),
            "stuRemark": $("#stuInfo").val()
        },
        dataType: "json",
        success: function (result) {
            console.log(result);
            get(id);
        }
    });
};