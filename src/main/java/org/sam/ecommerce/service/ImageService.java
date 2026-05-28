package org.sam.ecommerce.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.sam.ecommerce.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageService {
    ImageRepository repository;

    boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Set<Long> findExistingIdsIn(Set<Long> ids) {
        return new HashSet<>(repository.findExistingIdsIn(ids));
    }
}
