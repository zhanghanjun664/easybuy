
var PROJECT_PREFIX = "easybuy_"

var $ = jQuery;

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

//获取cookie
function getCookie(name) {
  var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
  if(arr=document.cookie.match(reg))
    return decodeURIComponent(arr[2]);
  else
    return null;
}

function ajax(params){

  var username = getCookie("username");

  var header = {
    auth: username
  }

  params.headers = Object.assign({}, params.headers, header)
  // console.log("params==>", JSON.parse(JSON.stringify(params)))

  return $.ajax({
    ...params,
    dataType: "json",
    success: function (data) {
      if(data.resultCode === 0){
        data = data.data || {}
        params.success && params.success(data)

      }else{
        alert("请求有误")
      }
    },
    error: function (err) {
      alert("网络异常，请稍后重试")
    }
  })
}