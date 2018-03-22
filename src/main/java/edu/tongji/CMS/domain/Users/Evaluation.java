package edu.tongji.CMS.domain.Users;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "evaluation")
public class Evaluation {

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

    @Column(name = "time_evaluation")
    @NotNull(message = "User name is required.")
    private Double timeEvaluation;

    @Column(name = "quality_evaluation")
    @NotNull(message = "User name is required.")
    private Double qualityEvaluation;

    @Column(name = "ability_evaluation")
    @NotNull(message = "User name is required.")
    private Double abilityEvaluation;

    @Column(name = "service_evaluation")
    @NotNull(message = "User name is required.")
    private Double serviceEvaluation;

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

    public Double getTimeEvaluation() {
        return timeEvaluation;
    }

    public void setTimeEvaluation(Double timeEvaluation) {
        this.timeEvaluation = timeEvaluation;
    }

    public Double getQualityEvaluation() {
        return qualityEvaluation;
    }

    public void setQualityEvaluation(Double qualityEvaluation) {
        this.qualityEvaluation = qualityEvaluation;
    }

    public Double getAbilityEvaluation() {
        return abilityEvaluation;
    }

    public void setAbilityEvaluation(Double abilityEvaluation) {
        this.abilityEvaluation = abilityEvaluation;
    }

    public Double getServiceEvaluation() {
        return serviceEvaluation;
    }

    public void setServiceEvaluation(Double serviceEvaluation) {
        this.serviceEvaluation = serviceEvaluation;
    }

    public Double getTotalEvaluation() {
        return totalEvaluation;
    }

    public void setTotalEvaluation(Double totalEvaluation) {
        this.totalEvaluation = totalEvaluation;
    }
}
