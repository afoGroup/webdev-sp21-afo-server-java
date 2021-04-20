package com.example.afoserver.models;

import javax.persistence.*;
import java.util.Objects;

// Join table that shows the groups and their members
@Entity
@Table(name = "user_groups")
public class UserGroup {

    @EmbeddedId
    private UserGroupId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clubId")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @Column(name = "user_is_owner")
    private Boolean userIsOwner = Boolean.FALSE;

    public UserGroup() {}

    public UserGroup(Club club, User user) {
        this.club = club;
        this.user = user;
        this.id = new UserGroupId(club.getId(), user.getId());
    }

    public UserGroupId getId() {
        return id;
    }

    public void setId(UserGroupId id) {
        this.id = id;
    }

    public Club getGroup() {
        return club;
    }

    public void setGroup(Club club) {
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

        UserGroup that = (UserGroup) o;
        return Objects.equals(club, that.club) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(club, user);
    }

}
