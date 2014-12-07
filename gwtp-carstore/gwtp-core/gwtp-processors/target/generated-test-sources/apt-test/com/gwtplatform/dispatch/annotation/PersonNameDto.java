package com.gwtplatform.dispatch.annotation;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PersonNameDto implements IsSerializable { 

  java.lang.String firstName;
  java.lang.String lastName;
  java.lang.String secondName;

  public static class Builder { 
    // Required parameters
    private final java.lang.String firstName;
    private final java.lang.String lastName;

    // Optional parameters - initialized to default values
    private java.lang.String secondName;

    public Builder(java.lang.String firstName, java.lang.String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public Builder secondName(java.lang.String secondName) {
      this.secondName = secondName;
      return this;
    }

    public PersonNameDto build() {
      return new PersonNameDto(this);
    }
  }

  protected PersonNameDto() {
    // Possibly for serialization.
  }

  public PersonNameDto(java.lang.String firstName, java.lang.String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  private PersonNameDto(Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.secondName = builder.secondName;
  }

  public java.lang.String getFirstName(){
    return firstName;
  }

  public java.lang.String getLastName(){
    return lastName;
  }

  public java.lang.String getSecondName(){
    return secondName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    PersonNameDto other = (PersonNameDto) obj;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (secondName == null) {
      if (other.secondName != null)
        return false;
    } else if (!secondName.equals(other.secondName))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (firstName == null ? 1 : firstName.hashCode());
    hashCode = (hashCode * 37) + (lastName == null ? 1 : lastName.hashCode());
    hashCode = (hashCode * 37) + (secondName == null ? 1 : secondName.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "PersonNameDto["
                 + firstName
                 + ","
                 + lastName
                 + ","
                 + secondName
    + "]";
  }
}
