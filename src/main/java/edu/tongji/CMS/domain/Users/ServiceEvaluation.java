package edu.tongji.CMS.domain.Users;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "service_evaluation")
public class ServiceEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "user_id")
    @NotNull(message = "User id is required.")
    private Long userId;

    @Column(name = "user_name")
    @NotBlank(message = "User name is required.")
    private String userName;

    @Column(name = "service_attitude_evaluation")
    @NotNull(message = "User name is required.")
    private Double serviceAttitudeEvaluation;

    @Column(name = "product_evaluation")
    @NotNull(message = "User name is required.")
    private Double productEvaluation;

    @Column(name = "total_evaluation")
    @NotNull(message = "User name is required.")
    private Double totalEvaluation;

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

    public Double getServiceAttitudeEvaluation() {
        return serviceAttitudeEvaluation;
    }

    public void setServiceAttitudeEvaluation(Double serviceAttitudeEvaluation) {
        this.serviceAttitudeEvaluation = serviceAttitudeEvaluation;
    }

    public Double getProductEvaluation() {
        return productEvaluation;
    }

    public void setProductEvaluation(Double productEvaluation) {
        this.productEvaluation = productEvaluation;
    }

    public Double getTotalEvaluation() {
        return totalEvaluation;
    }

    public void setTotalEvaluation(Double totalEvaluation) {
        this.totalEvaluation = totalEvaluation;
    }
}
