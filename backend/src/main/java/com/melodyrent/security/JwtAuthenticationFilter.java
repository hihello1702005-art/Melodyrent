package com.melodyrent.security;
import jakarta.servlet.*; import jakarta.servlet.http.*; import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; import org.springframework.security.core.context.SecurityContextHolder; import org.springframework.security.web.authentication.WebAuthenticationDetailsSource; import org.springframework.stereotype.Component; import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component @RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final JwtService jwtService; private final UserDetailsServiceImpl userDetailsService;
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    String header=request.getHeader("Authorization");
    if(header!=null && header.startsWith("Bearer ")) try { String token=header.substring(7); String email=jwtService.subject(token); if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null){ var user=userDetailsService.loadUserByUsername(email); if(jwtService.valid(token,user)){ var auth=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities()); auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); SecurityContextHolder.getContext().setAuthentication(auth); } } } catch(Exception ignored) { }
    chain.doFilter(request,response);
  }
}
