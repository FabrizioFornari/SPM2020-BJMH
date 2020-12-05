package spm.bjmh.SPM2020BJMH.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spm.bjmh.SPM2020BJMH.models.Driver;
import spm.bjmh.SPM2020BJMH.repositories.DriverRepository;

@Component
public class BootStrapData  implements CommandLineRunner {
    private final DriverRepository driverRepository;

    public BootStrapData(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        driverRepository.deleteAll();
        Driver driver = new Driver("5", "t", "t", "455678", "mi.pe@gmail.com", "6tyuunk", 345678, false);
        driverRepository.save(driver);


    }
}
