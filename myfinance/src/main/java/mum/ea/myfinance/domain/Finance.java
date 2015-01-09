/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.myfinance.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chaulagai
 */
@Entity
@Table(name = "tbl_mycompany")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Finance.findAll", query = "SELECT f FROM Finance f"),
//    @NamedQuery(name = "Finance.findByCcno", query = "SELECT f FROM Finance f WHERE f.ccno = :ccno"),
//    @NamedQuery(name = "Finance.findByFullname", query = "SELECT f FROM Finance f WHERE f.fullname = :fullname"),
//    @NamedQuery(name = "Finance.findByEmailid", query = "SELECT f FROM Finance f WHERE f.emailid = :emailid"),
//    @NamedQuery(name = "Finance.findByBillingaddress", query = "SELECT f FROM Finance f WHERE f.billingaddress = :billingaddress"),
//    @NamedQuery(name = "Finance.findByPaidtovendor", query = "SELECT f FROM Finance f WHERE f.paidtovendor = :paidtovendor"),
//    @NamedQuery(name = "Finance.findByPaidtomycompany", query = "SELECT f FROM Finance f WHERE f.paidtomycompany = :paidtomycompany")})
public class Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 250)
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

//    public Finance() {
//    }
//
//    public Finance(String ccno) {
//        this.ccno = ccno;
//    }

//    public Finance(String ccno, String fullname, String emailid, String billingaddress, double paidtovendor, double paidtomycompany) {
//        this.ccno = ccno;
//        this.fullname = fullname;
//        this.emailid = emailid;
//        this.billingaddress = billingaddress;
//        this.paidtovendor = paidtovendor;
//        this.paidtomycompany = paidtomycompany;
//    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccno != null ? ccno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finance)) {
            return false;
        }
        Finance other = (Finance) object;
        if ((this.ccno == null && other.ccno != null) || (this.ccno != null && !this.ccno.equals(other.ccno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mum.ea.webservice.Finance[ ccno=" + ccno + " ]";
    }
    
}
