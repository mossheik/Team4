package com.cg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Slot;
@Transactional
@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer>{
	
	public Slot findTopByOrderBySlotNoDesc();
	
	@Modifying 
	@Query("delete from Slot slot where slot.slotNo=:slot")
	public void deleteBySlotNo(@Param("slot") String slot);
	
	
	
}
