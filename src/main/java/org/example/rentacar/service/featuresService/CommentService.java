package org.example.rentacar.service.featuresService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.entity.cars.Model;
import org.example.rentacar.entity.features.Comment;
import org.example.rentacar.entity.users.User;
import org.example.rentacar.repository.ModelRepository;
import org.example.rentacar.repository.UserRepository;
import org.example.rentacar.repository.featuresRepository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CommentService {

    CommentRepository commentRepository;
    ModelRepository modelRepository;
    UserRepository userRepository;

    public void create(Long userId, Long modelId, String commentText) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("Model not found"));

        Comment comment = commentRepository.findByUserIdAndModelIdAndCommentText(userId, modelId, commentText);

        if (comment != null) {
            if (!comment.getIsComment()) {
                comment.setIsComment(true);
                commentRepository.save(comment);
            }else {
                throw new IllegalArgumentException("Comment already exists.");
            }
        }else {
            Comment newComment = new Comment();
            newComment.setUser(user);
            newComment.setModel(model);
            newComment.setCommentText(commentText);
            newComment.setIsComment(true);
            commentRepository.save(newComment);
        }

    }

    public Comment didactive(Long commendId) {
        Comment comment = commentRepository.findByCommentId(commendId);
        if (comment != null) {
            comment.setIsComment(false);
            return commentRepository.save(comment);
        } else {
            throw new EntityNotFoundException("Comment not found");
        }

    }

    public Comment activate(Long commentId) {
        Comment comment = commentRepository.findByCommentId(commentId);
        if (comment != null) {
            comment.setIsComment(true);
            return commentRepository.save(comment);
        } else {
            throw new EntityNotFoundException("Comment not found");
        }

    }

}
