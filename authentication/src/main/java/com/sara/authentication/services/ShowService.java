package com.sara.authentication.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sara.authentication.models.Show;
import com.sara.authentication.models.User;
import com.sara.authentication.repositories.ShowRepository;

@Service
public class ShowService {
private final ShowRepository showRepository;
    
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }
    
    public List<Show> allShows() {
        return (List<Show>)showRepository.findAll();
    }
    
    public Show findById(Long id) {
    	Optional<Show> optionalShow = showRepository.findById(id);
        if(optionalShow.isPresent()) {
            return optionalShow.get();
        } else {
            return null;
        }
    }
    
    public Show findByTitle(String title) {
        return showRepository.findByTitle(title);
    }
    
    public Show createShow(Show sh) {
        return showRepository.save(sh);
    }
  
    public void updateShow(@Valid Show show) {
    	Optional<Show> optionalBook = showRepository.findById(show.getId());
        if(optionalBook.isPresent()) {
        	optionalBook.get().setTitle(show.getTitle());
        	optionalBook.get().setNetwork(show.getNetwork());
        	showRepository.save(optionalBook.get());
        }
    }
    
    public void deleteShow(Long id) {
    	Optional<Show> optionalShow = showRepository.findById(id);
        if(optionalShow.isPresent()) {
        	showRepository.deleteById(id);
        }
    }
}
