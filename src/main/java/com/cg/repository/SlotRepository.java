package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer>{
	
	@Query("SELECT s FROM Slot s WHERE s.slotStatus = 'Vacant'")
	public List<Slot> findAllAvailableSlot();
	
	
	@Query("from Slot slot where slot.slotNo=:slot") 
	public Slot findBySlotNo(@Param("slot") String slot);
	 
	
	/*
	
	//Custom Queries
		public List<Book> findByAuthor(String aname);
		public Book findByTitle(String title);
		//public Book findByTitleAndAuthor(String title,String Author);
		
		@Query("from Book book where book.title=:title and book.author=:author")
		public Book findByTitleAndAuthor(@Param("title") String title,@Param("author")String Author);
		@Query("select b from Book b where b.price=:price")
		public List<Book> findByPrice(@Param("price") int price);
		
		public List<Book> findAll(Sort sort);
		*/
	
}
