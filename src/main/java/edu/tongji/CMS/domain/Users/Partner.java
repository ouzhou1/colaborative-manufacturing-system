package edu.tongji.CMS.domain.Users;

import edu.tongji.CMS.domain.vo.UserLevel;
import edu.tongji.CMS.domain.vo.UserType;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ouzhou on 2017/5/23.
 */
@Entity
@Table(name = "partners")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    @NotNull(message = "Partner or user id is required!")
    private Long userId;

    @Column
    @NotBlank(message = "Partner or user name is required!")
    private String userName;

    @Column
    // @NotEmpty(message = "Sub order id that partner or user belongs is required!")
    private String subOrderId;

    @Column
    // @NotEmpty(message = "Sub order name that partner or user belongs is required!")
    private String subOrderName;

    @Column
    // @NotEmpty(message = "Partner's role is required!")
    private String role;

    @Column
    // @NotEmpty(message = "Partner type is required!")
    private UserType type;

    @Column
    //@NotEmpty(message = "Partner or user level is required!")
    private UserLevel level;

    @Column
    @Temporal(TemporalType.DATE)
    @NotNull(message = "The date that partner or user create is required!")
    private Date createTime;

    @Column
    @NotBlank(message = "The date that partner or user create is required!")
    private String status;

    @Column
    private String mark;

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

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getSubOrderName() {
        return subOrderName;
    }

    public void setSubOrderName(String subOrderName) {
        this.subOrderName = subOrderName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
