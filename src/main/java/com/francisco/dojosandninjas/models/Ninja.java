package com.francisco.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninja")
public class Ninja {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="dojo_id")
	    private Dojo dojo;
	    
	    @NotNull
	    @Size(min = 3, max = 200, message="First Name needs to be at least 3 characters long")
	    private String firstName;
	    
	    @NotNull
	    @Size(min = 3, max = 200, message="Last Name needs to be at least 3 characters long")
	    private String lastName;
	    
	    @NotNull
	    @Min(value=5, message="Age must be at least 5 years old")
	    private Integer age;
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    

		public Ninja() {}





		public Ninja(
				@NotNull @Size(min = 3, max = 200, message = "First Name needs to be at least 3 characters long") String firstName,
				@NotNull @Size(min = 3, max = 200, message = "Last Name needs to be at least 3 characters long") String lastName,
				@NotNull @Min(value = 5, message = "Age must be at least 5 years old") Integer age) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}





		public Ninja(Long id,
				@NotNull @Size(min = 3, max = 200, message = "First Name needs to be at least 3 characters long") String firstName,
				@NotNull @Size(min = 3, max = 200, message = "Last Name needs to be at least 3 characters long") String lastName,
				@NotNull @Min(value = 5, message = "Age must be at least 5 years old") Integer age) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Dojo getDojo() {
			return dojo;
		}

		public void setDojo(Dojo dojo) {
			this.dojo = dojo;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
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
