package org.example.rentacar.database.contact.repository.featuresRepository;

import org.example.rentacar.database.contact.entity.features.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByUserIdAndModelId(Long userId, Long modelId);
    Like findByLikeId(Long likeId);
}
