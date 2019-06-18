<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
   <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <style type="text/css">
        #czmm{display: none}
        #yhzc{display: none}

        #remember{ width: 13px; height: 13px; margin: 0 3px 0 10px; vertical-align: middle;}

    </style>
 	
</head>
<body>

<div class="dowebok">
    <div class="container-login100" style="background: url('imgs/bg.jpg')">
        <div class="wrap-login100" style="background:rgba(255,255,255,0.3);padding-top: 100px">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="imgs/img-01.png" alt="IMG">
            </div>


            <form class="login100-form validate-form" action="UserServlet" method="post" name="from-czmm" id="czmm" >
            	<input type="hidden" value="editUser" name="method">
				<span class="login100-form-title" style="padding-bottom: 35px;">
					重置密码
				</span>
                <p style="font-size: 14px; height: 20px; color:#FFFFFF;padding-left: 15px" class="err">${msg }</p>
                <div class="wrap-input100 validate-input">
                    <input class="input100" id="cz-yhm" type="text" value="${username }" name="username" placeholder="用户名">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-envelope" aria-hidden="true"></i>
					</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" id="cz-mm" type="password" name="password" placeholder="密码">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-lock" aria-hidden="true"></i>
					</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" id="cz-mmag" type="password" name="passag" placeholder="再次输入密码">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-lock" aria-hidden="true"></i>
					</span>
                </div>

                <div class="container-login100-form-btn">
                    <div class="login100-form-btn" id="btn-qrxg">
                        确认修改
                    </div>
                </div>
                <div class="text-center" style="margin-top: 60px">
                    <a class="txt2 back-login" href="javascript:">
                        返回登陆
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>


            <form class="login100-form validate-form" action="UserServlet" method="post" id="yhzc" >
            <input type="hidden" value="regist" name="method">
				<span class="login100-form-title" style="padding-bottom: 35px;">
					用户注册
				</span>
                <p style="font-size: 14px; height: 20px; color: #FFFFFF;padding-left: 15px" class="err">${msg }</p>
                <div class="wrap-input100 validate-input">
                    <input class="input100" id="zc-yhm" type="text" value="${username }" name="username" placeholder="用户名">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-envelope" aria-hidden="true"></i>
					</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" id="zc-mm" type="password" name="password" placeholder="密码">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-lock" aria-hidden="true"></i>
					</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" id="zc-mmag" type="password" name="passag" placeholder="再次输入密码">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-lock" aria-hidden="true"></i>
					</span>
                </div>

                <div class="container-login100-form-btn">
                    <div class="login100-form-btn" id="btn-ljzc">
                        立即注册
                    </div>
                </div>
                <div class="text-center" style="margin-top: 60px">
                    <a class="txt2 back-login" href="javascript:">
                        返回登陆
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>

            <form class="login100-form validate-form" id="yhdl" action="UserServlet" method="post">
             <input type="hidden" value="login" name="method">
				<span class="login100-form-title" style="padding-bottom: 35px;">
					用户登陆
				</span>
				
                <p style="font-size: 14px; height: 20px; color:#FFFFFF;padding-left: 15px" class="err">${msg }</p>
                <div class="wrap-input100 validate-input">
                    <input class="input100" id="dl-yhm" type="text" value="${username}" name="username" placeholder="用户名">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-envelope" aria-hidden="true"></i>
					</span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" id="dl-mm" type="password" name="password" placeholder="密码">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-lock" aria-hidden="true"></i>
					</span>
                </div>

                <div  style="margin: 0; padding:5px 0px 0px 2% ; height: auto; font-size: 13px;">

                        <div style="width: 48%;display: inline-block; padding-left: 10px ">
                            <input type="checkbox" id="remember" name="cb" value="ok" ><label for="remember">自动登录</label>
                        </div>

                        <div style="display: inline-block; width: 48% ;text-align: right;padding-right: 10px" >
                            <a href="#" class="txt2" id="wjmm">忘记密码？</a>
                        </div>

                </div>

                <div class="container-login100-form-btn" style="margin-top: 0px">
                    <div class="login100-form-btn" id="btn-dl">
                        登陆
                    </div>
                </div>



                <div class="text-center" style="margin-top: 95px">
                    <a class="txt2 rege" href="javascript:">
                        还没有账号？立即注册
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
<script>


	
		
	
	if("${ztm}" == "2"){
		  $("#czmm").show();
	        $("#yhdl").hide();
	        $("#yhzc").hide();
	}
	else if ("${ztm}" == "1"){
		  $("#czmm").hide();
	        $("#yhdl").hide();
	        $("#yhzc").show();
	}
	
	
    $("#wjmm").click(function () {
        $(".err").html("");
        $("#czmm").show();
        $("#yhdl").hide();
        $("#yhzc").hide();
    });

    $(".back-login").click(function () {
        $(".err").html("");
        $("#czmm").hide();
        $("#yhdl").show();
        $("#yhzc").hide();
    });

    $(".rege").click(function () {
        $(".err").html("");
        $("#czmm").hide();
        $("#yhdl").hide();
        $("#yhzc").show();
    });

    $("#btn-dl").click(function () {
        $(".err").html("");
        //document.from-czmm.submit();
        var yhm = $("#dl-yhm").val().trim();
        var mm = $("#dl-mm").val().trim();
        if(yhm == "" && mm == ""){
            $(".err").html("请输入用户名和密码");
        }else {
            $("#yhdl").submit();
        }
    });

    $("#btn-qrxg").click(function () {
        $(".err").html("");
        var yhm = $("#cz-yhm").val().trim();
        var mm = $("#cz-mm").val().trim();
        var mma = $("#cz-mmag").val().trim();
        if(yhm == ""|| mm == "" || mma == ""){
            $(".err").html("请输入用户名和密码");
        }else {
            if(mm == mma){
                //alert("ok");
                $("#czmm").submit();
            }else {
                $(".err").html("两次密码输入不正确");
                return;
            }
        }

    })

    $("#btn-ljzc").click(function () {
        $(".err").html("");
        var yhm = $("#zc-yhm").val().trim();
        var mm = $("#zc-mm").val().trim();
        var mma = $("#zc-mmag").val().trim();
        if(yhm == ""|| mm == "" || mma == ""){
            $(".err").html("请输入用户名和密码");
        }else {
            if(mm == mma){
                //alert("ok");
                $("#yhzc").submit();
            }else {
                $(".err").html("两次密码输入不正确");
                return;
            }
        }

    })

</script>
</html>
