package com.camelot.common.util;


import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <p>Description: [金额数字类型转换]</p>
 * Created on 2021/12/26
 *
 * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
 * @version 1.0
 */
public class AmountUtils {

    /**
     * 金额为分的格式
     */
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

    /**
     * 将分为单位的转换为元 （除100）
     *
     * @param amount
     * @return
     */
    public static String changeF2Y(Long amount) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(BigDecimal.valueOf(amount).divide(new BigDecimal(100)));
    }


    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount
     * @return
     */
    public static String changeY2F(Long amount) {
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
    }

    /**
     * <p>Description: [乘法，保留两位小数 四舍五入]</p>
     *
     * @param amount 金额
     * @param ratio  系数
     * @return
     */
    public static Long multiply(Long amount, String ratio) {
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(ratio)).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }

    /**
     * 计提根据实际收入计算预计收入
     *
     * @param amount     实际收入
     * @param day        实际收入天数
     * @param dayByMonth 当月天数
     * @return
     */
    public static Long getExFee(Long amount, Integer day, Integer dayByMonth) {
        return BigDecimal.valueOf(amount).divide(new BigDecimal(day), 10, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(dayByMonth)).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }

    /**
     * 计提根据修改预收入计算预计收入
     *
     * @param upFee    修改的预收入
     * @param oriFee   原总收入
     * @param mediaFee 媒体收入
     * @return
     */
    public static Long getExFeeByUp(Long upFee, Long oriFee, Long mediaFee) {
        return BigDecimal.valueOf(mediaFee).divide(new BigDecimal(oriFee), 10, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(upFee)).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }
}
