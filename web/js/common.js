
var PROJECT_PREFIX = "easybuy_"

//获取浏览器参数
function getQueryString(name) {
  var after = window.location.href.split("?")[1] || '';
  if (after && name) {
    var reg = new RegExp("(^|&)" + name.trim() + "=([^&]*)(&|$)");
    var r = after.trim().match(reg);
    if (r != null) {
      return decodeURIComponent(r[2]);
    }
    else {
      return null;
    }
  }
}