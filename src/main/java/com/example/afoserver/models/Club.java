package com.example.afoserver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String bio;
    private String animeId;

    @OneToMany (
            mappedBy = "club",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserClub> users = new ArrayList<>();

    /**
     * Default constructor for user.
     */
    public Club() {}

    /**
     * Get the id of this object.
     * @return id a Long.
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the name of this object.
     * @return name a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this object.
     * @param name a String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the bio of this object.
     * @return bio a String.
     */
    public String getBio() {
        return bio;
    }

    /**
     * Set the bio of this object.
     * @param bio a String.
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Get the anime id of this object.
     * @return animeId a String.
     */
    public String getAnimeId() {
        return animeId;
    }

    /**
     * Set the animeId of this object
     * @param animeId a String.
     */
    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }

    public List<UserClub> getUsers() {
        return users;
    }

    public void setUsers(List<UserClub> users) {
        this.users = users;
    }

    public void createNewClub(User user) {
        UserClub userClub = new UserClub(this, user);
        userClub.setUserIsOwner(Boolean.TRUE);
        users.add(userClub);
        user.getClubs().add(userClub);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(name, club.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
