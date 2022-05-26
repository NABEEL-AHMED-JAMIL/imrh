package com.barco.imrh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

/**
 * @author Nabeel Ahmed
 */
@Entity
@Table(name = "APP_USER_DEVICE")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserDevice extends BaseEntity {

    @GenericGenerator(
        name = "appUserDeviceSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "APP_USER_DEVICE_SEQ"),
            @Parameter(name = "initial_value", value = "1000"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Id
    @GeneratedValue(generator = "appUserDeviceSequenceGenerator")
    @Column(name="APP_USER_DEVICE_ID", unique=true, nullable=false)
    private Long appUserDeviceId;

    @Column(name="APP_USER_ID", nullable=false)
    private Long appUserId;

    @Column(name="DEVICE_ID")
    private String deviceId;

    @Column(name="FCM_ID")
    private String fcmId;

    @Column(name="LAST_LOGIN_TIME")
    private String lastLoginTime;

    @Column(name="DEVICE_OS")
    private String deviceOs;

    @Column(name="OS_VERSION")
    private String osVersion;

    @Column(name="DEVICE_MODEL")
    private String deviceModel;

    @Column(name="ADDITIONAL_INFO")
    private String additionalInfo;

    public AppUserDevice() {}

    public AppUserDevice(Long appUserId, String deviceId, String fcmId, String lastLoginTime,
        String deviceOs, String osVersion, String deviceModel, String additionalInfo) {
        this.appUserId = appUserId;
        this.deviceId = deviceId;
        this.fcmId = fcmId;
        this.lastLoginTime = lastLoginTime;
        this.deviceOs = deviceOs;
        this.osVersion = osVersion;
        this.deviceModel = deviceModel;
        this.additionalInfo = additionalInfo;
    }

    public Long getAppUserDeviceId() {
        return appUserDeviceId;
    }
    public void setAppUserDeviceId(Long appUserDeviceId) {
        this.appUserDeviceId = appUserDeviceId;
    }

    public Long getAppUserId() {
        return appUserId;
    }
    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getFcmId() {
        return fcmId;
    }
    public void setFcmId(String fcmId) {
        this.fcmId = fcmId;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getDeviceOs() {
        return deviceOs;
    }
    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getOsVersion() {
        return osVersion;
    }
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
