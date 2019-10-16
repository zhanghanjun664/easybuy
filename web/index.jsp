<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>欢迎来到英雄联盟</h1>
    <%
//      Object legends = request.getAttribute("legends");
//      Object fields = request.getAttribute("fields");
    %>
<%--    legends:${legends}--%>
<%--    fields:${fields}--%>
    <table border="1">
      <tr>
        <td>id</td>
        <td>name</td>
        <td>ages</td>
        <td>catalog_id</td>
        <td>sex</td>
        <td>操作</td>
        <td>操作</td>
        <td><a href="<%=request.getContextPath()%>/update.jsp">添加</a></td>
      </tr>
      <tr>
        <c:forEach items="${fields}" var="item" >
          <td>${item}</td>
        </c:forEach>
      </tr>

      <c:forEach items="${legends}" var="item">
        <tr>
          <td>${item.id}</td>
          <td>${item.name}</td>
          <td>${item.ages}</td>
          <td>${item.catalog_id}</td>
          <td>${item.sex}</td>
          <td><a href="<%=request.getContextPath()%>/delete?id=${item.id}">删除</a></td>
          <td><a href="<%=request.getContextPath()%>/afterModify?id=${item.id}">修改</a></td>
        </tr>
      </c:forEach>

    </table>

    <div>
      <c:if test="${pageNo>1}">
        <a href="<%=request.getContextPath()%>/index?pageNo=${pageNo-1}">上一页</a>
      </c:if>
      <c:if test="${pageNo < totalPageCount}">
        <a href="<%=request.getContextPath()%>/index?pageNo=${pageNo+1}">下一页</a>
      </c:if>
      <a href="<%=request.getContextPath()%>/index?pageNo=1">首页</a>
      <a href="<%=request.getContextPath()%>/index?pageNo=${totalPageCount}">最后一页</a>
      <form action="">
        跳到第<input type="text" name="pageNo" class="pageNo">页
        <input type="submit" value="go" class="submit">

      </form>

      总数量：${legendsCount},
      总页数：<span class="totalPageCount">${totalPageCount}</span>,
      当前页码：${pageNo},
      每页展示${pageSize}个英雄
    </div>

<%--    <script src="<%=request.getContextPath()%>/utils/jquery-1.8.3.min.js"></script>--%>
<%--    <script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>--%>
    <script src="./utils/jquery-1.8.3.min.js"></script>

    <script>
      var totalPageCount = parseInt($(".totalPageCount").text());
      $(".pageNo").on("input", function () {
        var pageNo = parseInt($(this).val());
        if(pageNo <= 0 || pageNo > totalPageCount){
          console.log("输入值不合法")
          $(".submit").attr("disabled", true)
        }else{
          $(".submit").attr("disabled", false)
        }


      })

    </script>

  </body>
</html>
