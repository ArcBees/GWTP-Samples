package com.gwtplatform.dispatch.annotation.proxy;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(com.gwtplatform.dispatch.annotation.Address.class)
public interface AddressProxy extends ValueProxy { 

  java.lang.String getStreet();

  void setStreet(java.lang.String street);

}
