package org.example.rentacar.database.contact.entity.features;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Model;
import org.example.rentacar.database.contact.entity.users.User;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@SQLRestriction("active = true")
@Table(name = "likes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    Long likeId;

    @Column(name = "is_liked")
    Boolean isLiked = true;

    @Column(name = "created")
    LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "model_id")
    Model model;

    @PrePersist
    protected void onCreate() {
        this.isLiked = true;
        this.created = LocalDateTime.now();
    }
}
