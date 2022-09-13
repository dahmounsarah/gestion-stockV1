//package dz.elit.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpResponse;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.Serializable;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
//
//	private static final long serialVersionUID = -7858869558953243875L;
//	private final HttpMessageConverter<String> messageConverter;
//	private final ObjectMapper objectMapper;
//	public JwtAuthenticationEntryPoint(HttpMessageConverter<String> messageConverter, ObjectMapper objectMapper) {
//		this.messageConverter = messageConverter;
//		this.objectMapper = objectMapper;
//	}
//
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException {
//		try(ServerHttpResponse servletResponse = new ServletServerHttpResponse(response)){
//			servletResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
//			messageConverter.write("Device is not Authorized", MediaType.APPLICATION_JSON,servletResponse);
//		}
//	}
//}
