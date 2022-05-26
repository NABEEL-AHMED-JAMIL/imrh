package com.barco.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "USER_VERIFICATION")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVerification extends BaseEntity {

    @GenericGenerator(
        name = "userVerificationGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "USER_VERIFICATION_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "userVerificationGenerator")
    @Column(name="USER_VERIFICATION_ID", unique=true, nullable=false)
    private Long userVerificationId;

    @Column(name="TOKEN", nullable=false)
    private String token;

    @Column(name="EXPIRE_DATE", nullable=false)
    private Timestamp expiryDate;

    @Column(name="IS_CONSUMED", nullable=false)
    private Boolean isConsumed;

    @Column(name="VERIFICATION_TYPE", nullable=false)
    private String verificationType;

    @Lob
    private String payload;

    @Embedded
    private BaseMasterEntity baseMasterEntity;

    public UserVerification() { }

    public UserVerification(String enabled, Long userVerificationId, String token, Timestamp expiryDate,
        Boolean isConsumed, String verificationType, String payload,
        BaseMasterEntity baseMasterEntity) {
        super(enabled);
        this.userVerificationId = userVerificationId;
        this.token = token;
        this.expiryDate = expiryDate;
        this.isConsumed = isConsumed;
        this.verificationType = verificationType;
        this.payload = payload;
        this.baseMasterEntity = baseMasterEntity;
    }

    public Long getUserVerificationId() {
        return userVerificationId;
    }

    public void setUserVerificationId(Long userVerificationId) {
        this.userVerificationId = userVerificationId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getConsumed() {
        return isConsumed;
    }

    public void setConsumed(Boolean consumed) {
        isConsumed = consumed;
    }

    public String getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(String verificationType) {
        this.verificationType = verificationType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public BaseMasterEntity getBaseMasterEntity() {
        return baseMasterEntity;
    }

    public void setBaseMasterEntity(BaseMasterEntity baseMasterEntity) {
        this.baseMasterEntity = baseMasterEntity;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
