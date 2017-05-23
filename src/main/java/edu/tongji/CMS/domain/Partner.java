package edu.tongji.CMS.domain;

import javax.persistence.*;

/**
 * Created by ouzhou on 2017/5/23.
 */
@Entity
@Table(name = "partners")
public class Partner {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "partner_id")
        private Long parter_id;

        public Long getParter_id() {
                return parter_id;
        }

        public void setParter_id(Long parter_id) {
                this.parter_id = parter_id;
        }
}
