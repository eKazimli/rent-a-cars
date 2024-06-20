package org.example.rentacar.database.contact.repository.featuresRepository;

import org.example.rentacar.database.contact.entity.features.AreSelected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreSelectedRepository extends JpaRepository<AreSelected, Long> {
    AreSelected findByUserIdAndModelId(Long userId, Long modelId);
    AreSelected findBySelectedId(Long selectedId);
    List<AreSelected> findByUserId(Long userId);
}
