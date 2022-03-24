package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "NonAbonne")
@DiscriminatorValue("NonAbonne")
@NamedQuery(name = "NonAbonne.getAll", query="Select A from NonAbonne A")
public class NonAbonne extends Client {

}
