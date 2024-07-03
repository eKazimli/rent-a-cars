package org.example.rentacar.controller.featuresController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.service.featuresService.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/remove/{likeId}")
    public void didactive(@PathVariable Long likeId) {
        likeService.didactive(likeId);
    }

    @GetMapping("/userAllLikes/{userId}")
    public ResponseEntity<List<String>> AllLikesOfTheUser(@PathVariable Long userId) {
        List<String> allLikesOfTheUser = likeService.allLikesOfTheUser(userId);
        return new ResponseEntity<>(allLikesOfTheUser, HttpStatus.OK);
    }

}
