package com.matrix.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public final class SimpleGrantedAuthority implements GrantedAuthority {
    private static final long serialVersionUID = 500L;
    private final String role;

    public SimpleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    public String getAuthority() {
        return this.role;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return obj instanceof SimpleGrantedAuthority && this.role.equals(((SimpleGrantedAuthority) obj).role);
        }
    }

    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role;
    }
}