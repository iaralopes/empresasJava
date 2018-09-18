
package com.example.iaralopes.empresasjava.Enterprise;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EnterpriseType {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("enterprise_type_name")
    @Expose
    private String enterpriseTypeName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnterpriseType() {
    }

    /**
     * 
     * @param id
     * @param enterpriseTypeName
     */
    public EnterpriseType(Integer id, String enterpriseTypeName) {
        super();
        this.id = id;
        this.enterpriseTypeName = enterpriseTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }

    public void setEnterpriseTypeName(String enterpriseTypeName) {
        this.enterpriseTypeName = enterpriseTypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("enterpriseTypeName", enterpriseTypeName).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(enterpriseTypeName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EnterpriseType) == false) {
            return false;
        }
        EnterpriseType rhs = ((EnterpriseType) other);
        return new EqualsBuilder().append(id, rhs.id).append(enterpriseTypeName, rhs.enterpriseTypeName).isEquals();
    }

}
