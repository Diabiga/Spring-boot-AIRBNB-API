package com.projet1.projet1.service.dao;

import java.util.List;

import com.projet1.projet1.model.Commentaire;

public interface CommentaireInt {	
	
	public Commentaire saveCommentaire(Commentaire c);
	
	public Commentaire upadteCommentaire(Commentaire c);
	
	public List<Commentaire> getallcommentaire();
	
	public void deleteCommentaireById(Long id);
	
	public List<Commentaire> findCommentaireByAnnonceId(Long id);
}
