package io.egen.movieflix.entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EntityResult;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@SqlResultSetMapping(name="srsm3" ,entities=@EntityResult(entityClass=Role.class))
public class Role {

	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	@Id
	private String roleId;
	
	private String type;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name="Crew_Role",
	        joinColumns = @JoinColumn(name="roleId"),
	        inverseJoinColumns = @JoinColumn(name="crewId")
	              )
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Crew> crew;
	

	

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<Crew> getCrew() {
		return crew;
	}

	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
