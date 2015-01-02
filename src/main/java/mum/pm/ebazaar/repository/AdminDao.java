package mum.pm.ebazaar.repository;

import mum.pm.ebazaar.domain.Admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends CrudRepository<Admin,Long> {


}
