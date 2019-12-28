package com.zemoga.portfolio.service;

import com.zemoga.portfolio.model.ProfileDTO;
import com.zemoga.portfolio.repository.ProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfileServiceImp implements ProfileService{

    private ProfileDAO profileDAO;

    @Autowired
    public ProfileServiceImp(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        return profileDAO.findAll();
    }

    @Override
    public Optional<ProfileDTO> getUserProfile(Integer id) {
        return profileDAO.findById(id);
    }

    @Override
    public ProfileDTO createUserProfile(ProfileDTO profileDTO) {
        profileDAO.save(profileDTO);
        return profileDTO;
    }
}
