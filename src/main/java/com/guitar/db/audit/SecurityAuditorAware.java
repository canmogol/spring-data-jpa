package com.guitar.db.audit;

import org.springframework.data.domain.AuditorAware;

public class SecurityAuditorAware implements AuditorAware<String>{
    @Override
    public String getCurrentAuditor() {
        return "user";
    }
}
