<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <%
        String id = request.getParameter("id");
        String prefix = request.getContextPath();
        String url = id != null ? prefix + "/modify" : prefix + "/add";
        request.setAttribute("url", url);
    %>
    <h2>新增/修改页面</h2>
    <form action="${url}">
        <table>
            <tr>
                <td>name</td>
                <td><input type="text" name="name" value="${legend.name}"></td>
            </tr>
            <tr>
                <td>ages</td>
                <td><input type="text" name="ages" value="${legend.ages}"></td>
            </tr>
            <tr>
                <td>catalog_id</td>
                <td><input type="text" name="catalog_id" value="${legend.catalog_id}"></td>
            </tr>
            <tr>
                <td>sex</td>
                <td><input type="text" name="sex" value="${legend.sex}"></td>
            </tr>
            <input type="hidden" name="id" value="${legend.id}">
            <tr>
                <td><input type="submit" ></td>
            </tr>

        </table>
    </form>

</body>
</html>
