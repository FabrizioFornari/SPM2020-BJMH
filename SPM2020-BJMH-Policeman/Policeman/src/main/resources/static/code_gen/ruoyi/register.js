
$(function() {
    validateRule();
    $('.imgcode').click(function() {
		var url = ctx + "captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
		$(".imgcode").attr("src", url);
	});
});

$.validator.setDefaults({
    submitHandler: function() {
    	register();
    }
});

function register() {
	$.modal.loading($("#btnSubmit").data("loading"));
	var username = $.common.trim($("input[name='username']").val());
    var password = $.common.trim($("input[name='password']").val());
    var validateCode = $("input[name='validateCode']").val();
    $.ajax({
        type: "post",
        url: ctx + "register",
        data: {
            "loginName": username,
            "password": password,
            "validateCode": validateCode
        },
        success: function(r) {
            if (r.code == 0) {
            	layer.alert("<font color='red'>Congratulations, your account " + username + " registration success！</font>", {
        	        icon: 1,
        	        title: "system hint"
        	    },
        	    function(index) {
        	        //Close popup
        	        layer.close(index);
        	        location.href = ctx + 'login';
        	    });
            } else {
            	$.modal.closeLoading();
            	$('.imgcode').click();
            	$(".code").val("");
            	$.modal.msg(r.msg);
            }
        }
    });
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
    $("#registerForm").validate({
        rules: {
            username: {
                required: true,
                minlength: 2
            },
            password: {
                required: true,
                minlength: 5
            },
            confirmPassword: {
                required: true,
                equalTo: "[name='password']"
            }
        },
        messages: {
            username: {
                required: icon + "Please enter your username",
                minlength: icon + "User name cannot be less than 2 characters"
            },
            password: {
            	required: icon + "please enter your password",
                minlength: icon + "Password cannot be less than 5 characters",
            },
            confirmPassword: {
                required: icon + "Please enter your password again",
                equalTo: icon + "Two password entries are inconsistent"
            }
        }
    })
}
