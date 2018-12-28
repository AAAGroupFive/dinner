package com.dinner.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * className:FtpConfig
 * discriptoin:
 * author:王朝军
 * createTime:2018-12-17 16:25
 */
@Component
@ConfigurationProperties(prefix = "ftp")
@PropertySource("classpath:ftp.properties")
public class FtpConfig {
    private String remoteIp;
    private Integer uploadPort;
    private String ftpUserName;
    private String ftpPassWord;
    private String remotePath;
    private String localPath;

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public Integer getUploadPort() {
        return uploadPort;
    }

    public void setUploadPort(Integer uploadPort) {
        this.uploadPort = uploadPort;
    }

    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    public String getFtpPassWord() {
        return ftpPassWord;
    }

    public void setFtpPassWord(String ftpPassWord) {
        this.ftpPassWord = ftpPassWord;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}
