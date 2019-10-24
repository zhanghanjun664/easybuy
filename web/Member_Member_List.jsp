<%@ page import="easybuy.utils.Utils" %>
<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
        
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<%--    <script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>--%>
<%--    <script src="js/jquery-3.4.1.min.js"></script>--%>
<%--    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>--%>
    <script type="text/javascript" src="js/menu.js"></script>
        
	<script type="text/javascript" src="js/select.js"></script>

    <style>
        .modal_bg{
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0, .6);
            display: none;
        }
        .modal_container{
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            left: 0;
            right: 0;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 6px;
            padding: 40px 24px;
            width: 260px;
        }
        .btn_close{
            position: absolute;
            right: 10px;
            top: 0;
            cursor: pointer;
            font-size: 16px;
        }
        /*.btn_modify,.btn_delete{*/
        /*    cursor: pointer;*/
        /*}*/

    </style>
        
    
<title>尤洪</title>
</head>
<body>

    <%
        Cookie[] cookies = request.getCookies();
        String username = Utils.getCookieByName("username", cookies);
        request.setAttribute("username", username);

    %>

<%--    弹窗--%>
    <div class="modal_bg">
        <div class="modal_container">
            <div class="btn_close">X</div>
            <table>
                <tr>
                    <td>姓名：</td>
                    <td>
                        <input type="text" value="" class="info_name">
                        <div class="tips"></div>
                    </td>
                </tr>
                <tr>
                    <td>手机号：</td>
                    <td><input type="number" value="" class="info_mobile"></td>
                </tr>
                <tr>
                    <td>邮箱：</td>
                    <td><input type="text" value="" class="info_email"></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>
                        <select class="info_sex">
                            <option value="1">男</option>
                            <option value="0">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center">
                        <button class="submit">确定</button>
                    </td>
                </tr>

            </table>



        </div>

    </div>

<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
    	<!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
<%--        	<span class="fl">你好，请<a href="Login.jsp">登录</a>&nbsp; <a href="Regist.jsp" style="color:#ff4e00;">免费注册</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|</span>--%>
            <span class="fl">
                <c:choose>
                    <c:when test="${empty username}">
                        你好，请<a href="Login.jsp">登录</a>
                        <a href="Regist.jsp" style="color:#ff4e00;">免费注册</a>&nbsp;
                    </c:when>
                    <c:otherwise>
                        ${username}，你好
                    </c:otherwise>
                </c:choose>
                | <a href="#">我的订单</a>&nbsp;|
            </span>
        	<span class="ss">
            	<div class="ss_list">
                	<a href="#">收藏夹</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">我的收藏夹</a></li>
                                <li><a href="#">我的收藏夹</a></li>
                            </ul>
                        </div>
                    </div>     
                </div>
                <div class="ss_list">
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<div class="m_top_bg">
    <div class="top">
        <div class="m_logo"><a href="Index.jsp"><img src="images/logo1.png" /></a></div>
        <div class="m_search">
            <form>
                <input type="text" value="" class="m_ipt" />
                <input type="submit" value="搜索" class="m_btn" />
            </form>                      
            <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
        </div>
        <div class="i_car">
            <div class="car_t">购物车 [ <span>3</span> ]</div>
            <div class="car_bg">
                <!--Begin 购物车未登录 Begin-->
                <div class="un_login">还未登录！<a href="Login.jsp" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
                <!--End 购物车未登录 End-->
                <!--Begin 购物车已登录 Begin-->
                <ul class="cars">
                    <li>
                        <div class="img"><a href="#"><img src="images/car1.jpg" width="58" height="58" /></a></div>
                        <div class="name"><a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a></div>
                        <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                    </li>
                    <li>
                        <div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58" /></a></div>
                        <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                        <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                    </li>
                    <li>
                        <div class="img"><a href="#"><img src="images/car2.jpg" width="58" height="58" /></a></div>
                        <div class="name"><a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a></div>
                        <div class="price"><font color="#ff4e00">￥399</font> X1</div>
                    </li>
                </ul>
                <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span></div>
                <div class="price_a"><a href="#">去购物车结算</a></div>
                <!--End 购物车已登录 End-->
            </div>
        </div>
    </div>
