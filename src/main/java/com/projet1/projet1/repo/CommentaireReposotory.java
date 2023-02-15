package com.projet1.projet1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet1.projet1.model.Commentaire;

public interface CommentaireReposotory extends JpaRepository<Commentaire, Long> {
	
	
	 // @Query("SELECT c.commentaire, a.titre FROM Commentaire c JOIN c.annonce a WHERE a.id = :annonceId")
	//   List<Commentaire> findCommentaireByAnnonceId(@Param("annonceId") Long annonceId);
	
	

}
