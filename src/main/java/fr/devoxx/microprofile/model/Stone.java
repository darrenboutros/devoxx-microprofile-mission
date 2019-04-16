package fr.devoxx.microprofile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Stone {
	
	private Integer id;
	private String name;
	private String color;

}
