package tn.way.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Todo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private String titre ; 
	private String description ; 
	@Temporal (TemporalType.DATE)
	private Date dateDebut ;
	@Temporal (TemporalType.DATE)
	private Date dateDecheance ;
	
	private boolean statut ;
}
