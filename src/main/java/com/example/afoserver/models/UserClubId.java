package com.example.afoserver.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Composite primary key for the join table
 * Read this article for better understanding:
 * https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
 */

@Embeddable
public class UserClubId implements Serializable {
    @Column(name="club_id")
    private Long clubId;
    @Column(name="user_id")
    private Long userId;

    public UserClubId() {}

    public UserClubId(Long clubId, Long userId) {
        this.clubId = clubId;
        this.userId = userId;
    }

    public Long getClubId() {
        return clubId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserClubId that = (UserClubId) o;
        return Objects.equals(clubId, that.clubId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, userId);
    }

}
