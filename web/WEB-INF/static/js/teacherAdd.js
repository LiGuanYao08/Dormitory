//加载信息栏
$.ajax({
    type: "GET",
    url: "/getInfo",
    success: function (result) {
        var str1 = "";
        var str2 = "";
//            var str3 ="";
        console.log(result);
        //执行方法
        tea();
        //遍历
        for (var i = 0; i < result.length; i++) {
            if (result[i].infoStatus == 0) {
                //学院集合
                str1 += "<option>" + result[i].message + "</option>";
                document.getElementById("teaCollege").innerHTML = str1;
            } else if (result[i].infoStatus == 1) {
                //专业集合
                str2 += "<option>" + result[i].message + "</option>";
                document.getElementById("teaMajor").innerHTML = str2;
            }
//                else if(result[i].infoStatus==2){
//                    //年级集合
//                    str3 +="<option>"+result[i].message+"</option>";
//                    document.getElementById("stuGrade").innerHTML=str3;
//                }
        }
    }
});

//加载教师职位信息
function tea() {
    $.ajax({
        type: "GET",
        url: "/getTea",
        success: function (result) {
            var str4 = "";
            console.log(result);
            //遍历
            for (var i = 0; i < result.length; i++) {
                //学生职位集合
                str4 += "<option>" + result[i].teaStatus + "：" + result[i].teaPositionInfo + "</option>";
                document.getElementById("teaJobStatus").innerHTML = str4;
            }
        }
    });
};

//添加教师
function addTeacher() {
    //截取状态码
    var teaJobStatus = document.getElementById("teaJobStatus").value;
    var teaSta = teaJobStatus.substr(0, 1);
    var fileData = document.getElementById("browerfile").files[0];
    //获取当前时间
    var myDate = new Date;
    //当前年 月 日
    var myTime = myDate.getFullYear() + "-" + myDate.getMonth() + "-" + myDate.getDate();
    var formData = new FormData();
    formData.append("file", fileData);
    formData.append("teaName", $("#teaName").val());
    formData.append("teaGender", $("#teaGender").val());
    formData.append("teaNumber", $("#teaNumber").val());
    formData.append("teaPassword", $("#teaPassword").val());
    formData.append("teaCollege", $("#teaCollege").val());
    formData.append("teaMajor", $("#teaMajor").val());
    formData.append("teaJobStatus", teaSta);
    formData.append("teaSubjects", $("#teaSubjects").val());
    formData.append("teaPhone", $("#teaPhone").val());
    formData.append("teaWork", $("#teaWork").val());
    formData.append("teaRegistration", myTime);
    formData.append("teaInfo", $("#teaInfo").val());
    $.ajax({
        type: "POST",
        async: false,
        mimeType: "multipart/form-data",
        url: "/insertTeacher",
        data: formData,
        /**
         * 必须false才会自动加上正确的Content-Type
         * */
        contentType: false,
        /**
         * 必须false才会避开jQuery对formdata的默认处理
         * XMLHttpRequest会对formdata进行正确的处理
         * */
        processData: false,
        success: function (result) {
            console.log(result);
            window.location.href = "/teacherList.jsp";
        }
    });
}

//添加图片预览
//获取图片路劲的方法，兼容多种浏览器，通过createObjectURL实现
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) {
        url = window.createObjectURL(file);//basic
    } else if (window.URL != undefined) {
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) {
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}

//实现功能代码
$(function () {
    $("#browerfile").change(function () {
        var path = browerfile.value;
        var objUrl = getObjectURL(this.files[0]);
        if (objUrl) {
            $('.img1-img').attr("src", objUrl);
        }
    })
})