//数据转化
function formatNumber(n) {
    n = n.toString()
    return n[1] ? n : '0' + n
  }

  /**
   * 时间戳转化为年 月 日 时 分 秒
   * number: 传入时间戳
   * format：返回格式，支持自定义，但参数必须与formateArr里保持一致
   * let timeformat = format.formatTime(sjc,'Y-M-D h:m:s');
  */
  function formatTime(number,format) {
    if(number=='' || number==undefined){
      return;
    }

    var formateArr  = ['Y','M','D','h','m','s'];
    var returnArr   = [];

    var date = new Date(number);
    returnArr.push(date.getFullYear());
    returnArr.push(formatNumber(date.getMonth() + 1));
    returnArr.push(formatNumber(date.getDate()));

    returnArr.push(formatNumber(date.getHours()));
    returnArr.push(formatNumber(date.getMinutes()));
    returnArr.push(formatNumber(date.getSeconds()));

    for (var i in returnArr)
    {
      format = format.replace(formateArr[i], returnArr[i]);
    }
    return format;
  }

/**
 * 获取当前时间年份
 * @returns {number}
 */
function getCurrentYear() {
      var myDate = new Date();
      return myDate.getFullYear()
  }

function getCurrentWeek() {

      var totalDays = 0;
      var now = new Date();
      var years = now.getYear()
      if (years < 1000)
          years += 1900
      var days = new Array(12);
      days[0] = 31;
      days[2] = 31;
      days[3] = 30;
      days[4] = 31;
      days[5] = 30;
      days[6] = 31;
      days[7] = 31;
      days[8] = 30;
      days[9] = 31;
      days[10] = 30;
      days[11] = 31;

      //判断是否为闰年，针对2月的天数进行计算
      if (Math.round(now.getYear() / 4) == now.getYear() / 4) {
          days[1] = 29
      } else {
          days[1] = 28
      }
      if (now.getMonth() == 0) {
          totalDays = totalDays + now.getDate();
      } else {
          var curMonth = now.getMonth();
          for (var count = 1; count <= curMonth; count++) {
              totalDays = totalDays + days[count - 1];
          }
          totalDays = totalDays + now.getDate();
      }
      //得到第几周
  var week = Math.ceil(totalDays / 7);
  return week;

}

  function weekList(year){
    let weekList = []
      for (var i=1;i<=53;i++){
          let startDate = getXDate(year,i-1,1);
          let endDate = getXDate(year,i,0);
          weekList.push({value:i,year:year,text:'第'+i + '周('+formatTime(startDate, 'Y-M-D') + '-' + formatTime(endDate, 'Y-M-D')+')'});
      }
      return weekList;
  }

  function yearList(){

      let maxYear = getCurrentYear();
      let yearList = []
      for (var i=maxYear;i>=2000;i--){
          yearList.push(i);
      }
      return yearList;

  }


var now = new Date();                    //当前日期
var nowDayOfWeek = now.getDay();         //今天本周的第几天
var nowDay = now.getDate();              //当前日
var nowMonth = now.getMonth();           //当前月
var nowYear = now.getYear();             //当前年
nowYear += (nowYear < 2000) ? 1900 : 0;  //

//格式化日期：yyyy-MM-dd
function formatDate(date) {
    var myyear = date.getFullYear();
    var mymonth = date.getMonth() + 1;
    var myweekday = date.getDate();

    if (mymonth < 10) {
        mymonth = "0" + mymonth;
    }
    if (myweekday < 10) {
        myweekday = "0" + myweekday;
    }
    return (myyear + "-" + mymonth + "-" + myweekday);
}

//获得某月的天数
function getMonthDays(myMonth) {
    var monthStartDate = new Date(nowYear, myMonth, 1);
    var monthEndDate = new Date(nowYear, myMonth + 1, 1);
    var days = (monthEndDate - monthStartDate) / (1000 * 60 * 60 * 24);
    return days;
}

