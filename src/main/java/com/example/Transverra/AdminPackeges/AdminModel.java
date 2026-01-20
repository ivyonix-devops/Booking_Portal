package com.example.Transverra.AdminPackeges;

import jakarta.persistence.*;

@Entity
@Table (name = "admin")
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer admin_id;
    @Column(name = "adm_name")
    private String admName;
    private String adm_mail;
    private String adm_password;

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdm_mail() {
        return adm_mail;
    }

    public void setAdm_mail(String adm_mail) {
        this.adm_mail = adm_mail;
    }

    public String getAdm_password() {
        return adm_password;
    }

    public void setAdm_password(String adm_password) {
        this.adm_password = adm_password;
    }

    public AdminModel() {
    }


}
