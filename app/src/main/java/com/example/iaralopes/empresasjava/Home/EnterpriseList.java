package com.example.iaralopes.empresasjava.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class EnterpriseList {

    @SerializedName("enterprises")
    @Expose
    private List<Enterprise> enterprises = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public EnterpriseList() {
    }

    /**
     *
     * @param enterprises
     */
    public EnterpriseList(List<Enterprise> enterprises) {
        super();
        this.enterprises = enterprises;
    }

    public List<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(List<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("enterprises", enterprises).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(enterprises).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EnterpriseList) == false) {
            return false;
        }
        EnterpriseList rhs = ((EnterpriseList) other);
        return new EqualsBuilder().append(enterprises, rhs.enterprises).isEquals();
    }
}
