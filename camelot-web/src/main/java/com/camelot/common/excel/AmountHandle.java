package com.camelot.common.excel;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.camelot.common.util.AmountUtils;

/**
 * <p>Description: [excel导出自定义金额数据处理类]</p>
 * Created on 2021/12/26
 *
 * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
 * @version 1.0
 */
public class AmountHandle<T> extends ExcelDataHandlerDefaultImpl<T> {
    @Override
    public Object exportHandler(T obj, String name, Object value) {
        if (value instanceof Long) {
            value = AmountUtils.changeF2Y((Long) value);
        }
        return value;
    }
}
