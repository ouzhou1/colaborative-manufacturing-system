package edu.tongji.CMS.domain.Services;

import edu.tongji.CMS.domain.vo.BindingStatus;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * @author ouzhou
 */

@Entity
@Table(name = "order_service_binding")
public class ServiceOrderBinding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "binding_id")
    private Long bindingId;

    @Column(name = "service_id")
    //@NotEmpty(message = "Service id is required.")
    private Long serviceId;

    @Column(name = "order_id")
    //@NotEmpty(message = "Order id is required.")
    private Long orderId;

    @Column(name = "status")
    //@NotEmpty(message = "Status is required.")
    private String status;

    public Long getBindingId() {
        return bindingId;
    }

    public void setBindingId(Long bindingId) {
        this.bindingId = bindingId;
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
