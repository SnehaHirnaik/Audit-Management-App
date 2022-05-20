package com.mfpe.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Component
@Getter
@Setter
@ToString
@ApiModel(description="Authentication Request Class")
public class AuthenticationRequest {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
