package spm.bjmh.SPM2020BJMH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spm.bjmh.SPM2020BJMH.model.DriverModel;
import spm.bjmh.SPM2020BJMH.repository.DriverRepository;


@RestController
@RequestMapping(value = "/")
public class DriverController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    // get all driver
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<DriverModel> getAllDrivers() {
        LOG.info("Getting all users.");
        return driverRepository.findAll();
    }
}


