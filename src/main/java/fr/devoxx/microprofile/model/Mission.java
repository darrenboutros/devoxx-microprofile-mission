package fr.devoxx.microprofile.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Mission {

	private Integer id;
	private String name;
	private String planet;
	private String keeper;
	@NotNull
	private Integer StoneId;
}
