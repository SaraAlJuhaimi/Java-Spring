package com.sara.authentication.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sara.authentication.models.Show;

@Component
public class ShowValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Show.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