</div>
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<div class="m_left">
        	<div class="left_n">管理中心</div>
            <div class="left_m">
            	<div class="left_m_t t_bg1">订单中心</div>
                <ul>
                	<li><a href="Member_Order.html">我的订单</a></li>
                    <li><a href="Member_Address.html">收货地址</a></li>
                    <li><a href="#">缺货登记</a></li>
                    <li><a href="#">跟踪订单</a></li>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg2">会员中心</div>
                <ul>
                	<li><a href="Member_User.html">用户信息</a></li>
                    <li><a href="Member_Collect.html">我的收藏</a></li>
                    <li><a href="Member_Msg.html">我的留言</a></li>
                    <li><a href="Member_Links.html">推广链接</a></li>
                    <li><a href="#">我的评论</a></li>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg3">账户中心</div>
                <ul>
                	<li><a href="Member_Safe.html">账户安全</a></li>
                    <li><a href="Member_Packet.html">我的红包</a></li>
                    <li><a href="Member_Money.html">资金管理</a></li>
                </ul>
            </div>
            <div class="left_m">
            	<div class="left_m_t t_bg4">分销中心</div>
                <ul>
                	<li><a href="Member_Member.jsp" class="now">我的会员</a></li>
                    <li><a href="Member_Results.html">我的业绩</a></li>
                    <li><a href="Member_Commission.html">我的佣金</a></li>
                    <li><a href="Member_Cash.html">申请提现</a></li>
                </ul>
            </div>
        </div>
		<div class="m_right">
            <p></p>
            
			<div class="mem_t">
            	<span class="m_num fr" style="margin-top:15px;"><a href="#">返回</a></span>用户列表
            </div>
            <table border="1" class="mem_tab" style="width:870px; text-align:center; margin-top:20px;" cellspacing="0" cellpadding="0">
              <thead>
              <tr>
                    <td class="th_bg" colspan="8"><span class="level">-</span>&nbsp; &nbsp; &nbsp;<b class="lCount">（-人）</b></td>

                </tr>
                  <tr>
                      <td width="145" class="td_bg">会员名</td>
                      <td width="145">真实姓名</td>
                      <td width="145" class="td_bg">邮箱</td>
                      <td width="145">手机号</td>
                      <td width="145" class="td_bg">性别</td>
                      <td width="145">类型</td>
                      <td width="80" class="td_bg" colspan="2">操作</td>
                  </tr>
              </thead>
                <tbody class="listBox"></tbody>
<%--                    <tr>--%>
<%--                        <td width="145" class="td_bg">会员名</td>--%>
<%--                        <td width="145">真实姓名</td>--%>
<%--                        <td width="145" class="td_bg">性别</td>--%>
<%--                        <td width="145">类型</td>--%>
<%--                        <td width="145" class="td_bg" >修改</td>--%>
<%--                        <td width="145" class="td_bg" >删除</td>--%>
<%--                    </tr>--%>





            </table>

            <div class="pages">
                <a href="javascript:void(0)" class="btn_pre">上一页</a>

                <span class="pageNum">
<%--                    <a href="javascript:void(0)" data-num="1">1</a>--%>
                </span>

                <a href="javascript:void(0)" class="btn_next">下一页</a>

            </div>
                                                                                        
 
                       
            
			


            
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <div class="b_btm_bg b_btm_c">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>

              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                <td><h2>准时送达</h2>收货时间由你做主</td>
              </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
    	<dl>                                                                                            
        	<dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
        	<a href="#" class="b_sh1">新浪微博</a>            
        	<a href="#" class="b_sh2">腾讯微博</a>
            <p>
            服务热线：<br />
            <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="images/er.gif" width="118" height="118" /></div>
            <img src="images/ss.png" />
        </div>
    </div>    
    <div class="btmbg">
		<div class="btm">
        	备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
        </div>    	
    </div>
    <!--End Footer End -->    
</div>

