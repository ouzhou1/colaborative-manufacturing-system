package edu.tongji.CMS.domain.Users;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ability_evaluation")
public class AbilityEvaluation {
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

    @Column(name = "manufacturing_evaluation")
    @NotNull(message = "User name is required.")
    private Double manufacturingEvaluation;

    @Column(name = "service_evaluation")
    @NotNull(message = "User name is required.")
    private Double serviceEvaluation;

    @Column(name = "infrastructure_evaluation")
    @NotNull(message = "User name is required.")
    private Double infrastructureEvaluation;

    @Column(name = "establishment_evaluation")
    @NotNull(message = "User name is required.")
    private Double establishmentEvaluation;

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

    public Double getManufacturingEvaluation() {
        return manufacturingEvaluation;
    }

    public void setManufacturingEvaluation(Double manufacturingEvaluation) {
        this.manufacturingEvaluation = manufacturingEvaluation;
    }

    public Double getServiceEvaluation() {
        return serviceEvaluation;
    }

    public void setServiceEvaluation(Double serviceEvaluation) {
        this.serviceEvaluation = serviceEvaluation;
    }

    public Double getInfrastructureEvaluation() {
        return infrastructureEvaluation;
    }

    public void setInfrastructureEvaluation(Double infrastructureEvaluation) {
        this.infrastructureEvaluation = infrastructureEvaluation;
    }

    public Double getEstablishmentEvaluation() {
        return establishmentEvaluation;
    }

    public void setEstablishmentEvaluation(Double establishmentEvaluation) {
        this.establishmentEvaluation = establishmentEvaluation;
    }

    public Double getTotalEvaluation() {
        return totalEvaluation;
    }

    public void setTotalEvaluation(Double totalEvaluation) {
        this.totalEvaluation = totalEvaluation;
    }
}
