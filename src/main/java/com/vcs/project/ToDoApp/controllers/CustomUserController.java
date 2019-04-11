package com.vcs.project.ToDoApp.controllers;

import com.vcs.project.ToDoApp.services.IToDoListCustomService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomUserController {

    @Autowired
    private IToDoListCustomService customService;

}
