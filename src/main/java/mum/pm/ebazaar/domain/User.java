/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Ram
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
//    @NotEmpty(message = "Please enter your firstName.")
//    @Size(min=2, max=10,message = "Your firstName must between 2 and 10 characters")
    private String firstName;
    
//    @NotEmpty(message = "Please enter your Last Name.")
//    @Size(min=2, max=10,message = "plz enter correct")
//    @Pattern(regexp="[a-zA-Z]")
    private String lastName;
    
//    @NotEmpty(message = "Please enter your username.")
//    @Size(min=2, max = 15,  message = "Your username must between 6 and 15 characters")
//    @Pattern(regexp ="[a-zA-Z0-9]")
    private String username; 
   
    
//    @NotEmpty(message = "Please enter your password.")
//    @Size(min = 6, message = "Your password must between 6 and 15 characters")
    private String password; 
    
    
    private boolean enabled; 
    private String role; 
    
    @Embedded
    @Valid
    private Address address;
    
//    @Pattern(regexp ="[0-9]")
    @Size(min = 10, max = 10, message = "Your phone number must be of 10 digits")
    private String phone;
    
    @NotEmpty(message = "Please enter your email address")
    @Email
    private String email;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
   
//    @OneToOne
//    private Credential credential;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mum.pm.ebazaar.domain.User[ id=" + id+" - enabled"+enabled + " ]";
    }

}
