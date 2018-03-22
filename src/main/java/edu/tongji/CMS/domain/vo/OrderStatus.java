package edu.tongji.CMS.domain.vo;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

/**
 * Created by zhouou on 2017/5/24.
 */
public enum OrderStatus {
    WAITING, ESTABLISHED, PROCESSING, FINISHED, CANCELLED;

    @Override
    public String toString() {
        return super.toString();
    }

    public static OrderStatus generateByString(String orderStatus) {
        if (StringUtils.isNotBlank(orderStatus)) {
            if ("waiting".equalsIgnoreCase(orderStatus)) {
                return OrderStatus.WAITING;
            } else if ("established".equalsIgnoreCase(orderStatus)) {
                return OrderStatus.ESTABLISHED;
            } else if ("processing".equalsIgnoreCase(orderStatus)) {
                return OrderStatus.PROCESSING;
            } else if ("finished".equalsIgnoreCase(orderStatus)) {
                return OrderStatus.FINISHED;
            } else {
                return OrderStatus.CANCELLED;
            }
        } else {
            return null;
        }
    }
}
