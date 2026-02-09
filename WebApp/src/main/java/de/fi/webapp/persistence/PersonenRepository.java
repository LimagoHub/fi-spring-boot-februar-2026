package de.fi.webapp.persistence.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonenRepository extends CrudRepository<PersonEntity, UUID> {

    Iterable<PersonEntity> findByVorname(String vorname);

    @Query("select p.vorname , p.nachname from PersonEntity p")
    Iterable<Object[]> xyz();

    @Query("select new de.fi.webapp.persistence.entity.TinyPerson(p.id, p.nachname) from PersonEntity p")
    Iterable<TinyPerson> findAllTinies();
}
