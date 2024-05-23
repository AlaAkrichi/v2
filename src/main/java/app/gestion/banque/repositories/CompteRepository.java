package app.gestion.banque.repositories;

import app.gestion.banque.entities.Compte;
import app.gestion.banque.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,String> {




}
