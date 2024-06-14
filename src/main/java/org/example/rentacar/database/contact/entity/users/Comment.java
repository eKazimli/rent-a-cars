package org.example.rentacar.database.contact.entity.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Model;

@Entity
@Getter
@Setter
@Table(name = "comments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    Long commentId;

    @NotBlank(message = "Comment text must not be empty")
    @Column(name = "comment_text")
    String commentText;

    @ManyToOne
    @JoinColumn(name = "model_id")
    Model model;

}
