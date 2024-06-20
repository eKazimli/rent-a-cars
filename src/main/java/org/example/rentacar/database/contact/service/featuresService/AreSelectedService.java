package org.example.rentacar.database.contact.service.featuresService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.rentacar.database.contact.entity.cars.Model;
import org.example.rentacar.database.contact.entity.features.AreSelected;
import org.example.rentacar.database.contact.entity.users.User;
import org.example.rentacar.database.contact.repository.ModelRepository;
import org.example.rentacar.database.contact.repository.UserRepository;
import org.example.rentacar.database.contact.repository.featuresRepository.AreSelectedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AreSelectedService {
    AreSelectedRepository areSelectedRepository;
    UserRepository userRepository;
    ModelRepository modelRepository;

    public void selected(Long userId, Long modelId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Model model = modelRepository.findById(modelId)
                .orElseThrow(() -> new EntityNotFoundException("Model not found"));

        AreSelected areSelected = areSelectedRepository.findByUserIdAndModelId(userId, modelId);
        if (areSelected != null) {
            areSelected.setSelected(true);
        } else {
            areSelected = new AreSelected();
            areSelected.setUser(user);
            areSelected.setModel(model);
            areSelected.setSelected(true);
        }
        areSelectedRepository.save(areSelected);
    }

    public void didactive(Long selectedId) {
        AreSelected areSelected = areSelectedRepository.findBySelectedId(selectedId);
        if (areSelected != null) {
            areSelected.setSelected(false);
            areSelectedRepository.save(areSelected);
        } else {
            throw new EntityNotFoundException("no selected found");
        }
    }

    public List<String> totalSelected(Long userId) {

        List<AreSelected> selectedModels = areSelectedRepository.findByUserId(userId);
        if (selectedModels.isEmpty()) {
            throw new EntityNotFoundException("The user did not select any car");
        }
        return selectedModels.stream()
                .map(areSelected -> areSelected.getModel().getCarModel())
                .collect(Collectors.toList());
    }
}
