package org.example.rentacar.database.contact.service.featuresService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Model;
import org.example.rentacar.database.contact.entity.features.Like;
import org.example.rentacar.database.contact.entity.users.User;
import org.example.rentacar.database.contact.repository.ModelRepository;
import org.example.rentacar.database.contact.repository.UserRepository;
import org.example.rentacar.database.contact.repository.featuresRepository.LikeRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LikeService {

    ModelRepository modelRepository;
    UserRepository userRepository;
    LikeRepository likeRepository;

    public long countLikesByModel(Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("No such model found"));
        return model.getLikes().size();
    }

    public Like toLike(Long userId, Long modelId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("Model not found"));

        Like like = likeRepository.findByUserIdAndModelId(userId, modelId);
        if (like != null) {
            like.setIsLiked(true);
        } else {
            like = new Like();
            like.setUser(user);
            like.setModel(model);
            like.setIsLiked(true);
        }
        return likeRepository.save(like);
    }


    public void removeLike(Long userId, Long modelId) {
        Like like = likeRepository.findByUserIdAndModelId(userId, modelId);
        if (like != null) {
            like.setIsLiked(false);
            likeRepository.save(like);
        } else {
            throw new EntityNotFoundException("no likes found");
        }
    }
}
