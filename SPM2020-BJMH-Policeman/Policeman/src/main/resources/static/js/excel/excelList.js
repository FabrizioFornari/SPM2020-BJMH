/**
 * 用户管理
 */
var pageCurr;
var form;
$(function () {
    layui.use('table', function () {
        var table = layui.table;
        form = layui.form;

        tableIns = table.render({
            elem: '#uesrList',
            url: '/excel/getExcelList',
            text:'No data',
            method: 'post', //默认：get请求
            cellMinWidth: 80,
            height:'full-200',
            page: false,
            toolbar:true,
            request: {
                // pageName: 'pageNum', //页码的参数名称，默认：pageNum
                // limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
            },
            response: {
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'totals', //数据总数的字段名称，默认：count
                dataName: 'list' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type: 'numbers'}
                , {field: 't0', title: 't0', align: 'center'}
                , {field: 't1', title: 't1', align: 'center'}
                , {field: 't2', title: 't2', align: 'center'}
                , {field: 't3', title: 't3', align: 'center'}
                , {field: 't4', title: 't4', align: 'center'}
                , {field: 't5', title: 't5', align: 'center'}
                , {field: 't6', title: 't6', align: 'center'}
                , {field: 't7', title: 't7', align: 'center'}
                , {field: 't8', title: 't8', align: 'center'}
                , {field: 't9', title: 't9', align: 'center'}
                , {field: 't10', title: 't10', align: 'center'}
                , {field: 't11', title: 't11', align: 'center'}
                , {field: 't12', title: 't12', align: 'center'}
                , {field: 't13', title: 't13', align: 'center'}
                , {field: 't14', title: 't14', align: 'center'}
                , {field: 't15', title: 't15', align: 'center'}
                , {field: 't16', title: 't16', align: 'center'}
                , {field: 't17', title: 't17', align: 'center'}
                , {field: 't18', title: 't18', align: 'center'}
                , {field: 't19', title: 't19', align: 'center'}
                , {field: 't20', title: 't20', align: 'center'}
                , {field: 't21', title: 't21', align: 'center'}
                , {field: 't22', title: 't22', align: 'center'}
                , {field: 't23', title: 't23', align: 'center'}
                , {field: 't24', title: 't24', align: 'center'}
                , {field: 't25', title: 't25', align: 'center'}
                , {field: 't26', title: 't26', align: 'center'}
                , {field: 't27', title: 't27', align: 'center'}
                , {field: 't28', title: 't28', align: 'center'}
                , {field: 't29', title: 't29', align: 'center'}
                // , {title: '操作', align: 'center', toolbar: '#optBar'}
            ]],
            done: function (res, curr, count) {
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(curr);
                $("[data-field='userStatus']").children().each(function () {
                    if ($(this).text() == '1') {
                        $(this).text("Valid")
                    } else if ($(this).text() == '0') {
                        $(this).text("Invalid")
                    }
                });
                //得到数据总量
                //console.log(count);
                pageCurr = curr;
            }
        });

        //监听工具条
        table.on('tool(userTable)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                //Delete
                delUser(data, data.id, data.sysUserName);
            } else if (obj.event === 'edit') {
                //Edit
                openUser(data, "Edit");
            } else if (obj.event === 'recover') {
                //恢复
                recoverUser(data, data.id);
            }
        });

        //监听提交
        form.on('submit(userSubmit)', function (data) {
            formSubmit(data);
            return false;
        });
    });

    //搜索框
    layui.use(['form', 'laydate'], function () {
        var form = layui.form, layer = layui.layer
            , laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function (data) {
            //重新加载table
            load(data);
            return false;
        });
    });
});

//提交表单
function formSubmit(obj) {
    $.ajax({
        type: "POST",
        data: $("#userForm").serialize(),
        url: "/user/setUser",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg, function () {
                    layer.closeAll();
                    load(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("Operation request error, please try again later", function () {
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}

//开通用户
function addUser() {
    openUser(null, "Create new account");
}

function openUser(data, title) {
    var roleId = null;
    if (data == null || data == "") {
        $("#id").val("");
    } else {
        $("#id").val(data.id);
        $("#username").val(data.sysUserName);
        $("#mobile").val(data.userPhone);
        roleId = data.roleId;
    }
    var pageNum = $(".layui-laypage-skip").find("input").val();
    $("#pageNum").val(pageNum);
    $.ajax({
        url: '/role/getRoles',
        dataType: 'json',
        async: true,
        success: function (data) {
            $.each(data, function (index, item) {
                if (!roleId) {
                    var option = new Option(item.roleName, item.id);
                } else {
                    var option = new Option(item.roleName, item.id);
                    // // 如果是之前的parentId则设置选中
                    if (item.id == roleId) {
                        option.setAttribute("selected", 'true');
                    }
                }
                $('#roleId').append(option);//往下拉菜单里添加元素
                form.render('select'); //这个很重要
            })
        }
    });

    layer.open({
        type: 1,
        title: title,
        fixed: false,
        resize: false,
        shadeClose: true,
        area: ['550px'],
        content: $('#setUser'),
        end: function () {
            cleanUser();
        }
    });
}

function delUser(obj, id, name) {
    var currentUser = $("#currentUser").html();
    if (null != id) {
        if (currentUser == id) {
            layer.alert("Sorry, you cannot do the operate of delete yourself!");
        } else {
            layer.confirm('Do you want Delete' + name + 'account?', {
                btn: ['Confirm', 'Back'] //按钮
            }, function () {
                $.post("/user/updateUserStatus", {"id": id, "status": 0}, function (data) {
                    if (data.code == 1) {
                        layer.alert(data.msg, function () {
                            layer.closeAll();
                            load(obj);
                        });
                    } else {
                        layer.alert(data.msg);
                    }
                });
            }, function () {
                layer.closeAll();
            });
        }
    }
}

//恢复
function recoverUser(obj, id) {
    if (null != id) {
        layer.confirm('Do you want restore it？', {
            btn: ['Comfirm', 'Back'] //按钮
        }, function () {
            $.post("/user/updateUserStatus", {"id": id, "status": 1}, function (data) {
                if (data.code == 1) {
                    layer.alert(data.msg, function () {
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                }
            });
        }, function () {
            layer.closeAll();
        });
    }
}

function load(obj) {
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

