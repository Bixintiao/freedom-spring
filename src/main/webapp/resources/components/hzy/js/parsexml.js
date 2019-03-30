/* text()方法可获取标签间文本	attr()可获取属性	find()用于选择元素的后代*/
function a(){
	$.ajax({
		type:"get",
		url:"config/config.xml",
		datatime:"xml",
		timeout:1000,
		cache:false,
		async:false,
		success:function(xml){
			var title = $(xml).find("title").text();
			console.log("title:" + title);
			// modules
			$(xml).find("modules").each(function(m_i,m_v){
				var modules_id = $(this).attr("id");
				var modules_name = $(this).attr("name");
				console.log(modules_id + ":" + modules_name);
				/* modules 下面对应的 submodule */
				$(this).find("submodule").each(function(sub_i,sub_v){
					var submodule_id = $(this).attr("id");
					var submodule_name = $(this).attr("name");
					console.log("\t"+submodule_id + ":" + submodule_name);
					/* submodule下面对应的item 子项 */
					$(this).find("item").each(function(item_i,item_v){
						var item_name = $(this).attr("name");
						var item_url = $(this).attr("url");
						console.log("\t\t"+item_name + ":" + item_url);
					});
				});
			});
		}
	});
}
function b(){
	$.get("config/config.xml",function(data,status){
		/* console.log(data); */
		/* title */
		var title = $(data).find("title").text();
		console.log("title:"+title +" status:"+status);
		/* modules */
		$(data).find("modules").each(function(m_i, m_v){
			var module_id = $(m_v).attr("id");
			var module_name = $(m_v).attr("name");
			console.log(m_i +" "+ module_id+"\t"+module_name);
			/* submodule */
			$(m_v).find("submodule").each(function(sub_i, sub_v){
				var sub_id = $(sub_v).attr("id");
				var sub_name = $(sub_v).attr("name");
				console.log("\t"+sub_id +" "+ sub_name);
				/* item */
				$(sub_v).find("item").each(function(item_i, item_v){
					var item_name = $(item_v).attr("name");
					var item_url = $(item_v).attr("url");
					console.log("\t\t"+item_name +" "+ item_url);
				});
			});
		});
	},"text");
}
	