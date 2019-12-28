package com.zemoga.portfolio.repository;

import com.zemoga.portfolio.model.ProfileDTO;

import java.util.List;
import java.util.Optional;

public interface ProfileDAOInterface {
    boolean save(ProfileDTO profileDTO);
    List<ProfileDTO> findAll();
    Optional<ProfileDTO> findById(Integer id);
}
