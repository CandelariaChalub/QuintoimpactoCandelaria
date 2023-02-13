package com.crud.Candelariaquintoimpacto.repositories;

import com.crud.Candelariaquintoimpacto.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
