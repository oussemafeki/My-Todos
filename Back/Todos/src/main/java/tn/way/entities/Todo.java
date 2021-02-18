package tn.way.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

@Entity
public class Todo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
    @NotEmpty(message = "{NotEmpty}")
	private String titre ; 
	private String description ; 
	@FutureOrPresent
	@Temporal (TemporalType.DATE)
	private Date dateDebut ;
	@FutureOrPresent
	@Temporal (TemporalType.DATE)
	private Date dateDecheance ;
	private String statut ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateDecheance() {
		return dateDecheance;
	}
	public void setDateDecheance(Date dateDecheance) {
		this.dateDecheance = dateDecheance;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", titre=" + titre + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateDecheance=" + dateDecheance + ", statut=" + statut + "]";
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(int id, @NotEmpty(message = "{NotEmpty}") String titre, String description,
			@FutureOrPresent Date dateDebut, @FutureOrPresent Date dateDecheance, String statut) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateDecheance = dateDecheance;
		this.statut = statut;
	}

	
	
	
}
