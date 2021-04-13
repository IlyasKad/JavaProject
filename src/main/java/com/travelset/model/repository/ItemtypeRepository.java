package com.travelset.model.repository;

import com.travelset.model.entity.Itemtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemtypeRepository extends JpaRepository<Itemtype, Integer> {

}