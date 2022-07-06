package com.porfolioAP.backAP.Controller;

import com.porfolioAP.backAP.Entity.User;
import com.porfolioAP.backAP.Interface.UserIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired UserIService userIService;

    @GetMapping("/user/get")
    public List<User> getUser(){
        return userIService.getUser();
    }

    @PostMapping("/user/create")
    public String createUser(@RequestBody User user){
        userIService.saveUser(user);
        return "El Usuario ha sido creado exitósamente.";
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userIService.deleteUser(id);
        return "El Usuario ha sido eliminado exitósamente.";
    }

    @PutMapping("/user/edit/{id}")
    public User editUser(@PathVariable Long id,
                         @RequestParam("us_nombre") String newUsNombre,
                         @RequestParam("us_apellido") String newUsApellido,
                         @RequestParam("us_img") String newUsImg,
                         @RequestParam("us_titulo") String newUsTitulo,
                         @RequestParam("us_descripcion") String newUsDescripcion){
        User user = userIService.findUser(id);

        user.setUs_nombre(newUsNombre);
        user.setUs_apellido(newUsApellido);
        user.setUs_img(newUsImg);
        user.setUs_titulo(newUsTitulo);
        user.setUs_descripcion(newUsDescripcion);

        userIService.saveUser(user);
        return user;
    }

    @GetMapping("/user/get/perfil")
    public User findUser(){
        return userIService.findUser((long)1);
    }
}
