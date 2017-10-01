package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.service.OrderService;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {
	
	private final OrderService service;
	

	public OrderController(OrderService service) {
		this.service = service;
	}
	
	@ModelAttribute("order")
	public OrderRequest getForm() {
		return new OrderRequest();
	}
	
	 @GetMapping("/someth/{id}/table/{idTable}")
	  public String showT(Model model, @PathVariable Integer id, @PathVariable Integer idTable) {
		 model.addAttribute("meals", service.findAllMealByCafeId(id));
		 model.addAttribute("tableId",idTable);
	    model.addAttribute("cafeId", id);
	    return "order";
	 }
	 
	 @PostMapping("/someth/{id}/table/{idTable}")
		public String save( @PathVariable Integer id, @PathVariable Integer idTable,@ModelAttribute("order") OrderRequest request, SessionStatus status) {
		Table table=service.findOneTable(idTable);
		request.setTable(table);
		 service.save(request);
			return cancel(status);
		}
	 
	 @GetMapping("/someth/{id}/table/{idTable}/cancel")
		public String cancel(SessionStatus status) {
			status.setComplete();
			return "redirect:/profile/cafe/addtable/{id}";
		}
}
