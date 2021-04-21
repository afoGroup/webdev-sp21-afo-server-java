package com.example.afoserver.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username; // username of the person who made the post
    @Column(columnDefinition = "TEXT")
    private String body;
    private Timestamp createdOn;
    @ManyToOne(fetch = FetchType.LAZY)
    private Club club;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post )) return false;
        return id != null && id.equals(((Post) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
