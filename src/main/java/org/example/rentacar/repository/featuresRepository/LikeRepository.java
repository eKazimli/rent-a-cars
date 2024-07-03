package org.example.rentacar.repository.featuresRepository;

import org.example.rentacar.entity.features.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByUserIdAndModelId(Long userId, Long modelId);
    Like findByLikeId(Long likeId);
    List<Like> findByUserId(Long userId);
}
