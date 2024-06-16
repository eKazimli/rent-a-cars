package org.example.rentacar.database.contact.controller.featuresController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.service.featuresService.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CommentController {

    CommentService commentService;

    @PostMapping("/toComment/{userId}/{modelId}")
    public void toComment(@PathVariable Long userId, @PathVariable Long modelId, @RequestBody Map<String, Object> requestBody) {
        String commentText = (String) requestBody.get("commentText");
        commentService.toComment(userId, modelId, commentText);
    }

    @PutMapping("/activeComment/{userId}/{modelId}")
    public void activeComment(@PathVariable Long userId, @PathVariable Long modelId) {
        commentService.activeComment(userId, modelId);
    }

    @PutMapping("/removeComment/{userId}/{modelId}")
    public void removeComment(@PathVariable Long userId, @PathVariable Long modelId) {
        commentService.removeComment(userId, modelId);
    }


}
