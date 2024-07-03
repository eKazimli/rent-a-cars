package org.example.rentacar.repository.featuresRepository;

import org.example.rentacar.entity.features.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findByUserIdAndModelIdAndCommentText(Long userId, Long modelId, String commentText);
    Comment findByCommentId(Long commentId);
}
