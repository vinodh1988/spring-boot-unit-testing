package com.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Store {
  @Id
  private Integer storeID;
  @Column
  private String name;
public Integer getStoreID() {
	return storeID;
}
public void setStoreID(Integer storeID) {
	this.storeID = storeID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
  
}
