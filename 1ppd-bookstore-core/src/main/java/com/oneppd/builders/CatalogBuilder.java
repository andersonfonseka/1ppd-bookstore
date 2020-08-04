package com.oneppd.builders;

import com.oneppd.domain.Catalog;

public interface CatalogBuilder {

	public Catalog builderCatalog(String uuid);

	public void buildBooks();
	
	public Catalog build();
	
}
