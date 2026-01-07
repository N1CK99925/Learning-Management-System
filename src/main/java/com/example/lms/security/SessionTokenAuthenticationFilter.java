package com.example.lms.security;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SessionTokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public SessionTokenAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            String token = (String) session.getAttribute("JWT_TOKEN");

            if (token != null && jwtService.validateToken(token)) {
                String username = jwtService.extractUsername(token);

                if (username != null) {
                    User userDetails = new User(username, "", Collections.emptyList());
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.startsWith("/api/users/register") ||
               path.startsWith("/api/users/login") ||
               path.startsWith("/login") ||
               path.startsWith("/logout") ||
               path.startsWith("/api/files/upload") ||
               path.startsWith("/upload") ||
               path.startsWith("/api/admin/") ||
               path.startsWith("/admin/");
    }
}
