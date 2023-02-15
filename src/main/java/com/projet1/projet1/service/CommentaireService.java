package com.projet1.projet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet1.projet1.model.Commentaire;
import com.projet1.projet1.repo.CommentaireReposotory;
import com.projet1.projet1.service.dao.CommentaireInt;


@Service
public class CommentaireService implements CommentaireInt{

	@Autowired
	CommentaireReposotory commentaireRepo;
	
	@Override
	public Commentaire saveCommentaire(Commentaire c) {
		return commentaireRepo.save(c);
	}

	@Override
	public Commentaire upadteCommentaire(Commentaire c) {
		
		return commentaireRepo.save(c);
	}

	@Override
	public List<Commentaire> getallcommentaire() {
		
		return commentaireRepo.findAll();
	}

	@Override
	public void deleteCommentaireById(Long id) {
		commentaireRepo.deleteById(id);
		
	}

	@Override
	public List<Commentaire> findCommentaireByAnnonceId(Long id) {
		return null;// commentaireRepo.findCommentaireByAnnonceId(id);	
	}

}
