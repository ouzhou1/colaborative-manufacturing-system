package edu.tongji.CMS.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ouzhou on 2017/5/23.
 */
@Data
@Entity
@Table(name = "partners")
public class Partner {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "partner_id")
        private Long parter_id;

}
