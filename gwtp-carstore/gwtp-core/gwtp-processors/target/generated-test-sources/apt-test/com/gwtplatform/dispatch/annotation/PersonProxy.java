package com.gwtplatform.dispatch.annotation;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;

@ProxyFor(com.gwtplatform.dispatch.annotation.Person.class)
public interface PersonProxy extends EntityProxy { 

  EntityProxyId<PersonProxy> stableId();

  int getId();

  java.lang.Long getAge();

  float getWeight();

  com.gwtplatform.dispatch.annotation.proxy.AddressProxy getAddressDetail();

  com.gwtplatform.dispatch.annotation.DetailProxy getDetail();

  java.util.Set<com.gwtplatform.dispatch.annotation.DetailProxy> getDetails();

  void setId(int id);

  void setAge(java.lang.Long age);

  void setWeight(float weight);

  void setAddressDetail(com.gwtplatform.dispatch.annotation.proxy.AddressProxy addressDetail);

  void setDetail(com.gwtplatform.dispatch.annotation.DetailProxy detail);

  void setDetails(java.util.Set<com.gwtplatform.dispatch.annotation.DetailProxy> details);

}
