package com.projet1.projet1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import org.hibernate.proxy.HibernateProxy;


@Configuration
public class JacksonConfig {
	 @Bean
	    public ObjectMapper objectMapper() {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
	        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        objectMapper.addMixIn(HibernateProxy.class, HibernateProxyMixin.class);
	        return objectMapper;
	    }

	    
	    private abstract class HibernateProxyMixin {
	        @JsonIgnore
	        public abstract Object getHibernateLazyInitializer();
	    }
}
