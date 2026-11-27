package com.farmalink.farmacontrol.entities;

import com.farmalink.farmacontrol.entities.enums.Permission;
import com.farmalink.farmacontrol.entities.enums.Profile;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String passwordHash;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Profile profile;

    @Setter
    @Column(nullable = false)
    private boolean active;

    public User(String name, String login, Profile profile, String passwordHash) {
        this.name = name;
        this.login = login;
        this.profile = profile;
        this.passwordHash = passwordHash;
    }
    
    public boolean canAccess(Permission permission) {
        return active && profile.has(permission);
    }
}
