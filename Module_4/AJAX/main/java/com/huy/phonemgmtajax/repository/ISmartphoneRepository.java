package com.huy.phonemgmtajax.repository;

import com.huy.phonemgmtajax.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone, Long> {

}