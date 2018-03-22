package edu.tongji.CMS.domain.Users;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "candidates")
public class Candidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "user_id")
    @NotNull(message = "User id is required.")
    private Long userId;

    @Column(name = "user_name")
    // @NotBlank(message = "User name is required.")
    private String userName;

    @Column(name = "service_id")
    @NotNull(message = "Service id is required.")
    private Long serviceId;

    @Column(name = "service_name")
    // @NotBlank(message = "Service name is required.")
    private String serviceName;

    @Column(name = "rate")
    @NotNull(message = "Rate is required.")
    private Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
