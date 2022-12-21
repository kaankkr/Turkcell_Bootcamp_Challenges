package com.turkcell.TeknikServis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TeknikServis.model.Proposal;
import com.turkcell.TeknikServis.model.ProposalState;
import com.turkcell.TeknikServis.service.ProposalService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("proposal")
@AllArgsConstructor
public class ProposalController
{

	private ProposalService proposalService;

	@PostMapping(path = "save")
	public Proposal createProposal(@RequestBody Proposal proposal)
	{
		// {"product":{"id": 3}, "price" : 500,  "note" : "second proposal", "user" : {"id" : 1}}
		return proposalService.createProposal(proposal);
	}

	@GetMapping(path = "getById/{id}")
	public Proposal getById(@PathVariable(name = "id") Long id)
	{
		return proposalService.getById(id);
	}

	@GetMapping(path = "getAll")
	public List<Proposal> getAll()
	{
		return proposalService.getAll();
	}

	@GetMapping(path = "getAllByUser")
	public List<Proposal> getAllByUser(@RequestHeader(name = "userid") Long id)
	{
		return proposalService.getAllByUser(id);
	}

	@GetMapping(path = "getAllStatus")
	public List<Proposal> getAllStatus(@RequestParam(name = "state") ProposalState proposalState)
	{
		return proposalService.getAllStatus(proposalState);
	}

	@DeleteMapping(path = "deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id)
	{
		proposalService.deleteById(id);
		return ResponseEntity.ok("Başarı ile silindi");
	}

	@PutMapping(path = "editStatus/{id}")
	public Proposal editStatus(@PathVariable(name = "id") Long id, @RequestHeader(name = "status") boolean status)
	{
		return proposalService.editStatus(id, status);
	}
}