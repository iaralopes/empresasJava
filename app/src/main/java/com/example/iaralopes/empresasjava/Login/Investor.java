package com.example.iaralopes.empresasjava.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;



public class Investor {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("investor_name")
    @Expose
    private String investorName;
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * No args constructor for use in serialization
     *
     */
    public Investor() {
    }

    /**
     *
     * @param id
     * @param email
     * @param investorName
     */
    public Investor(Integer id, String investorName, String email) {
        super();
        this.id = id;
        this.investorName = investorName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("investorName", investorName).append("email", email).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(email).append(investorName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Investor) == false) {
            return false;
        }
        Investor rhs = ((Investor) other);
        return new EqualsBuilder().append(id, rhs.id).append(email, rhs.email).append(investorName, rhs.investorName).isEquals();
    }

}
