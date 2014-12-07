package com.gwtplatform.dispatch.annotation.proxy;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;

@ProxyFor(value = com.gwtplatform.dispatch.annotation.Employee.class, locator = com.gwtplatform.dispatch.annotation.EmployeeLocator.class)
public interface EmployeeProxy extends EntityProxy { 

  EntityProxyId<EmployeeProxy> stableId();

  java.lang.String getDisplayName();

  java.lang.Long getSupervisorKey();

  java.lang.Long getId();

  java.util.ArrayList<com.gwtplatform.dispatch.annotation.DetailProxy> getDetails();

  com.gwtplatform.dispatch.annotation.proxy.EmployeeProxy getSupervisor();

  void setDisplayName(java.lang.String displayName);

  void setSupervisorKey(java.lang.Long supervisorKey);

  void setVersion(java.lang.Integer version);

  void setDetails(java.util.ArrayList<com.gwtplatform.dispatch.annotation.DetailProxy> details);

  void setSupervisor(com.gwtplatform.dispatch.annotation.proxy.EmployeeProxy supervisor);

}
