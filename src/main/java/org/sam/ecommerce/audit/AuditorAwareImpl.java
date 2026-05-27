package org.sam.ecommerce.audit;

import org.sam.ecommerce.entity.User;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.empty();
    }
}
