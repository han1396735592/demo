var tableIns
layui.use('table', function () {
    var table = layui.table;
    //第一个实例
    tableIns = table.render({
        elem: '#table'
        , height: 500
        , url: '/modules/sys/sysUser/getAll' //数据接口
        , cellMinWidth: 80
        , cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: 'ID', width: 80, sort: true}
            , {field: 'username', title: '用户名', width: 150}
            , {field: 'createDate', title: '创建时间', width: 177}
            , {field: 'status', title: 'status', width: 177},
            {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}

        ]]
        ,
        page: true
    });

    //监听行工具事件
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.get(baseUrl + "del", {id: obj.data.id}, function (res) {
                    console.log(res)
                    obj.del();
                    layer.close(index);
                })
            });
        } else if (obj.event === 'edit') {
            vm.$data.showList = false;
            vm.$data.user = obj.data;
            // layer.prompt({
            //     formType: 2
            //     , value: data
            // }, function (value, index) {
            //     obj.update({
            //         email: value
            //     });
            //     layer.close(index);
            // });
        }
    });

});
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //日期时间选择器
    laydate.render({
        elem: '#test5'
        , type: 'datetime',
        done: function (value, date) {
            console.log(value)
            vm.$data.user.createDate = value;
        }
    });
});

var baseUrl = "/modules/sys/sysUser/";
var vm = new Vue({
        el: "#user",
        data: {
            showList: true,
            user: {
                username: null,
                password: 123456,
                status: 1,
                createId: 1,
                creteDate: "2018-12-12 11:11:11"
            }
        },
        methods: {

            addUser: function () {
                this.showList = false;
                this.user = {
                    username: null,
                    password: null
                };

            },
            editUser: function () {
                this.showList = false;
            },
            lookList: function () {
                this.showList = true;
                tableIns.reload({
                    elem: '#table'
                    , toolbar: '#toolbarDemo',
                    page: true
                });
            },
            submit: function () {
                $.post((this.user.id ? baseUrl + "update" : baseUrl + "add"), this.user, function (res) {
                    if (res.success) {
                        vm.lookList()
                        console.log(res)
                    }
                })
            }
        }
    }
)








