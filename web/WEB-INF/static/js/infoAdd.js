function insertInfo() {
    //新增设置信息
    //获取类型编号infoStatus
    var status = document.getElementById("infoStatus").value;
    var infoStatus = status.substr(0, 1);
    //获取新增信息
    var message = document.getElementById("message").value;
    $.ajax({
        type: "POST",
        url: "/insertInfo",
        data: {
            _method: "POST",
            "infoStatus": infoStatus,
            "message": message
        },
        success: function (result) {
            console.log("添加成功");
            //删除刷新当前页面
            window.location.href = "/infoList.jsp";
        }
    });
}