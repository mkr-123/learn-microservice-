package io.javabrains.moviecatalogservice.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.moviecatalogservice.model.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")  String userId){
	return Collections.singletonList(new CatalogItem("K2","super",5));	
	}
}
