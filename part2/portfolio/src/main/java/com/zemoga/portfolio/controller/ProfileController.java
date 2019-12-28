package com.zemoga.portfolio.controller;

import com.zemoga.portfolio.error.ResourceNotFound;
import com.zemoga.portfolio.model.ProfileDTO;
import com.zemoga.portfolio.service.ProfileService;
import com.zemoga.portfolio.service.ProfileServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileServiceImp profileServiceImp){
        this.profileService = profileServiceImp;
    }

    @ResponseBody
    @RequestMapping(value ="zemoga-portfolio-api/modify-user-info", method = RequestMethod.POST)
    public ProfileDTO createUserProfile(@RequestBody ProfileDTO profileDTO){
        return profileService.createUserProfile(profileDTO);
    }

    @ResponseBody
    @RequestMapping(value ="zemoga-portfolio-api/user-info", method = RequestMethod.GET)
    public List<ProfileDTO> getAllUserProfiles(){
        return profileService.getAllProfiles();
    }

    @ResponseBody
    @RequestMapping(value ="zemoga-portfolio-api/user-info/{id}", method = RequestMethod.GET)
    public ProfileDTO getUserProfile(@PathVariable Integer id){
        Optional<ProfileDTO> result = profileService.getUserProfile(id);
        if(result.isPresent()) return result.get();
        else throw new ResourceNotFound();
    }

}
