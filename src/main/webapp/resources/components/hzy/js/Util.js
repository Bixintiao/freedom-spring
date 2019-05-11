Util = {
    formatDate : function(dateStr,fmt){
        var date = new Date(dateStr);
        var obj = {
            "y+" : date.getFullYear(),
            "M+" : function () {
                var month = (date.getMonth()+1)+"";
                month = month.length == 1 ? "0"+month : month;
                return month;
            },
            "q+" : Math.floor((date.getMonth()+3)/3), //季度
            "d+" : date.getDate(),
            "H+" : date.getHours(),
            "m+" : date.getMinutes(),
            "s+" : date.getSeconds(),
            "S+" : date.getMilliseconds() //毫秒
        };
        for (var i in obj)
            if (new RegExp("("+i+")").test(fmt))
                fmt = fmt.replace(RegExp.$1,obj[i]);
        return fmt;
    },

    isAvailable : function isAvailable(var1){
        if (var1 == null && var1 == undefined || var1 == NaN || var1 == '' || var1 == 'null'){
            return false;
        }
        return true;
    },

    log : function (message,color){
        console.log("%c"+message, "color:"+color);
    }
};

function formatDate(dateStr,fmt){
    return Util.formatDate(dateStr, fmt);
}