package edu.tongji.CMS.domain.Users;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quality_evaluation")
public class QualityEvaluation {
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

    @Column(name = "function_evaluation")
    @NotNull(message = "User name is required.")
    private Double functionEvaluation;

    @Column(name = "secure_evaluation")
    @NotNull(message = "User name is required.")
    private Double secureEvaluation;

    @Column(name = "stability_evaluation")
    @NotNull(message = "User name is required.")
    private Double stabilityEvaluation;

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

    public Double getFunctionEvaluation() {
        return functionEvaluation;
    }

    public void setFunctionEvaluation(Double functionEvaluation) {
        this.functionEvaluation = functionEvaluation;
    }

    public Double getSecureEvaluation() {
        return secureEvaluation;
    }

    public void setSecureEvaluation(Double secureEvaluation) {
        this.secureEvaluation = secureEvaluation;
    }

    public Double getStabilityEvaluation() {
        return stabilityEvaluation;
    }

    public void setStabilityEvaluation(Double stabilityEvaluation) {
        this.stabilityEvaluation = stabilityEvaluation;
    }

    public Double getTotalEvaluation() {
        return totalEvaluation;
    }

    public void setTotalEvaluation(Double totalEvaluation) {
        this.totalEvaluation = totalEvaluation;
    }
}
