/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.myfinance.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ghenet
 */
@Entity
@Table(name = "tbl_mycompany")
public class Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "CCNO")
    private String ccno;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 250)
    @Column(name = "FULLNAME")
    private String fullname;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 250)
    @Column(name = "EMAILID")
    private String emailid;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 250)
    @Column(name = "BILLINGADDRESS")
    private String billingaddress;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "PAIDTOVENDOR")
    private double paidtovendor;
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "PAIDTOMYCOMPANY")
    private double paidtomycompany;

    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public double getPaidtovendor() {
        return paidtovendor;
    }

    public void setPaidtovendor(double paidtovendor) {
        this.paidtovendor = paidtovendor;
    }

    public double getPaidtomycompany() {
        return paidtomycompany;
    }

    public void setPaidtomycompany(double paidtomycompany) {
        this.paidtomycompany = paidtomycompany;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finance)) {
            return false;
        }
        Finance other = (Finance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mum.ea.myfinance.domain.Finance[ id=" + id + " ]";
    }
    
}
