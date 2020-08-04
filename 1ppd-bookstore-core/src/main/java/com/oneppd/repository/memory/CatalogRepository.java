package com.oneppd.repository.memory;

import com.oneppd.domain.Catalog;

public class CatalogRepository extends BaseRepository<Catalog> {

	private static CatalogRepository INSTANCE;
	
	public static CatalogRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CatalogRepository();
		}

		return INSTANCE;
	}
	
	
	private CatalogRepository() {}
	
}
