package com.projet1.projet1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet1.projet1.model.Annonce;
import com.projet1.projet1.model.Categorie;

public interface AnnonceReposotory extends JpaRepository<Annonce, Long> {

	@Query("select p from Annonce p where p.categorie = ?1")
	List<Annonce> findByCategorie (Categorie categorie);
	
	
	List<Annonce> findByTitreAnnonce(String nom);
	
	List<Annonce> findByTitreAnnonceContains(String nom);
	
	/*@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix (String nom, Double prix);*/
	
	@Query("select p from Annonce p where p.titreAnnonce like %:nom and p.prixAnnonce > :prix")
	List<Annonce> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

	
	
	//List<Annonce> findByCategorieIdCat(Long id);
	
	List<Annonce> findByOrderByTitreAnnonceAsc();
	
	@Query("select p from Annonce p order by p.titreAnnonce ASC, p.prixAnnonce DESC")
	List<Annonce> trierAnnonceNomsPrix ();
	
}
