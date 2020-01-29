package com.closet.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.closet.domain.User;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;

		
//		ValidationUtils.rejectIfEmpty(errors, "email", "required");
		if(user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		
//		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		if(user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			errors.rejectValue("password", "required");
		}
		
	}

}
