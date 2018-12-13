$.ajax({
    url: "/getTeacherInfo/" + $("#teaId").val() + "",
    success: function (result) {
        document.getElementById("imgURL").src = result.teaImgUrl;
        document.getElementById("exampleInputName2").value = result.teaName;
        document.getElementById("exampleInputName3").value = result.teaNumber;
        document.getElementById("exampleInputName4").value = result.teaGender;
        document.getElementById("exampleInputName5").value = result.teaPassword;
        document.getElementById("inputText3").value = result.teaCollege + '学院';
        document.getElementById("inputText4").value = result.teaMajor;
        document.getElementById("exampleInputName6").value = result.teacherJob.teaPositionInfo;
        document.getElementById("exampleInputName7").value = result.teaSubjects;
        document.getElementById("exampleInputName8").value = result.teaWork;
        document.getElementById("teaInfo").innerHTML = '备注详解：' + result.teaInfo;
        document.getElementById("teaPhone").innerHTML = '联系方式：' + result.teaPhone;
        document.getElementById("teaRegistration").value = result.teaRegistration;
        console.log(result);
    }
});