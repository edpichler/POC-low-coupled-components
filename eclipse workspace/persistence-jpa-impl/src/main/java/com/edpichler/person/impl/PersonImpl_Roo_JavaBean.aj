// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.edpichler.person.impl;

import com.edpichler.address.Address;
import com.edpichler.person.CivilStatus;
import com.edpichler.person.Contact;
import com.edpichler.person.impl.PersonImpl;
import java.util.List;

privileged aspect PersonImpl_Roo_JavaBean {
    
    public Long PersonImpl.getId() {
        return this.id;
    }
    
    public void PersonImpl.setId(Long id) {
        this.id = id;
    }
    
    public String PersonImpl.getName() {
        return this.name;
    }
    
    public void PersonImpl.setName(String name) {
        this.name = name;
    }
    
    public String PersonImpl.getJob() {
        return this.job;
    }
    
    public void PersonImpl.setJob(String job) {
        this.job = job;
    }
    
    public String PersonImpl.getLastName() {
        return this.lastName;
    }
    
    public void PersonImpl.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String PersonImpl.getEmail() {
        return this.email;
    }
    
    public void PersonImpl.setEmail(String email) {
        this.email = email;
    }
    
    public Address PersonImpl.getAddress() {
        return this.address;
    }
    
    public void PersonImpl.setAddress(Address address) {
        this.address = address;
    }
    
    public List<Contact> PersonImpl.getContacts() {
        return this.contacts;
    }
    
    public void PersonImpl.setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public CivilStatus PersonImpl.getCivilStatus() {
        return this.civilStatus;
    }
    
    public void PersonImpl.setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }
    
}
