package edu.tongji.CMS.domain;

import edu.tongji.CMS.domain.vo.UserLevel;
import edu.tongji.CMS.domain.vo.UserType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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
    @NotEmpty(message = "Partner or user id is required!")
    private Long parter_id;

    @Column
    @NotEmpty(message = "Partner or user name is required!")
    private String partner_name;

    @Column
    @NotEmpty(message = "Partner contact is required!")
    private String tel;

    @Column
    @NotEmpty(message = "Sub order id that partner or user belongs is required!")
    private String sub_order_id;

    @Column
    @NotEmpty(message = "Sub order name that partner or user belongs is required!")
    private String sub_order_name;

    @Column
    @NotEmpty(message = "Partner's role is required!")
    private String role;

    @Column
    @NotEmpty(message = "Partner type is required!")
    private UserType type;

    @Column
    @NotEmpty(message = "Partner or user level is required!")
    private UserLevel level;

    @Column
    @NotEmpty(message = "The date that partner or user create is required!")
    private Date create_time;

    @Column
    private String mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParter_id() {
        return parter_id;
    }

    public void setParter_id(Long parter_id) {
        this.parter_id = parter_id;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSub_order_id() {
        return sub_order_id;
    }

    public void setSub_order_id(String sub_order_id) {
        this.sub_order_id = sub_order_id;
    }

    public String getSub_order_name() {
        return sub_order_name;
    }

    public void setSub_order_name(String sub_order_name) {
        this.sub_order_name = sub_order_name;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
