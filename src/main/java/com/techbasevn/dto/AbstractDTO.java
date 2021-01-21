package com.techbasevn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractDTO<T> {

	private Integer id;
	private String name;

	public AbstractDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public AbstractDTO() {
	}

}
