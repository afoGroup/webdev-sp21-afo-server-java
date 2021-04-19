package com.example.afoserver.models;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "groups")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String name;
    @Column(columnDefinition = "TEXT")
    private String bio;
    private Long associatedAnimeId;
    @OneToMany (
            mappedBy = "group",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserGroup> users = new ArrayList<>();
//
//    /**
//     * Default constructor for user.
//     */
//    public Group() {}

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
     * Get the owner of this object.
     * @return owner a Long. FK to users.
     */
//    public Long getOwnerId() {
//        return ownerId;
//    }
//
//    /**
//     * Set the User of this object
//     * @param ownerId a User.
//     */
//    public void setOwnerId(Long ownerId) {
//        this.ownerId = ownerId;
//    }

    /**
     * Get the associated anime id of this object.
     * @return associatedAnimeId a Long.
     */
    public Long getAssociatedAnimeId() {
        return associatedAnimeId;
    }

    /**
     * Set the associatedAnimeId of this object
     * @param associatedAnimeId a Long.
     */
    public void setAssociatedAnimeId(Long associatedAnimeId) {
        this.associatedAnimeId = associatedAnimeId;
    }

    public List<UserGroup> getUsers() {
        return users;
    }

    public void setUsers(List<UserGroup> users) {
        this.users = users;
    }

    public void createNewGroup(User user) {
        UserGroup userGroup = new UserGroup(this, user);
        userGroup.setUserIsOwner(Boolean.TRUE);
        users.add(userGroup);
        user.getGroups().add(userGroup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
