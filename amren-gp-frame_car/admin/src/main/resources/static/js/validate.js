layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    $ = layui.jquery;

	// $.extend($.fn.validatebox.defaults.rules, {
	//     //验证新密码格式
    //     pwd: {
    //         validator: function (value, param) {
    //             return (/^(?![A-Za-z0-9]+$)(?![a-z0-9\W]+$)(?![A-Za-z\W]+$)(?![A-Z0-9\W]+$)[a-zA-Z0-9\W]{8,}$/.test(value)&&value!=$('#'+param[0]).val());
    //         },
    //         message: '密码必须由8位以上大写字母+小写字母+数字+特殊符号组成！并且与原密码不同！'
    //     },
    //     // 新密码，两次密码一致
    //     sameToPwd: {
    //         validator: function(value, param){
    //             return value==$('#'+param[0]).val();
    //         },
    //         message: '与新密码不一致'
    //     },
    //     // 结束时间不得小于开始时间
    //     endTimeValidate: {
    //         validator: function(value, param){
    //             var start=$('#'+param[0]).datebox('getValue');
    //             var startStr=start.replace('-','').replace(' ','').replace(':','');
    //             var endStr=value.replace('-','').replace(' ','').replace(':','');
    //             return startStr<=endStr;
    //         },
    //         message: '请输入有效的时间段'
    //     },
    //
    //     // 最大金额不得小于最小金额
    //     maxAmtValidate: {
    //         validator: function(value, param){
    //             var min=$('#'+param[0]).textbox('getValue');
    //             var minStr=min.replace(/[,]/g,'')*100;
    //             var maxStr=value.replace(/[,]/g,'')*100;
    //             return minStr<=maxStr;
    //         },
    //         message: '请输入有效的金额段'
    //     },
    //
    //
    //     // 有效的数值范围
    //     endNumberValidate: {
    //         validator: function(value, param){
    //             var start=$('#'+param[0]).textbox('getValue');
    //             return Number(start)<=Number(value);
    //         },
    //         message: '请输入有效的数值范围'
    //     },
    //     // 导入文件限制
    //     fileLimit: {
    //         validator: function(value, param){
    //             var re=new RegExp(param[0]+"$");
    //             return re.test(value);
    //         },
    //         message: '只能上传{0}的文件'
    //     }
	// });
});
