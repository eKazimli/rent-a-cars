package org.example.rentacar.entity.features;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.entity.cars.Model;
import org.example.rentacar.entity.users.User;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@Table(name = "comments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long commentId;

    @NotBlank(message = "Comment text must not be empty")
    @Column(name = "comment_text")
    String commentText;

    @Column(name = "is_comment")
    Boolean isComment = true;

    @ManyToOne
    @JoinColumn(name = "model_id")
    Model model;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
