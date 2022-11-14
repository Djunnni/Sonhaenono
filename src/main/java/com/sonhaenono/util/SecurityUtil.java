package com.sonhaenono.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);
	
	private SecurityUtil() {
		
	}
	
	public static Optional<String> getCurrentUserId() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null) {
			logger.debug("Security Context에 인증정보가 없습니다.");
			return Optional.empty();
		}
		
		String id = null;
		if(authentication.getPrincipal() instanceof UserDetails) {
			UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
			id = springSecurityUser.getUsername();
		} else if(authentication.getPrincipal() instanceof String) {
			id = (String) authentication.getPrincipal();
		}
		
		return Optional.ofNullable(id);
	}
}
