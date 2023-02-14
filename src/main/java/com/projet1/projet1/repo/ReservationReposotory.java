package com.projet1.projet1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet1.projet1.model.Reservation;

public interface ReservationReposotory extends JpaRepository<Reservation, Long> {

	
	//@Query("SELECT r.dateDebut, r.dateFin, a.titre, u.username, u.contact FROM Reservation r JOIN r.annonce a JOIN r.user u WHERE a.id = :annonceId AND u.id = :userId")
	 // List<Reservation> findReservationByAnnonceIdAndUserId(@Param("annonceId") Long annonceId, @Param("userId") Long userId);
	
	
	
}
