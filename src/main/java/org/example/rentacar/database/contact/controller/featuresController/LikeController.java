package org.example.rentacar.database.contact.controller.featuresController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.service.featuresService.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LikeController {

    LikeService likeService;

    @GetMapping("/totalLikes/{modelId}")
    public long countLikesByModelId(@PathVariable Long modelId) {
        return likeService.countLikesByModel(modelId);
    }

    @PostMapping("/toLike/{userId}/{modelId}")
    public void toLike(@PathVariable Long userId, @PathVariable Long modelId) {
        likeService.toLike(userId, modelId);
    }

    @PutMapping("/removeLike/{userId}/{modelId}")
    public void removeLike(@PathVariable Long userId, @PathVariable Long modelId) {
        likeService.removeLike(userId,modelId);
    }

}
