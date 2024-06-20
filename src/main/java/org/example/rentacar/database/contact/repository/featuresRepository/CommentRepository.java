package org.example.rentacar.database.contact.repository.featuresRepository;

import org.example.rentacar.database.contact.entity.features.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByUserIdAndModelIdAndCommentText(Long userId, Long modelId, String commentText);
    Comment findByCommentId(Long commentId);
}
