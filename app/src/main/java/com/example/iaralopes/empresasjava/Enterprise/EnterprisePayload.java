package com.example.iaralopes.empresasjava.Enterprise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EnterprisePayload {

    @SerializedName("enterprise")
    @Expose
    private Enterprise enterprise;
    @SerializedName("success")
    @Expose
    private Boolean success;

    /**
     * No args constructor for use in serialization
     */
    public EnterprisePayload() {
    }

    /**
     * @param enterprise
     * @param success
     */
    public EnterprisePayload(Enterprise enterprise, Boolean success) {
        super();
        this.enterprise = enterprise;
        this.success = success;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("enterprise", enterprise).append("success", success).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(enterprise).append(success).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EnterprisePayload) == false) {
            return false;
        }
        EnterprisePayload rhs = ((EnterprisePayload) other);
        return new EqualsBuilder().append(enterprise, rhs.enterprise).append(success, rhs.success).isEquals();

    }

}