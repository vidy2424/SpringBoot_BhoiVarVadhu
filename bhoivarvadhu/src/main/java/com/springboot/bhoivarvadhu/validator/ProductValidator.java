package com.springboot.bhoivarvadhu.validator;

import java.util.HashMap;
import java.util.Map;

import com.springboot.bhoivarvadhu.dto.User;

public class ProductValidator {

	public Map<String, Object> validateMember(Object target) {

		Map<String, Object> errors = new HashMap<String, Object>();
		User member = (User) target;
		if (member.getFile() == null || member.getFile().getOriginalFilename().equals("")) {
			errors.put("file", "Please select a file to upload!");
		}
		if (!(member.getFile().getContentType().equals("image/jpeg")
				|| member.getFile().getContentType().equals("image/png"))
				|| member.getFile().getContentType().equals("image/gif")) {
			errors.put("file", "Please select an image file to upload!");
		}
		return errors;
	}

}
