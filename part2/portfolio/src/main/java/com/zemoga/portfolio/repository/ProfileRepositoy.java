package com.zemoga.portfolio.repository;

import com.zemoga.portfolio.model.ProfileDTO;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepositoy extends CrudRepository<ProfileDTO,Integer> {

}
