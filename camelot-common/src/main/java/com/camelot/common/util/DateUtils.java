package com.camelot.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * <p>Description: [日期工具类]</p>
 * Created on 2021/12/24
 *
 * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
 * @version 1.0
 */
public class DateUtils {

    /**
     * <p>Description: [获取T-1时间]</p>
     * Created on 2021/12/24
     *
     * @return yyyyMMdd
     * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
     * @version 1.0
     */
    public static String getDayByNow() {
        return LocalDate.now().plusDays(-1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
    /**
     * <p>Description: [获取T-1到月底还有多少天]</p>
     * Created on 2021/12/24
     * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
     * @version 1.0
     * @return long 到月底时间
     */
    public static long getDayToEndMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).toEpochDay() - LocalDate.now().plusDays(-1).toEpochDay();
    }

    /**
     * <p>Description: [获取本月天枢]</p>
     * Created on 2021/12/28
     * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
     * @version 1.0
     * @return long 本月天枢
     */
    public static Integer getDayByMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }

    /**
     * <p>Description: [获取当天日期]</p>
     * Created on 2021/12/26
     *
     * @return yyyyMMdd
     * @author <a href="mailto:wujiwei@camelotchina.com">仵继伟</a>
     * @version 1.0
     */
    public static Integer getTodayInt(){
        return Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }

    /**
     * offline 计提
     * @return Integer
     */
    public static Integer getOfflineFixedDays(){
        return getDayByMonth() - 5;
    }

}