//获得本季度的开始月份
function getQuarterStartMonth() {
    var quarterStartMonth = 0;
    if (nowMonth < 3) {
        quarterStartMonth = 0;
    }
    if (2 < nowMonth && nowMonth < 6) {
        quarterStartMonth = 3;
    }
    if (5 < nowMonth && nowMonth < 9) {
        quarterStartMonth = 6;
    }
    if (nowMonth > 8) {
        quarterStartMonth = 9;
    }
    return quarterStartMonth;
}

//获得本周的开始日期
function getWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
    return formatDate(weekStartDate);
}

function getStartDate(year,weekNum) {

    let startDate = getXDate(year,weekNum-1,1);
    return formatTime(startDate, 'Y-M-D');
}

function getEndDate(year,weekNum) {

    let endDate = getXDate(year,weekNum,0);
    return formatTime(endDate, 'Y-M-D');
}
//获得本周的结束日期
function getWeekEndDate() {
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
    return formatDate(weekEndDate);
}

//获得本月的开始日期
function getMonthStartDate() {
    var monthStartDate = new Date(nowYear, nowMonth, 1);
    return formatDate(monthStartDate);
}

//获得本月的结束日期
function getMonthEndDate() {
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));
    return formatDate(monthEndDate);
}

//获得本季度的开始日期
function getQuarterStartDate() {

    var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1);
    return formatDate(quarterStartDate);
}

//或的本季度的结束日期
function getQuarterEndDate() {
    var quarterEndMonth = getQuarterStartMonth() + 2;
    var quarterStartDate = new Date(nowYear, quarterEndMonth, getMonthDays(quarterEndMonth));
    return formatDate(quarterStartDate);
}

//获得本年的开始日期
function getYearStartDate() {
    //获得当前年份4位年
    var currentYear=now.getFullYear();
    //本年第一天
    var currentYearFirstDate=new Date(currentYear,0,1);
    return formatDate(currentYearFirstDate);
}

//获得本年的结束日期
function getYearEndDate() {
    //获得当前年份4位年
    var currentYear=now.getFullYear();
    //本年最后
    var currentYearLastDate=new Date(currentYear,11,31);
    return formatDate(currentYearLastDate);
}

/**
 * 根据年份，周数获取日期
 * @param year 年份
 * @param weeks 周数
 * @param weekDay 每周的周几
 * @returns {*}
 */
function getXDate(year,weeks,weekDay){
// 用指定的年构造一个日期对象，并将日期设置成这个年的1月1日
// 因为计算机中的月份是从0开始的,所以有如下的构造方法
    var date = new Date(year,"0","1");

// 取得这个日期对象 date 的长整形时间 time
    var time = date.getTime();

// 将这个长整形时间加上第N周的时间偏移
// 因为第一周就是当前周,所以有:weeks-1,以此类推
// 7*24*3600000 是一星期的时间毫秒数,(JS中的日期精确到毫秒)
    time+=(weeks-1)*7*24*3600000;

// 为日期对象 date 重新设置成时间 time
    date.setTime(time);
    return getNextDate(date,weekDay);
}

function getNextDate(nowDate,weekDay){
// 0是星期日,1是星期一,...
    weekDay%=7;
    var day = nowDate.getDay();
    var time = nowDate.getTime();
    var sub = weekDay-day;
    if(sub <= 0){
        sub += 7;
    }
    time+=sub*24*3600000;
    nowDate.setTime(time);
    return nowDate;
}

module.exports = {
     formatTime: formatTime,
      weekList:weekList,
      yearList:yearList,
      getCurrentYear:getCurrentYear,
      getCurrentWeek:getCurrentWeek,
    getWeekStartDate:getWeekStartDate,
    getWeekEndDate:getWeekEndDate,
    formatDate:formatDate,
    getStartDate:getStartDate,
    getEndDate:getEndDate,
}
