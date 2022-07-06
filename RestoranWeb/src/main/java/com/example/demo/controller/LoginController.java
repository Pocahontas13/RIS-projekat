package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.KonobarRepository;

import model.Konobar;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	KonobarRepository kr;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("sifra") Integer sifra, HttpServletRequest request) {

		List<Konobar> konobari = kr.findAll();
		int id = -1;
		for (Konobar k : konobari) {
			if (k.getSifra() == sifra)
				id = k.getId();
		}
		
		if(id != -1) {
			request.getSession().setAttribute("idKonobara", id);	
			return "stolovi";
		} else {
			return "login";
		}

	}
}
