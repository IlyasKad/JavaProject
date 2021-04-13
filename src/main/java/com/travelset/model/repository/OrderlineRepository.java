package com.travelset.model.repository;

import com.travelset.model.entity.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Integer> {

}