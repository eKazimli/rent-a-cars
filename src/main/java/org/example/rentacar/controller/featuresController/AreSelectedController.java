package org.example.rentacar.controller.featuresController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.service.featuresService.AreSelectedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/selected")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AreSelectedController {

    AreSelectedService areSelectedService;

    @PostMapping("/{userId}/{modelId}")
    public void selected(@PathVariable Long userId, @PathVariable Long modelId) {
        areSelectedService.selected(userId, modelId);
    }

    @PutMapping("/remove/{likeId}")
    public void didactive(@PathVariable Long likeId) {
        areSelectedService.didactive(likeId);
    }

    @GetMapping("/totalSelected/{userId}")
    public ResponseEntity<List<String>> getTotalSelected(@PathVariable Long userId) {
        List<String> selectedModels = areSelectedService.totalSelected(userId);
        return new ResponseEntity<>(selectedModels, HttpStatus.OK);
    }
}
