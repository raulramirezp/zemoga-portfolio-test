package com.zemoga.portfolio.service;

import com.zemoga.portfolio.model.ProfileDTO;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<ProfileDTO> getAllProfiles();
    Optional<ProfileDTO> getUserProfile(Integer id);
    ProfileDTO createUserProfile(ProfileDTO profileDTO);
}
