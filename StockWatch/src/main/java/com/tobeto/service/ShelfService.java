package com.tobeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Shelf;
import com.tobeto.exception.ServiceException;
import com.tobeto.exception.ServiceException.ERROR_CODES;
import com.tobeto.repository.ShelfRepository;

@Service
public class ShelfService {
	@Autowired
	private ShelfRepository shelfRepository;

	public List<Shelf> getAllShelves() {
		return shelfRepository.findAll();
	}

	public int createShelves(int capacity, int count) {
		if (count > 50) {
			count = 50;
		}
		for (int i = 0; i < count; i++) {
			Shelf shelf = new Shelf();
			shelf.setCapacity(capacity);
			shelfRepository.save(shelf);
		}
		return count;
	}

	public void deleteShelf(int id) {
		Optional<Shelf> oShelf = shelfRepository.findById(id);
		if (oShelf.isPresent()) {
			Shelf shelf = oShelf.get();
			if (shelf.getCount() > 0) {
				throw new ServiceException(ERROR_CODES.SHELF_HAS_PRODUCTS);
			}
			shelfRepository.deleteById(id);
		} else {
			throw new ServiceException(ERROR_CODES.SHELF_NOT_FOUND);
		}
	}

	public void updateShelf(int id, int capacity) {
		Optional<Shelf> oShelf = shelfRepository.findById(id);
		if (oShelf.isPresent()) {
			Shelf shelf = oShelf.get();
			if (capacity < shelf.getCount()) {
				throw new ServiceException(ERROR_CODES.SET_SHELF_COUNT);
			}
			shelf.setCapacity(capacity);
			shelfRepository.save(shelf);
		}

	}
}
