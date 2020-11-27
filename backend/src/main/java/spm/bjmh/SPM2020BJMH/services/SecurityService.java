package spm.bjmh.SPM2020BJMH.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}