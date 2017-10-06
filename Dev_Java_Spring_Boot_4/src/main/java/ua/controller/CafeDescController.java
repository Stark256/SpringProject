package ua.controller;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.CafeComment;
import ua.model.request.CafeCommentRequest;
import ua.model.request.CafeRequest;
import ua.service.CafeCommentService;
import ua.service.CafeIndexService;
import ua.service.CafeService;

@Controller
@RequestMapping("/cafedesc")
@SessionAttributes("comment")
public class CafeDescController {

private final CafeService service;
private final CafeIndexService indexService;
private final CafeCommentService commentService;
	
	@Autowired
	public CafeDescController(CafeService service,CafeIndexService indexService,CafeCommentService commentService) {
		this.service = service;
		this.indexService=indexService;
		this.commentService=commentService;
	}
	
	@GetMapping("/{id}")
	public String desc(@PathVariable Integer id, Model model){
		model.addAttribute("cafe", service.findOne(id));
		model.addAttribute("meals", indexService.findMealByCafeId(id));
		model.addAttribute("comments", commentService.findAllCommentByCafeId(id));
		return "cafedesc";
	}
	
	@PostMapping("/{id}")
	public String saveComment(@ModelAttribute("comment") CafeCommentRequest commentRequest,@PathVariable Integer id, SessionStatus status,Model model) {
		if(commentRequest.getUser().isEmpty()||commentRequest.getComment().isEmpty()){
			if(commentRequest.getUser().isEmpty()) model.addAttribute("emptyUser",true);
			if(commentRequest.getComment().isEmpty()) model.addAttribute("emptyComment",true);
			return desc(id, model);
		}
		List<CafeComment> comment=commentService.findCommentByCafeId(id);
		BigDecimal rate=BigDecimal.ZERO;
		int count=0;
		for (CafeComment cafeComment : comment) {
			if(cafeComment.getRate()!=null){
				rate=rate.add(cafeComment.getRate());
				count++;
			}
		}
		CafeRequest request=service.findOne(id);
		request.setRate(rate.divide(new BigDecimal(count)));
		service.saveRate(request);
		commentService.saveComment(commentRequest, id);
		return cancel(status);
	}
	
	
	@ModelAttribute("comment")
	public CafeCommentRequest getFormComment() {
		return new CafeCommentRequest();
	}
	
	@GetMapping("/{id}/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafedesc/{id}";
	}	
	
	
}
