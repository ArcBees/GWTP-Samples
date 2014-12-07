package com.gwtplatform.dispatch.annotation;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class RetrieveFooAction implements Action<RetrieveFooResult> { 

  int fooId;
  java.lang.String additionalQuestion;

  public static class Builder { 
    // Required parameters
    private final int fooId;

    // Optional parameters - initialized to default values
    private java.lang.String additionalQuestion;

    public Builder(int fooId) {
      this.fooId = fooId;
    }

    public Builder additionalQuestion(java.lang.String additionalQuestion) {
      this.additionalQuestion = additionalQuestion;
      return this;
    }

    public RetrieveFooAction build() {
      return new RetrieveFooAction(this);
    }
  }

  protected RetrieveFooAction() {
    // Possibly for serialization.
  }

  public RetrieveFooAction(int fooId) {
    this.fooId = fooId;
  }

  private RetrieveFooAction(Builder builder) {
    this.fooId = builder.fooId;
    this.additionalQuestion = builder.additionalQuestion;
  }

  @Override
  public String getServiceName() {
    return Action.DEFAULT_SERVICE_NAME + "RetrieveFoo";
  }

  @Override
  public boolean isSecured() {
    return true;
  }

  public int getFooId(){
    return fooId;
  }

  public java.lang.String getAdditionalQuestion(){
    return additionalQuestion;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    RetrieveFooAction other = (RetrieveFooAction) obj;
    if (fooId != other.fooId)
        return false;
    if (additionalQuestion == null) {
      if (other.additionalQuestion != null)
        return false;
    } else if (!additionalQuestion.equals(other.additionalQuestion))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Integer(fooId).hashCode();
    hashCode = (hashCode * 37) + (additionalQuestion == null ? 1 : additionalQuestion.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "RetrieveFooAction["
                 + fooId
                 + ","
                 + additionalQuestion
    + "]";
  }
}
