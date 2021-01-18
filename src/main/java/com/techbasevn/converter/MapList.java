package com.techbasevn.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MapList<S,T> {
	@Autowired 
	private ModelMapper modelMapper;
	@SuppressWarnings("hiding")
	public <S, T> List<T> toEntities(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	@SuppressWarnings("hiding")
	public <S, T> List<S> toDtos(List<T> source, Class<S> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	/*
	 * private D dto; private E entity;
	 * 
	 * @Autowired private ModelMapper modelMapper;
	 * 
	 * public List<D> allToDTOs(List<E> entities){ List<D> dtos=new ArrayList<D>();
	 * for(E entity:entities) { modelMapper.map(entity,this.dto); dtos.add(dto); }
	 * return dtos; }
	 * 
	 * public List<E> allToEntities(List<D> dtos){ List<E> entities=new
	 * ArrayList<E>(); for(D dto:dtos) { modelMapper.map(dto,this.entity);
	 * entities.add(entity); } return entities; }
	 */
}
