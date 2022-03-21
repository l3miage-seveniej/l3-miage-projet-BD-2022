package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NonAbonne")
@DiscriminatorValue("NonAbonne")
public class NonAbonne extends Client {

}
