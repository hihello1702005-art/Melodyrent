package com.melodyrent.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Entity @Table(name="users") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User extends BaseEntity {
  @Column(nullable=false) private String fullName;
  @Column(nullable=false, unique=true) private String email;
  @Column(nullable=false) private String password;
  private String avatarUrl;
  @Builder.Default private Integer rewardPoints = 0;
  @Enumerated(EnumType.STRING) @Builder.Default private GamificationLevel level = GamificationLevel.BEGINNER;
  @ManyToMany(fetch=FetchType.EAGER) @JoinTable(name="user_roles", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
  @Builder.Default private Set<Role> roles = new HashSet<>();
}
