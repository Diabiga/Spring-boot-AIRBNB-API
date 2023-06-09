package com.projet1.projet1;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import org.hibernate.proxy.HibernateProxy;


@SuppressWarnings("deprecation")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	   ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
       
       // Ignorer la propriété hibernateLazyInitializer
       objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
       objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
       objectMapper.addMixIn(Object.class, IgnoreHibernatePropertiesInJackson.class);
       
       // Ajouter le convertisseur JSON avec l'ObjectMapper configuré
       MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
       converter.setObjectMapper(objectMapper);
       
       converters.add(converter);
   }
   
   // Classe IgnoreHibernatePropertiesInJackson à définir ici
   abstract class IgnoreHibernatePropertiesInJackson {
       @JsonIgnore
       abstract HibernateProxy getHibernateLazyInitializer();}
}
