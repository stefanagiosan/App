package com.fsa.firststepapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Clasă de entitate care reprezintă un utilizator în aplicație.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Users")
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="userId")
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne()
    @JoinColumn(name = "university", nullable = false)
    private University university;

    @ManyToOne()
    @JoinColumn(name = "faculty", nullable = false)
    private Faculty faculty;

    @OneToMany(mappedBy = "user")
    private List<Question> questions;

    // --------------------------------------------------------- pentru Spring Security
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    //------------------------------------------------------------
}
