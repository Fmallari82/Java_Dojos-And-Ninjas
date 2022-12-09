package com.francisco.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="dojo")
public class Dojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required")
	@Size(min=3, max = 20, message="Name requires between 3 to 20 characters")
	private String name;

	
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninja;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    public Dojo() {
		// TODO Auto-generated constructor stub
	}
    



	public Dojo(
			@NotEmpty(message = "Name is required") @Size(min = 3, max = 20, message = "Name requires between 3 to 20 characters") String name) {
		super();
		this.name = name;
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Ninja> getNinja() {
		return ninja;
	}



	public void setNinja(List<Ninja> ninja) {
		this.ninja = ninja;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
