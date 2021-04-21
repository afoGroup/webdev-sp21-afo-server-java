package com.example.afoserver.models;

import javax.persistence.*;
import java.util.Objects;

// Join table that shows the groups and their members
@Entity
@Table(name = "user_clubs")
public class UserClub {

    @EmbeddedId
    private UserClubId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clubId")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @Column(name = "user_is_owner")
    private Boolean userIsOwner = Boolean.FALSE;

    public UserClub() {}

    public UserClub(Club club, User user) {
        this.club = club;
        this.user = user;
        this.id = new UserClubId(club.getId(), user.getId());
    }

    public UserClubId getId() {
        return id;
    }

    public void setId(UserClubId id) {
        this.id = id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getUserIsOwner() {
        return userIsOwner;
    }

    public void setUserIsOwner(Boolean userIsOwner) {
        this.userIsOwner = userIsOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserClub that = (UserClub) o;
        return Objects.equals(club, that.club) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(club, user);
    }

}
