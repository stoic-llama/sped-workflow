package edu.ccsu.sped.workflow.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ccsu.sped.workflow.models.Persons;
import edu.ccsu.sped.workflow.services.PersonsService;


@Controller
public class PersonsController {

	@Autowired
	private PersonsService personsService;
	
	@GetMapping("/matching")
	public String getPersons(Model model) {
		model.addAttribute("persons", personsService.getPersons());
		return "matching";
	}	
	
	@GetMapping("/oneperson")
	@ResponseBody
	public Optional<Persons> getPersonById(Integer Id, Model model ) {
		return personsService.getPersonById(Id); 
	}
	
	@RequestMapping(value="/save", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
	public String updatePerson(Persons persons) {
		personsService.updatePerson(persons);;
		return "redirect:/persons"; // redirect refreshes the HTML after updating database
	}
	
	@RequestMapping(value="/addNew", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
	public String addPerson(Persons person) {
		personsService.addPerson(person);;
		return "redirect:/persons"; // redirect refreshes the HTML after updating database
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
	public String deletePerson(Integer Id) {
		personsService.deletePersonById(Id);
		return "redirect:/persons"; // redirect refreshes the HTML after updating database
	}
}
