package com.benxinm.bookapp.Service;

import com.benxinm.bookapp.entity.User;

public interface UserService {
    User getByAccount(String account);
    boolean checkExist(String account);
    int insertUser(String account,String psd);
    Boolean getPsd (String account,String providedPsd);
}
