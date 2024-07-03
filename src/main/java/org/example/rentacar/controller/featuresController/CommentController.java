package org.example.rentacar.controller.featuresController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.service.featuresService.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("v1/comments")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CommentController {

    CommentService commentService;

    @PostMapping("/create/{userId}/{modelId}")
    public void create(@PathVariable Long userId, @PathVariable Long modelId, @RequestBody Map<String, Object> requestBody) {
        String commentText = (String) requestBody.get("commentText");
        commentService.create(userId, modelId, commentText);
    }

    @PutMapping("/activate/{commentId}")
    public void activate(@PathVariable Long commentId) {
        commentService.activate(commentId);
    }

    @PutMapping("/didactive/{commendId}")
    public void didactive(@PathVariable Long commendId) {
        commentService.didactive(commendId);
    }


}
