package fr.insalyon.dasi.metier.modele;

import fr.insalyon.dasi.metier.modele.Consultation;
import fr.insalyon.dasi.metier.modele.ProfilAstral;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-30T14:40:23")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> motDePasse;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, Date> dateNaissance;
    public static volatile SingularAttribute<Client, ProfilAstral> profil;
    public static volatile SingularAttribute<Client, String> genre;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile ListAttribute<Client, Consultation> consultations;

}