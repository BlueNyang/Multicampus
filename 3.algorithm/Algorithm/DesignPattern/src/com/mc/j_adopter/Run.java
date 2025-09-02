package com.mc.j_adopter;

import com.mc.j_adopter.user.UserController;
import com.mc.j_adopter.auth.AuthService;

public class Run {
    public static void main(String[] args) {
        UserController userController = new UserController(new AuthService());

        System.out.println(userController.googleLogin());

        System.out.println(userController.naverLogin());
    }
}
