package edu.tongji.CMS.domain.demands;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class DemandOrderBinding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "demand_id")
    @NotNull(message = "Demand id is required.")
    private Long serviceId;

    @Column(name = "order_id")
    @NotNull(message = "Order id is required.")
    private Long orderId;

    @Column(name = "status")
    @NotBlank(message = "Status is required.")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
