package org.example.rentacar.database.contact.controller.featuresController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.service.featuresService.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/likes")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LikeController {

    LikeService likeService;

    @GetMapping("/totalLikes/{modelId}")
    public long totalLike(@PathVariable Long modelId) {
        return likeService.totalLike(modelId);
    }

    @PostMapping("/isLike/{userId}/{modelId}")
    public void isLike(@PathVariable Long userId, @PathVariable Long modelId) {
        likeService.isLike(userId, modelId);
    }

    @PutMapping("/removeLike/{likeId}")
    public void didactive(@PathVariable Long likeId) {
        likeService.didactive(likeId);
    }

}
