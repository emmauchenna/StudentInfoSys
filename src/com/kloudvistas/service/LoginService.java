package com.kloudvistas.service;

import com.kloudvistas.domains.Student;

public interface LoginService {
    Student login(String username, String password);
    void logout(String username);
}
