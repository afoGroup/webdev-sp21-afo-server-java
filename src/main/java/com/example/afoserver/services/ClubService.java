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

    //    Do I need to set all (see updateUser)? Or if the Request body includes all the info can I just pass and save?
    public int updateClub(Club newClub) {
        try {
            clubRepository.save(newClub);
            return 0;
        }
        catch (Exception e) {
            return 1;
        }
    }

    public int deleteClub(Long clubId) {
        try {
            clubRepository.deleteById(clubId);
            return 0;
        }
        catch (Exception e) {
            return 1;
        }
    }

}
