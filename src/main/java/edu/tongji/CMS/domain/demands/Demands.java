package edu.tongji.CMS.domain.demands;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author ouzhou
 */

@Entity
@Table(name = "demands")
public class Demands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demand_id")
    private Long demandId;

    @Column(name = "demand_name")
    @NotEmpty(message = "Demand name is required.")
    private String demandName;

    @Column(name = "related_order_id")
    @NotEmpty(message = "Belonged order id is required.")
    private String relatedOrderId;

    @Column(name = "related_order_name")
    @NotEmpty(message = "Belonged order name is required.")
    private String relatedOrderName;

    @Column(name = "publish_time")
    @NotEmpty(message = "Publish time is required.")
    private Date publishTime;

    @Column(name = "status")
    @NotEmpty(message = "Status is required.")
    private String status;

    @Column(name = "mapped_service_id")
    private String mappedServiceId;

    @Column(name = "mapped_service_name")
    private String mappedServiceName;

    @Column(name = "related_field")
    @NotEmpty(message = "Field is required.")
    private String relatedField;

    @Column(name = "delivery_date")
    @NotEmpty(message = "Delivery date is required.")
    private Date deliveryDate;

    @Column(name = "description")
    @NotEmpty(message = "A detailed description is required.")
    private String description;

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getRelatedOrderId() {
        return relatedOrderId;
    }

    public void setRelatedOrderId(String relatedOrderId) {
        this.relatedOrderId = relatedOrderId;
    }

    public String getRelatedOrderName() {
        return relatedOrderName;
    }

    public void setRelatedOrderName(String relatedOrderName) {
        this.relatedOrderName = relatedOrderName;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMappedServiceId() {
        return mappedServiceId;
    }

    public void setMappedServiceId(String mappedServiceId) {
        this.mappedServiceId = mappedServiceId;
    }

    public String getMappedServiceName() {
        return mappedServiceName;
    }

    public void setMappedServiceName(String mappedServiceName) {
        this.mappedServiceName = mappedServiceName;
    }

    public String getRelatedField() {
        return relatedField;
    }

    public void setRelatedField(String relatedField) {
        this.relatedField = relatedField;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
