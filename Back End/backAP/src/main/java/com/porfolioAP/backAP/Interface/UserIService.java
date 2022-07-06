package com.porfolioAP.backAP.Interface;


import com.porfolioAP.backAP.Entity.User;

import java.util.List;

public interface UserIService {
    //traer una lista de User
    public List<User> getUser();

    //guardar un objeto de tipo User
    public void saveUser(User user);

    //eliminar User por Id
    public void deleteUser(Long id);

    //buscar User por Id
    public User findUser(Long id);
}
