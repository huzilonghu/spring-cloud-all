/*
 * Copyright Fund Sing Co.Lit , 2014-2015, All rights reserved.
 *
 */
package com.miao.car.base.util;

import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author George Woo wbjcn@foxmail.com
 * @since: 2015年9月27日
 * @version: $Revision$ $Date$ $LastChangedBy$
 * 
 * 
 */
public class DateUtil {

    static public String[] pattern = new String[]{"yyyy-MM","yyyyMM","yyyy/MM",
            "yyyyMMdd","yyyy-MM-dd","yyyy/MM/dd",
            "yyyyMMddHHmmss",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy/MM/dd HH:mm:ss"};
    //DateUtils.parseDate(date, pattern);

    static public String fullPattern="yyyy-MM-dd HH:mm:ss";


    static public Date addDays(Date date, int amount) {

        return DateUtils.addDays(date, amount);
    }

    static public Date formatBeginDate(Date date) {
        date.setHours(00);
        date.setMinutes(00);
        date.setSeconds(00);
        return date;
    }

    static public Date formatEndDate(Date date) {
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        return date;
    }

    /**
     * @param beginDate
     * @param endDate
     * @return
     */
    static public int getIntervalDays(Date beginDate, Date endDate) {

        if (endDate.getTime() <= beginDate.getTime()) {
            return 0;
        }

        long mills = endDate.getTime() - beginDate.getTime() + 1;

        return (int) (mills / (DateUtils.MILLIS_PER_DAY));

    }

    static public Date infiniteDay() {

        Calendar cal = new GregorianCalendar(2100, 1, 1, 0, 0, 0);
        Date date = cal.getTime();

        return date;
    }

    static public boolean isInfinite(Date date) {

        Date date1 = DateUtil.truncateYear(date);

        int i = DateUtil.truncateYear(DateUtil.infiniteDay()).compareTo(date1);
        if (i <= 0) {
            return true;
        }
        return false;
    }

    static public Date truncateDate(Date date) {

        return DateUtils.truncate(date, Calendar.DATE);
    }

    static public Date truncateYear(Date date) {

        return DateUtils.truncate(date, Calendar.YEAR);
    }


    static  public  Date  getCurrentDate(){
        return new Date();
    }

    static public Date truncateStringtToDate(String dateString,String  partern) {
        SimpleDateFormat sdf = new SimpleDateFormat(partern);

        Date date = null; //初始化date
        try {
            date = sdf.parse(dateString); //Mon Jan 14 00:00:00 CST 2013
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    static public  int  dayDiff(Date secondTime,Date firstTime){
        long  dayLong=1000*3600*24;
        int betweenDays=0;
        try {
             betweenDays = CalculateUtil.safeDivide(CalculateUtil.safeSubtract(new BigDecimal(secondTime.getTime()), new BigDecimal(firstTime.getTime())), new BigDecimal(dayLong)).intValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return betweenDays;
    }

    /***
     * 时间按照月份的移动
     */

    public  static Date  getDiffMonthDate(int i){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, i);//得到前3个月
        Date  formNow3Month = calendar.getTime();

       // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

         //System.out.println(sdf.format(formNow3Month));
        return formNow3Month;
    }

    /**
     *获得当年的第一天
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 得到当前时间的格式化  yyyy-MM-dd HH:mm:ss
     */
    public static String  getFullFromateDateStr(Date date){
        if (date==null){
           date=new Date();
        }
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=formatter.format(date);
        return time;
    }

    public static String  getShortFromateDateStr(Date date){
        if (date==null){
            date=new Date();
        }
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        String time=formatter.format(date);
        return time;
    }

    public static String  getShortFromateCNDateStr(Date date){
        if (date==null){
            date=new Date();
        }
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日");
        String time=formatter.format(date);
        return time;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        getDiffMonthDate(1);
        // Calendar endCal = new GregorianCalendar(2016, 2, 8, 2, 2, 2);
       //  Date endDate = endCal.getTime();
      //  Date orderPayDate = addDays(endDate,1);
       // System.out.println("Original Date:" + endDate);

       // System.out.println("Plus 1 Date:" + orderPayDate);

       // System.out.println("Plus 1 Date----:" + truncateStringtToDate("2019-09-09 12:09:09","yyyy-MM-dd HH:mm:ss"));

        // System.out.println("2100 2 2 2 2 2  :" + isInfinite(new GregorianCalendar(2100, 2, 2, 2, 2, 2).getTime()));

        return;
        //
        //
        //
        // Calendar endCal = new GregorianCalendar(2200, 2, 2, 2, 2, 2);
        // Date endDate = endCal.getTime();
        //
        // System.out.println("Date:" + endDate);
        //
        // System.out.println("DateUtils.truncate(date,Calendar.YEAR)" + DateUtils.truncate(endDate, Calendar.YEAR));
        // System.out.println("DateUtils.truncate(date,Calendar.MONTH)" + DateUtils.truncate(endDate, Calendar.MONTH));
        // System.out.println("DateUtils.truncate(date,Calendar.DATE)" + DateUtils.truncate(endDate, Calendar.DATE));
        // System.out.println("DateUtils.truncate(date,Calendar.HOUR)" + DateUtils.truncate(endDate, Calendar.HOUR));
        //
        // DateUtils.truncate(endDate, Calendar.MONTH);
        //
        // int intervalDays = DateUtil.getIntervalDays(beginDate, endDate);
        //
        // System.out.println(intervalDays);

    }



}
