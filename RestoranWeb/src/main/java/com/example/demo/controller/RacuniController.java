package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.KasaRepository;
import com.example.demo.repository.PorudzbinaRepository;

import model.Kolicinahrane;
import model.Kolicinapica;
import model.Porudzbina;
import model.Racun;

@Controller
@RequestMapping(value="/kasa")
public class RacuniController {

	@Autowired
	KasaRepository kr;
	
	@Autowired
	PorudzbinaRepository pr;
	
	@RequestMapping(value="/pregled", method = RequestMethod.GET)
	public String sto(HttpServletRequest request) {
		List<Racun> racuni = kr.findAll();
		request.getSession().setAttribute("racuni", racuni);
		return "stolovi";
	}
	
	
	@RequestMapping(value="/zaduzenja", method = RequestMethod.GET)
	public String zaduzenja(HttpServletRequest request) {
		
		int id = (int) request.getSession().getAttribute("idKonobara");
		System.out.println("konobar " + id);
		
		List<Porudzbina> svePorudzbine = pr.findAll();
		List<Porudzbina> zaduzenja = new ArrayList<Porudzbina>();
		double suma = 0.0;
		
		for(Porudzbina p : svePorudzbine) {
			if(p.getKonobar().getId() == id && p.getRacun() == null) {
				zaduzenja.add(p);
				for(Kolicinapica kp : p.getKolicinapicas()) {
					suma += kp.getKolicina() * kp.getPice().getCena();
				}
				
				for(Kolicinahrane kh : p.getKolicinahranes()) {
					suma += kh.getKolicina() * kh.getHrana().getCena();
				}
			}
		}
		
		request.getSession().setAttribute("zaduzenja", zaduzenja);
		request.getSession().setAttribute("suma", suma);
		
		return "stolovi";
	}
}

