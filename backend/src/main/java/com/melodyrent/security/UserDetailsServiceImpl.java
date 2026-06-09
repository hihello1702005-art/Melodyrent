package com.melodyrent.security;
import com.melodyrent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository users;
  public UserDetails loadUserByUsername(String email){ var u=users.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email)); return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), u.getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_"+r.getName().name())).toList()); }
}
