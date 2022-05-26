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
@Table(name = "APP_USER_NOTIFICATION")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserNotification extends BaseEntity {

    @GenericGenerator(
        name = "appUserNotificationGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "APP_USER_NOTIFICATION_MESSAGE_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "appUserNotificationGenerator")
    @Column(name="APP_USER_NOTIFICATION_ID", unique=true, nullable=false)
    private Long appUserNotificationMessageId;

    @Column(name="APP_USER_ID", nullable=false)
    private Long appUserId;

    @Embedded
    private BaseMasterEntity baseMasterEntity;

    @Column(name="ACTION")
    private String action;

    @Column(name="SUBJECT")
    private String subject;

    @Column(name="MESSAGE")
    private String message;

    @Column(name = "EXPIRY_AT")
    private Timestamp expiryAt;

    @Column(name="STATUS")
    private String status;

    public AppUserNotification() {}

    public AppUserNotification(Long appUserId, BaseMasterEntity baseMasterEntity,
        String action, String subject, String message, Timestamp expiryAt, String status) {
        this.appUserId = appUserId;
        this.baseMasterEntity = baseMasterEntity;
        this.action = action;
        this.subject = subject;
        this.message = message;
        this.expiryAt = expiryAt;
        this.status = status;
    }

    public Long getAppUserNotificationMessageId() {
        return appUserNotificationMessageId;
    }
    public void setAppUserNotificationMessageId(Long appUserNotificationMessageId) {
        this.appUserNotificationMessageId = appUserNotificationMessageId;
    }

    public Long getAppUserId() {
        return appUserId;
    }
    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public BaseMasterEntity getBaseMasterEntity() {
        return baseMasterEntity;
    }
    public void setBaseMasterEntity(BaseMasterEntity baseMasterEntity) {
        this.baseMasterEntity = baseMasterEntity;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getExpiryAt() {
        return expiryAt;
    }
    public void setExpiryAt(Timestamp expiryAt) {
        this.expiryAt = expiryAt;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}