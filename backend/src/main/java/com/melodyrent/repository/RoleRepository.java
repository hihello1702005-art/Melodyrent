package com.melodyrent.repository;
import com.melodyrent.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface RoleRepository extends JpaRepository<Role, Long> { Optional<Role> findByName(RoleName name); }
