package com.zemoga.portfolio.repository;

import com.zemoga.portfolio.model.ProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfileDAO implements ProfileDAOInterface {
    @Autowired
    private ProfileRepositoy profileRepositoy;

    @Override
    public boolean save(ProfileDTO profileDTO) {
        profileRepositoy.save(profileDTO);
        return false;
    }

    @Override
    public List<ProfileDTO> findAll(){
        return (List) profileRepositoy.findAll();
    }

    @Override
    public Optional<ProfileDTO> findById(Integer id) {
        return profileRepositoy.findById(id);
    }
}
