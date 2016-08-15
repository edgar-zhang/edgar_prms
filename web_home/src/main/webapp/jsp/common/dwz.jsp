<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common/taglib/taglib.jsp" %>
<link href="${baseURL }/pages/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${baseURL }/pages/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${baseURL }/pages/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${baseURL }/pages/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>

 <!--[if IE]>
<link href="pages/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="${baseURL }/pages/dwz/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>

<script src="${baseURL }/pages/dwz/bin/dwz.min.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script src="${baseURL }/pages/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="${baseURL }/pages/dwz/js/dwz.print.js" type="text/javascript"></script>


<script type="text/javascript">

$(function(){
	DWZ.init("${baseURL }/pages/dwz/dwz.frag.xml", {
		loginUrl:"${baseURL }/login", loginTitle:"登录",	// 弹出登录对话框
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"${baseURL }/pages/dwz/themes"}); // themeBase 相对于index页面的主题base路径
			//setTimeout(function() {$("#sidebar .toggleCollapse div").trigger("click");}, 10);//index页面初始化时隐藏左边菜单.
		}
	});
});

</script>