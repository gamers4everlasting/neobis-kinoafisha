package com.example.olenburg.projectwo.model;

public class SessionsObject {
    public String k_id;   //	"256"
    private String k_name; //	"Multiplex Lavina Mall"
    private String k_addr; //	"г. Киев, ул. Берковецкая, 6Д"
    private String k_url;  //	"/cinema/kiev/multiplex-lavina-mall"
    private String h_name; //	"Зал 5"
    private String sessions; //"<div class=\"timewrap no…_blank\">21:30<a></div>"/

    public String getK_id() {
        return k_id;
    }

    public void setK_id(String k_id) {
        this.k_id = k_id;
    }

    public String getK_name() {
        return k_name;
    }

    public void setK_name(String k_name) {
        this.k_name = k_name;
    }

    public String getK_addr() {
        return k_addr;
    }

    public void setK_addr(String k_addr) {
        this.k_addr = k_addr;
    }

    public String getK_url() {
        return k_url;
    }

    public void setK_url(String k_url) {
        this.k_url = k_url;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }
}
