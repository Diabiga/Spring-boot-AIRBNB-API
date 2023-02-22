package com.projet1.projet1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
    
    
//    @Lob
//    @Column(name = "imagedata",length = 1000)
//    private byte[] imageData;
    

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;
    
}