<%--    <script src="js/jquery-3.4.1.min.js"></script>--%>

    <script src="js/common.js"></script>

    <script>
        var level = getQueryString("level")
        var dataSource = []; //数据源
        var curPage = 1; //当前页数
        var curItem = {}; //当前弹窗项
        var pages = 0;

        //1:大众会员，2：高级会员，3：镇店之宝
        var levelMapped = {
            1: "大众会员",
            2: "高级会员",
            3: "镇店之宝",
            4: "管理员"
        }

        var sexMapped = {
            1: "男",
            0: "女"
        }

        function getUserItemTmp(item) {

            var tmp = '<tr>\n' +
                '<td width="145" class="td_bg username">'+ item.userName +'</td>\n' +
                '<td width="145" class="username">'+ item.userName +'</td>\n' +
                '<td width="145" class="td_bg">'+ item.email +'</td>\n' +
                '<td width="145">'+ item.mobile +'</td>' +
                '<td width="145" class="td_bg">'+ sexMapped[item.sex] +'</td>\n' +
                '<td width="145">'+ levelMapped[item.level] +'</td>\n' +
                '<td width="145" class="td_bg" ><a href="javascript:void(0)" class="btn_modify">修改</a></td>\n' +
                '<td width="145" class="td_bg" ><a href="javascript:void(0)" class="btn_delete">删除</a></td>\n' +
                '</tr>'

            return tmp

        }

        function getUserListHtml(arr) {
            var html = ""
            arr.map(function(item){
                html += getUserItemTmp(item)
            })
            return html
        }

        function renderUserList(arr) {
            var html = getUserListHtml(arr);

            $(".listBox").html(html)

        }

        function renderPages(pages){
            var html = ""
            for(var i = 0; i<pages; i++){
                html += '<a href="javascript:void(0)" data-num="'+ (i+1) +'">'+ (i+1) +'</a>'
            }
            $(".pageNum").html(html)
        }

        //获取第一页数据
        getUserList()

        //获取当前页数据
        function getUserList(){
            ajax({
                url: "memberList",
                dataType: "json",
                data: {level: level, pageNum: curPage},
                success: function (data) {
                    console.log("success", data)
                    dataSource = data.list || [];
                    //渲染数据
                    renderUserList(dataSource)

                    //渲染分页
                    renderPages(data.pages)

                    //设置总页数
                    pages = data.pages

                    var total = "("+data.total+")人"
                    var levelType = levelMapped[level];
                    $(".level").text(levelType)
                    $(".lCount").text(total);

                }
            })
        }

        //打开修改信息弹窗，并设置数据
        function openModal(item){
            console.log("item==>", item)
            curItem = item
            setInfoValue(item.userName, item.mobile, item.email, item.sex)

            $(".modal_bg").fadeIn()

        }

        function closeModal(){
            setInfoValue()
            $(".modal_bg").fadeOut(200)
        }

        function setInfoValue(name, mobile, email, sex){
            $(".info_name").val(name)
            $(".info_mobile").val(mobile)
            $(".info_email").val(email)
            $(".info_sex").val(sex)
        }


        // var xhr = new XMLHttpRequest();
        // xhr.open("get", "memberList?level=1")
        // xhr.send()


    //    事件
        $(".btn_close").click(function(){
            closeModal()
        })

        $(".mem_tab").on("click", ".btn_modify", function () {
            var index = $(this).parents("tr").index()
            // console.log(index, dataSource)
            openModal(dataSource[index])
        })

    //    分页
        $(".pageNum").on("click", "a", function(){
            var pageNum = $(this).attr("data-num");
            console.log(pageNum)
            curPage = pageNum

            getUserList()

        })

    //    上一页
        $(".btn_pre").click(function(){
            if(curPage>1){
                curPage--;
                getUserList()
            }
        })

    //    下一页
        $(".btn_next").click(function(){
            if(curPage < pages){
                curPage++;
                getUserList()
            }
        })

    //    修改信息
        $(".submit").click(function(){
            var name = $(".info_name").val()
            var mobile = $(".info_mobile").val()
            var email = $(".info_email").val()
            var sex = $(".info_sex").val()
            var id = curItem.id
            console.log(name, mobile, email, sex)

            var params = {
                username: name,
                mobile: mobile,
                email: email,
                sex: sex,
                id: id
            }

            ajax({
                url: "user/modify",
                type: "post",
                data: JSON.stringify(params),
                contentType: "application/json",
                // contentType: "application/x-www-form-urlencoded",
                success: function (data) {
                    console.log("success==>",data)
                    alert("修改成功")
                    closeModal()
                //    更新数据
                    getUserList()

                }
            })

        })

    //    删除用户
        $(".mem_tab").on("click", ".btn_delete", function () {
            var index = $(this).parents("tr").index()
            var id = dataSource[index].id
            // console.log("deleteID=>", id)

            ajax({
                url: "user/delete",
                type: "delete",
                data: JSON.stringify({uid: id}),
                contentType: "application/json",
                success: function(data){
                    console.log("success", data)
                    alert("删除成功")

                    getUserList()
                }
            })

        })

        //检测用户名是否重复
        $(".info_name").on("blur", function(){
            ajax({
                url: "user/check",
                data: {username: this.value},
                success: function(data){
                    console.log("success",data)
                    if(data.isExist){
                        $(".tips").show()
                        $(".tips").html("用户名重复！！")

                    }else{
                        $(".tips").show();
                        $(".tips").html("用户名可用！")
                    }
                }
            })
        })

        $(".info_name").on("focus", function(){
            $(".tips").hide();
        })




    </script>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
