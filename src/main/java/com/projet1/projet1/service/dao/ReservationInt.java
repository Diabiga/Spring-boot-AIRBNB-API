package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.Reservation;

public interface ReservationInt {
	
	public Reservation saveReservation (Reservation r);
	public void  suppReservation (Reservation r);
	public Reservation updateReservation (Reservation r);
	public List<Reservation>allreservation();
	public List<Reservation>ReservationByAnnonceIdAndUserId(Long idUser,Long idAnnoce);
	

}
