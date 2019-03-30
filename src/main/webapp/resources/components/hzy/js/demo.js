function soFramework(){}

var so = new soFramework();

soFramework.prototype.initSideMenus = function(url,moduleContainerId){
	console.log("initSideMenus:" + url +"  moduleContainerId:"+moduleContainerId);
	$.get(url,function(menus){
		if(null == menus){
			alert("没有获取到任何菜单!");
			return;
		}
	});
	
	
}