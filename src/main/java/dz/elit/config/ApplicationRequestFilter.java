package dz.elit.config;

import dz.elit.service.auth.ApplicationUserDetailsService;
import dz.elit.controller.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApplicationRequestFilter extends OncePerRequestFilter {
    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        // je verifier si j'ai une authrisation

        String username = null;
        String jwtToken = null;
        String idEntreprise=null;
        // JWT Token is in the form "Bearer token". Remove Bearer word and get
        // only the Token
        System.out.println(requestTokenHeader);

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
            jwtToken = requestTokenHeader.substring(7);
            System.out.println("jwtToken"+jwtToken);
            try {
               username = jwtUtil.extractUsername(jwtToken);
              // idEntreprise=jwtUtil.extractIdEntreprise(jwtToken);
                System.out.println("username"+username);
            } catch (IllegalArgumentException e) {
                logger.warn("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
// pour faire l'historique
//                if(jwtHstoriqueConnexionService.existTokenByJwtValue(jwtToken) ){
//                    jwtHstoriqueConnexionService.updateStateJwtHstoriqueConnexionByJwtValue(jwtToken);
//                    logger.warn("Token has expired DATABASE");
//                }
                logger.warn("JWT Token has expired");
                //response.
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }

        // Once we get the token validate it.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = this.applicationUserDetailsService.loadUserByUsername(username);
            System.out.println("je suis ici");
            // if token is valid configure Spring Security to manually set
            // authentication
            if (jwtUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
     //   MDC.put("idEntreprise",idEntreprise);
        filterChain.doFilter(request, response);
    }

}
