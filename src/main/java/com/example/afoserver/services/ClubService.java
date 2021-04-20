package com.example.afoserver.services;

import com.example.afoserver.models.Club;
import com.example.afoserver.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    ClubRepository clubRepository;

    public Club createClub(Club club) {
        return clubRepository.save(club);
    }

    public List<Club> findAllClubs() {
        return (List<Club>) clubRepository.findAll();
    }

    public Club findClubById(Long clubId) {
        return clubRepository.findById(clubId).get();
    }


}
