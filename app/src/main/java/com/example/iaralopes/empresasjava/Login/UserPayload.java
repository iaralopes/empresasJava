package com.example.iaralopes.empresasjava.Login;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserPayload {

    @SerializedName("investor")
    @Expose
    private Investor investor;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserPayload() {
    }

    /**
     *
     * @param investor
     */
    public UserPayload(Investor investor) {
        super();
        this.investor = investor;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("investor", investor).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(investor).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserPayload) == false) {
            return false;
        }
        UserPayload rhs = ((UserPayload) other);
        return new EqualsBuilder().append(investor, rhs.investor).isEquals();
    }

}
