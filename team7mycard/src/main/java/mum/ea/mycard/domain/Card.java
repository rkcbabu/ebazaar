/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.ea.mycard.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chaulagai
 */
@Entity
@Table(name = "tbl_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findByCcno", query = "SELECT c FROM Card c WHERE c.ccno = :ccno"),
    @NamedQuery(name = "Card.findByExptdate", query = "SELECT c FROM Card c WHERE c.exptdate = :exptdate"),
    @NamedQuery(name = "Card.findByCvvno", query = "SELECT c FROM Card c WHERE c.cvvno = :cvvno"),
    @NamedQuery(name = "Card.findByAvailablebalance", query = "SELECT c FROM Card c WHERE c.availablebalance = :availablebalance"),
    @NamedQuery(name = "Card.findByTotalbalance", query = "SELECT c FROM Card c WHERE c.totalbalance = :totalbalance"),
    @NamedQuery(name = "Card.findByCardtype", query = "SELECT c FROM Card c WHERE c.cardtype = :cardtype")})
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CCNO")
    private String ccno;
    @Temporal(TemporalType.DATE)
    private Date exptdate;
    private String cvvno;
    private double availablebalance;
    private double totalbalance;
    private String cardtype;

    public Card() {
    }

    public Card(String ccno) {
        this.ccno = ccno;
    }

    public Card(String ccno, Date exptdate, String cvvno, double availablebalance, double totalbalance, String cardtype) {
        this.ccno = ccno;
        this.exptdate = exptdate;
        this.cvvno = cvvno;
        this.availablebalance = availablebalance;
        this.totalbalance = totalbalance;
        this.cardtype = cardtype;
    }

    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
    }

    public Date getExptdate() {
        return exptdate;
    }

    public void setExptdate(Date exptdate) {
        this.exptdate = exptdate;
    }

    public String getCvvno() {
        return cvvno;
    }

    public void setCvvno(String cvvno) {
        this.cvvno = cvvno;
    }

    public double getAvailablebalance() {
        return availablebalance;
    }

    public void setAvailablebalance(double availablebalance) {
        this.availablebalance = availablebalance;
    }

    public double getTotalbalance() {
        return totalbalance;
    }

    public void setTotalbalance(double totalbalance) {
        this.totalbalance = totalbalance;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
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
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.ccno == null && other.ccno != null) || (this.ccno != null && !this.ccno.equals(other.ccno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mum.ea.webservice.Card[ ccno=" + ccno + " ]";
    }
    
}
