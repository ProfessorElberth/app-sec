package br.com.infnet.appsec.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

	private static Map<Integer, String> jogos = new HashMap<Integer, String>();
	static {
		jogos.put(1, "Botafogo x Vasco");
		jogos.put(2, "São Paulo x River Plate");
		jogos.put(3, "Independiente del Valle x Flamengo");
	}

	@GetMapping
	public String app(
				Model model
			) {
		model.addAttribute("acesso", "/login");
		
		return "app";
	}
	
	@GetMapping("/home")
	public String home(
				Model model
			) {
		model.addAttribute("acesso", "/logout");
		
		model.addAttribute("jogos", jogos);
		
		return "home";
	}
	
	@GetMapping("/jogo/{key}/excluir")
	public String excluir(
				@PathVariable Integer key
			) {
		jogos.remove(key);
		
		return "redirect:/home";
	}
}