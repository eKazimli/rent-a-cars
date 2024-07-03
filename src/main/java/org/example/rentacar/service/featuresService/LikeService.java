package org.example.rentacar.service.featuresService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.entity.cars.Model;
import org.example.rentacar.entity.features.Like;
import org.example.rentacar.entity.users.User;
import org.example.rentacar.repository.ModelRepository;
import org.example.rentacar.repository.UserRepository;
import org.example.rentacar.repository.featuresRepository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LikeService {

    ModelRepository modelRepository;
    UserRepository userRepository;
    LikeRepository likeRepository;

    public List<String> allLikesOfTheUser(Long userId) {

        List<Like> likeModels = likeRepository.findByUserId(userId);
        if (likeModels.isEmpty()) {
            throw new EntityNotFoundException("User did not like any cars");
        }
        return likeModels.stream()
                .map(like -> like.getModel().getCarModel())
                .collect(Collectors.toList());
    }

    public long totalLike(Long modelId) {
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("No such model found"));

        return model.getLikes().stream()
                .filter(like -> Boolean.TRUE.equals(like.getIsLiked()))
                .count();
    }

    public void isLike(Long userId, Long modelId) {
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
        likeRepository.save(like);
    }


    public void didactive(Long likeId) {
        Like like = likeRepository.findByLikeId(likeId);
        if (like != null) {
            like.setIsLiked(false);
            likeRepository.save(like);
        } else {
            throw new EntityNotFoundException("no likes found");
        }
    }
}
