package com.camelot.core.example.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: config_miads
 * @Author: sunshaobo
 * @Date: 2021-12-16
 * @Version: V1.0
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ExampleVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * 一级dsp
     */
    @Excel(name = "一级DSP", width = 15)
    private String dspLevel1;
    /**
     * 收入计提编号
     */
    @Excel(name = "计提编号", width = 15)
    private String accrualNo;
    /**
     * 账户ID
     */
    @Excel(name = "账户ID", width = 15)
    private String accountId;
    /**
     * 二级dsp
     */
    @Excel(name = "二级DSP", width = 15)
    private String dspLevel2;
    /**
     * 结算币种
     */
    @Excel(name = "结算币种", width = 15)
    private String settlementCurrency;
    /**
     * AM
     */
    @Excel(name = "AM", width = 15)
    private String am;
    /**
     * 计提人
     */
    @Excel(name = "计提人", width = 15)
    @NotNull
    private String accrualBy;
}
