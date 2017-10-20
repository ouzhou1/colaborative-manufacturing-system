package edu.tongji.CMS.domain.order;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "sub_orders")
public class SubOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_order_id")
    private Long subOrderId;

    @Column(name = "sub_order_name")
    @NotEmpty(message = "Sub order name is required.")
    private String subOrderName;

    @Column(name = "parent_order_id")
    @NotEmpty(message = "Parent order id is required.")
    private Long parentOrderId;

    @Column(name = "parent_order_name")
    @NotEmpty(message = "Parent order name is required.")
    private String parentOrderName;

    @Column(name = "sub_order_status")
    @NotEmpty(message = "Sub order status is required.")
    private String subOrderStatus;

    @Column(name = "delivery_date")
    @NotEmpty(message = "Delivery date is required.")
    private String deliberyDate;

    public Long getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getSubOrderName() {
        return subOrderName;
    }

    public void setSubOrderName(String subOrderName) {
        this.subOrderName = subOrderName;
    }

    public Long getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(Long parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public String getParentOrderName() {
        return parentOrderName;
    }

    public void setParentOrderName(String parentOrderName) {
        this.parentOrderName = parentOrderName;
    }

    public String getSubOrderStatus() {
        return subOrderStatus;
    }

    public void setSubOrderStatus(String subOrderStatus) {
        this.subOrderStatus = subOrderStatus;
    }

    public String getDeliberyDate() {
        return deliberyDate;
    }

    public void setDeliberyDate(String deliberyDate) {
        this.deliberyDate = deliberyDate;
    }
}
