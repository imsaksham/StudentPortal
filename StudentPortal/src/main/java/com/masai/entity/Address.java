package com.masai.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    
    private String area;
    private String state;
    private String district;
    private String pincode;
    private String addressType;
   
    @ManyToOne
    private Student student;
}


