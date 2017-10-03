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

import ua.entity.Status;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.request.TableRequest;
import ua.service.OrderService;
import ua.service.TableService;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {
	
	private final OrderService service;
	
	private final TableService tableService;
	

	public OrderController(OrderService service,TableService tableService) {
		this.service = service;
		this.tableService = tableService;
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
	 
	 @GetMapping("/allorders/{id}")
	 public String showOrders(Model model, @PathVariable Integer id){
		 model.addAttribute("orders",service.findAllOrdersByCafeId(id));
		 model.addAttribute("accepted", Status.ACCEPTED.toString());
		model.addAttribute("completed", Status.COMPLETED.toString());
		model.addAttribute("paid", Status.PAID.toString());
		model.addAttribute("cafeId", id);
		//model.addAttribute("idTable", idTable);
		 return "orderManager";
	 }
	 
	 
	 
	 @GetMapping("/{cafeId}/{idTable}/paid/{idOrder}")
	 public String paid(@PathVariable Integer idOrder,@PathVariable Integer cafeId, @PathVariable Integer idTable) {
		    service.setPaid(idOrder);
		    TableRequest request=tableService.findOne(idTable);
		    if(request.getIsFree()==false){
		    	request.setIsFree(true);
			    request.setUser(null);
			    request.setUserPhone(null);
			    request.setTimeReserv(tableService.findOneOpenClose(1));
			    tableService.saveReserv(request);
		    }
		    return "redirect:/order/allorders/{cafeId}";
		 }
	 
	 @GetMapping("/{cafeId}/{idTable}/completed/{idOrder}")
	 public String completed(@PathVariable Integer idOrder,@PathVariable Integer cafeId, @PathVariable Integer idTable) {
		    service.setCompleted(idOrder);;
		    return "redirect:/order/allorders/{cafeId}";
		 }
}
