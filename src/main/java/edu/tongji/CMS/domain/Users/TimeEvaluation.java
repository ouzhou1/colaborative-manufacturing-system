package edu.tongji.CMS.domain.Users;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "time_evaluation")
public class TimeEvaluation {
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

    @Column(name = "ontime_evaluation")
    @NotNull(message = "User name is required.")
    private Double ontimeEvaluation;

    @Column(name = "duration_evaluation")
    @NotNull(message = "User name is required.")
    private Double durationEvaluation;

    @Column(name = "online_evaluation")
    @NotNull(message = "User name is required.")
    private Double onlineEvaluation;

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

    public Double getOntimeEvaluation() {
        return ontimeEvaluation;
    }

    public void setOntimeEvaluation(Double ontimeEvaluation) {
        this.ontimeEvaluation = ontimeEvaluation;
    }

    public Double getDurationEvaluation() {
        return durationEvaluation;
    }

    public void setDurationEvaluation(Double durationEvaluation) {
        this.durationEvaluation = durationEvaluation;
    }

    public Double getOnlineEvaluation() {
        return onlineEvaluation;
    }

    public void setOnlineEvaluation(Double onlineEvaluation) {
        this.onlineEvaluation = onlineEvaluation;
    }

    public Double getTotalEvaluation() {
        return totalEvaluation;
    }

    public void setTotalEvaluation(Double totalEvaluation) {
        this.totalEvaluation = totalEvaluation;
    }
}
