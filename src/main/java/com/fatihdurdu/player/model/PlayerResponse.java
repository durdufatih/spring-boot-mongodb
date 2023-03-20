package com.fatihdurdu.player.model;

import org.springframework.data.annotation.Id;

public class PlayerResponse {
    private String id;
    private String name;
    private String nationality;
    private String birthDate;
    private String position;

    public PlayerResponse(String id, String name, String nationality, String birthDate, String position) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.position = position;
    }

    public PlayerResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
