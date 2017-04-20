package com.givenchdy.cvbuilder.cvbuilder.Models;

/**
 * Created by Given Mojapelo on 3/25/2017.
 */

public class ReferencesModel {

    private String referenceName;
    private String cellNo;
    private String emailAddress;
    private String relationship;

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
