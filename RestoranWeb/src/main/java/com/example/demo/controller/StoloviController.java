package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.HranaRepository;
import com.example.demo.repository.KategorijaHraneRepository;
import com.example.demo.repository.KategorijaPicaRepository;
import com.example.demo.repository.KolicinaHraneRepository;
import com.example.demo.repository.KolicinaPiceRepository;
import com.example.demo.repository.KonobarRepository;
import com.example.demo.repository.PiceRepository;
import com.example.demo.repository.PorudzbinaRepository;

import model.Hrana;
import model.Kategorijahrane;
import model.Kategorijapica;
import model.Kolicinahrane;
import model.Kolicinapica;
import model.Konobar;
import model.Pice;
import model.Porudzbina;

@Controller
@RequestMapping(value="/stolovi")
public class StoloviController {
	
	@Autowired
	PiceRepository pr;
	
	@Autowired
	HranaRepository hr;
	
	@Autowired
	KategorijaHraneRepository khr;
	
	@Autowired
	KategorijaPicaRepository kpr;
	
	@Autowired
	PorudzbinaRepository por;
	
	@Autowired
	KonobarRepository konr;
	
	@Autowired
	KolicinaHraneRepository kolr;
	
	@Autowired
	KolicinaPiceRepository kolp;
	
	@RequestMapping(value="/sto/{id}", method = RequestMethod.GET)
	public String sto(@PathVariable int id, HttpServletRequest request) {
		
		System.out.println("usao "+id);
		
		Map<Kategorijahrane, List<Hrana>> mapaHrane = new HashMap<Kategorijahrane, List<Hrana>>();
		Map<Kategorijapica, List<Pice>> mapaPica = new HashMap<Kategorijapica, List<Pice>>();
		
		List<Kategorijahrane> sveKategorijeHrane = khr.findAll();
		for(Kategorijahrane k : sveKategorijeHrane) {
			mapaHrane.put(k, new ArrayList<Hrana>());
		}
		
		List<Kategorijapica> sveKategorijePica = kpr.findAll();
		for(Kategorijapica k : sveKategorijePica) {
			mapaPica.put(k, new ArrayList<Pice>());
		}
		
		for(Hrana h : hr.findAll()) {
			mapaHrane.get(h.getKategorijahrane()).add(h);
		}
		
		for(Pice p : pr.findAll()) {
			mapaPica.get(p.getKategorijapica()).add(p);
		}
		
		Porudzbina staraPor = null;
		List<Porudzbina> svePorudzbine = por.findAll();
		for(Porudzbina p : svePorudzbine) {
			if(p.getIdStola() == id) {
				staraPor = p;
				System.out.println("nasao staru porudzbinu");
			}
		}
		
		if(staraPor != null) {
			request.getSession().setAttribute("narucenaHrana", staraPor.getKolicinahranes());
			request.getSession().setAttribute("narucenoPice", staraPor.getKolicinapicas());
		}
		
		
		request.getSession().setAttribute("idStola", id);
		request.getSession().setAttribute("svaHrana", mapaHrane);
		request.getSession().setAttribute("svoPice", mapaPica);
		
		return "porudzbina";
	}
	
	@RequestMapping(value="/dodaj/{id}", method = RequestMethod.GET)
	public String dodajHranuNaSto(@PathVariable int id, HttpServletRequest request) {
		
		Porudzbina staraPor = null;
		List<Porudzbina> svePorudzbine = por.findAll();
		for(Porudzbina p : svePorudzbine) {
			if(p.getIdStola() == Integer.parseInt(request.getSession().getAttribute("idStola").toString())) {
				staraPor = p;
			}
		}
		
		
		if(staraPor != null) {			
			
			List<Kolicinahrane> svaHrana = staraPor.getKolicinahranes();
			boolean sadrzi = false;
			
			for(Kolicinahrane kh : svaHrana) {
				if(kh.getHrana().getId() == id) {
					sadrzi = true;
					kh.setKolicina(kh.getKolicina() + 1);
					kolr.saveAndFlush(kh);
				}
			}
			if(!sadrzi) {
				Kolicinahrane kh = new Kolicinahrane();
				kh.setHrana(hr.getById(id));
				kh.setKolicina(1);
				kh.setPorudzbina(staraPor);
				kolr.saveAndFlush(kh);
			}
		} else {
			Porudzbina p = new Porudzbina();
			Kolicinahrane kol = new Kolicinahrane();
			Hrana h = hr.getById(id);
			kol.setHrana(h);
			kol.setKolicina(1);
			p.setIdStola(Integer.parseInt(request.getSession().getAttribute("idStola").toString()));
			List<Kolicinahrane> pom = new ArrayList<Kolicinahrane>();
			pom.add(kol);
			p.setKolicinahranes(pom);
			Konobar k = konr.getById(Integer.parseInt(request.getSession().getAttribute("idKonobara").toString()));
			p.setKonobar(k);
			
			por.saveAndFlush(p);
			kol.setPorudzbina(p);
			kolr.saveAndFlush(kol);
			
			
		}
		
		return "redirect:/stolovi/sto/" + Integer.parseInt(request.getSession().getAttribute("idStola").toString());
	}
	
	@RequestMapping(value="/dodajPice/{id}", method = RequestMethod.GET)
	public String dodajPiceNaSto(@PathVariable int id, HttpServletRequest request) {
		
		Porudzbina staraPor = null;
		List<Porudzbina> svePorudzbine = por.findAll();
		for(Porudzbina p : svePorudzbine) {
			if(p.getIdStola() == Integer.parseInt(request.getSession().getAttribute("idStola").toString())) {
				staraPor = p;
			}
		}
		
		
		if(staraPor != null) {			
			
			List<Kolicinapica> svoPice = staraPor.getKolicinapicas();
			boolean sadrzi = false;
			
			for(Kolicinapica kp : svoPice) {
				if(kp.getPice().getId() == id) {
					sadrzi = true;
					kp.setKolicina(kp.getKolicina() + 1);
					kolp.saveAndFlush(kp);
				}
			}
			if(!sadrzi) {
				Kolicinapica kp = new Kolicinapica();
				kp.setPice(pr.getById(id));
				kp.setKolicina(1);
				kp.setPorudzbina(staraPor);
				kolp.saveAndFlush(kp);
			}
		} else {
			Porudzbina p = new Porudzbina();
			Kolicinapica kol = new Kolicinapica();
			Pice pice = pr.getById(id);
			kol.setPice(pice);
			kol.setKolicina(1);
			p.setIdStola(Integer.parseInt(request.getSession().getAttribute("idStola").toString()));
			List<Kolicinapica> pom = new ArrayList<Kolicinapica>();
			pom.add(kol);
			p.setKolicinapicas(pom);
			Konobar k = konr.getById(Integer.parseInt(request.getSession().getAttribute("idKonobara").toString()));
			p.setKonobar(k);
			
			por.saveAndFlush(p);
			kol.setPorudzbina(p);
			kolp.saveAndFlush(kol);
			
			
		}
		
		return "redirect:/stolovi/sto/" + Integer.parseInt(request.getSession().getAttribute("idStola").toString());
	}
}
