package com.example.a20201116g_versioncontrol.model.version;

import java.io.Serializable;

public class VersionModel implements Serializable {

    private Integer registrationsVersion;

    public VersionModel(Integer registrationsVersion) {

        this.registrationsVersion = registrationsVersion;

    }

    public VersionModel() {
        this.registrationsVersion = 0;
    }

    public void setRegistrationsVersion(Integer registrationsVersion) {
        this.registrationsVersion = registrationsVersion;
    }

    public Integer getRegistrationsVersion() {
        return this.registrationsVersion;
    }

}
