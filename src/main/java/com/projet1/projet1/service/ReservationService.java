package com.projet1.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.Reservation;
import com.projet1.projet1.repo.ReservationReposotory;
import com.projet1.projet1.service.dao.ReservationInt;

@Service
public class ReservationService implements ReservationInt {

	@Autowired
	ReservationReposotory reservation;
	@Override
	public Reservation saveReservation(Reservation r) {
		
		return reservation.save(r);
	}

	@Override
	public void suppReservation(Reservation r) {
		// TODO Auto-generated method stub
        reservation.delete(r);
	}

	@Override
	public Reservation updateReservation(Reservation r) {
		// TODO Auto-generated method stub
		return reservation.save(r);
	}

	@Override
	public List<Reservation> allreservation() {
		// TODO Auto-generated method stub
		return reservation.findAll();
	}

	@Override
	public List<Reservation> ReservationByAnnonceIdAndUserId(Long idUser, Long idAnnoce) {
		
		return null;// reservation.findReservationByAnnonceIdAndUserId(idAnnoce, idUser);
	}

	

}
