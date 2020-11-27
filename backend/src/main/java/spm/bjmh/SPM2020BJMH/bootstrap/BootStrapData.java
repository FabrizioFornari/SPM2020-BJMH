package spm.bjmh.SPM2020BJMH.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spm.bjmh.SPM2020BJMH.models.DriverModel;
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
        DriverModel driver = new DriverModel("miriam.petrocchi@gmail.com", "Miriam", "Petrocchi", "EF345GR", "123456", "33255546675", false);
        driverRepository.save(driver);


    }
}
