package com.example.olenburg.projectwo.model;

import java.util.List;

public class Cinema {
    private String name;
    private Integer id;
    private String url;
    private String  image;
    private String vote;
    private String count_vote;
    private String countries;
    private List<SessionsObject> sessions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return "https://kinoafisha.ua"  + image;  //https://kinoafisha.ua/upload/2017/06/films/7807/1538550103venom.jpg
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getCount_vote() {
        return count_vote;
    }

    public void setCount_vote(String count_vote) {
        this.count_vote = count_vote;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public List<SessionsObject> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionsObject> sessions) {
        this.sessions = sessions;
    }
}
