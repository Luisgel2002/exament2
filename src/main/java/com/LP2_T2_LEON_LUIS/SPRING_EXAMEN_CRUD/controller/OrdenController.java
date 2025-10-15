package com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.model.OrdenCompra;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.service.OrdenCompraService;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.service.ProveedorService;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.service.RubroService;
import com.LP2_T2_LEON_LUIS.SPRING_EXAMEN_CRUD.util.Alert;

import org.springframework.ui.Model;

@Controller
@RequestMapping("orden")
public class OrdenController {

	@Autowired
	private RubroService rubroService;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private OrdenCompraService ordenCompraService;
	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrden", ordenCompraService.getAll());
		return "orden/listado";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedor", proveedorService.getAll());
		model.addAttribute("lstRubro", rubroService.getAll());
		model.addAttribute("OrdenCompra", new OrdenCompra());
		return "orden/nuevo";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompra ordencompra, Model model, RedirectAttributes flash) {
		
		var response = ordenCompraService.create(ordencompra);
		
		if (!response.success) {
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje));
			model.addAttribute("lstProveedor", proveedorService.getAll());
			model.addAttribute("lstRubro", rubroService.getAll());
			return "orden/nuevo";
		}
	
		flash.addFlashAttribute("toast", Alert.sweetToast(response.mensaje, "success", 5000));
		return "redirect:/orden/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("lstProveedor", proveedorService.getAll());
		model.addAttribute("lstRubro", rubroService.getAll());
		model.addAttribute("ordencompra", ordenCompraService.getOne(id));
		return "orden/edicion";
	}
	
	
}
