package org.example.rentacar.database.contact.controller.featuresController;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.service.featuresService.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LikeController {

    LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/totalLikes/{modelId}")
    public long countLikesByModelId(@PathVariable Long modelId) {
        return likeService.countLikesByModel(modelId);
    }

    @PostMapping("/add/{userId}/{modelId}")
    public void toLike(@PathVariable Long userId, @PathVariable Long modelId) {
        likeService.toLike(userId, modelId);
    }

    @PutMapping("/removeLike/{userId}/{modelId}")
    public void removeLike(@PathVariable Long userId, @PathVariable Long modelId) {
        likeService.removeLike(userId,modelId);
    }

}
