package org.example.rentacar.entity.features;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.entity.cars.Model;
import org.example.rentacar.entity.users.User;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "likes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

}
