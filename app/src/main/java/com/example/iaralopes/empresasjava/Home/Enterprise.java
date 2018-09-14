
package com.example.iaralopes.empresasjava.Home;

import android.databinding.ObservableField;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Enterprise {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email_enterprise")
    @Expose
    private Object emailEnterprise;
    @SerializedName("facebook")
    @Expose
    private Object facebook;
    @SerializedName("twitter")
    @Expose
    private Object twitter;
    @SerializedName("linkedin")
    @Expose
    private Object linkedin;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("own_enterprise")
    @Expose
    private Boolean ownEnterprise;
    @SerializedName("enterprise_name")
    @Expose
    private String enterpriseName;
    @SerializedName("photo")
    @Expose
    private Object photo;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("share_price")
    @Expose
    private Integer sharePrice;
    @SerializedName("enterprise_type")
    @Expose
    private EnterpriseType enterpriseType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Enterprise() {
    }

    /**
     * 
     * @param phone
     * @param linkedin
     * @param enterpriseName
     * @param emailEnterprise
     * @param photo
     * @param ownEnterprise
     * @param city
     * @param country
     * @param id
     * @param enterpriseType
     * @param twitter
     * @param sharePrice
     * @param description
     * @param facebook
     * @param value
     */
    public Enterprise(Integer id, Object emailEnterprise, Object facebook, Object twitter, Object linkedin, Object phone, Boolean ownEnterprise, String enterpriseName, Object photo, String description, String city, String country, Integer value, Integer sharePrice, EnterpriseType enterpriseType) {
        super();
        this.id = id;
        this.emailEnterprise = emailEnterprise;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedin = linkedin;
        this.phone = phone;
        this.ownEnterprise = ownEnterprise;
        this.enterpriseName = enterpriseName;
        this.photo = photo;
        this.description = description;
        this.city = city;
        this.country = country;
        this.value = value;
        this.sharePrice = sharePrice;
        this.enterpriseType = enterpriseType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getEmailEnterprise() {
        return emailEnterprise;
    }

    public void setEmailEnterprise(Object emailEnterprise) {
        this.emailEnterprise = emailEnterprise;
    }

    public Object getFacebook() {
        return facebook;
    }

    public void setFacebook(Object facebook) {
        this.facebook = facebook;
    }

    public Object getTwitter() {
        return twitter;
    }

    public void setTwitter(Object twitter) {
        this.twitter = twitter;
    }

    public Object getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(Object linkedin) {
        this.linkedin = linkedin;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Boolean getOwnEnterprise() {
        return ownEnterprise;
    }

    public void setOwnEnterprise(Boolean ownEnterprise) {
        this.ownEnterprise = ownEnterprise;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Integer sharePrice) {
        this.sharePrice = sharePrice;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("emailEnterprise", emailEnterprise).append("facebook", facebook).append("twitter", twitter).append("linkedin", linkedin).append("phone", phone).append("ownEnterprise", ownEnterprise).append("enterpriseName", enterpriseName).append("photo", photo).append("description", description).append("city", city).append("country", country).append("value", value).append("sharePrice", sharePrice).append("enterpriseType", enterpriseType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(phone).append(enterpriseName).append(linkedin).append(emailEnterprise).append(photo).append(country).append(city).append(ownEnterprise).append(id).append(enterpriseType).append(twitter).append(sharePrice).append(description).append(facebook).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Enterprise) == false) {
            return false;
        }
        Enterprise rhs = ((Enterprise) other);
        return new EqualsBuilder().append(phone, rhs.phone).append(enterpriseName, rhs.enterpriseName).append(linkedin, rhs.linkedin).append(emailEnterprise, rhs.emailEnterprise).append(photo, rhs.photo).append(country, rhs.country).append(city, rhs.city).append(ownEnterprise, rhs.ownEnterprise).append(id, rhs.id).append(enterpriseType, rhs.enterpriseType).append(twitter, rhs.twitter).append(sharePrice, rhs.sharePrice).append(description, rhs.description).append(facebook, rhs.facebook).append(value, rhs.value).isEquals();
    }

}
