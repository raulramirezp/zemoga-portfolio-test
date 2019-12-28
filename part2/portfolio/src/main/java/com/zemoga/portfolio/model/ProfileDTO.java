package com.zemoga.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfileDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int profileID;
    private String profileImageUrl;
    private String profileName;
    private String profileDescription;

    public ProfileDTO() {
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append("profileImageUrl" + getProfileImageUrl()+",");
        stringBuilder.append("profileName" + getProfileName()+",");
        stringBuilder.append("profileDescription" + getProfileDescription()+",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
