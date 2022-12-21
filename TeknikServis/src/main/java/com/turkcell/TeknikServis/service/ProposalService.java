package com.turkcell.TeknikServis.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.model.Proposal;
import com.turkcell.TeknikServis.model.ProposalState;
import com.turkcell.TeknikServis.repo.ProposalRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProposalService
{
	private ProposalRepo proposalRepo;
	
	private EntityManager em;

	public Proposal createProposal(Proposal proposal)
	{
		proposal.setPROPOSALDATE(new Date());
		proposal.setSTATE(ProposalState.PENDING);
		proposal = proposalRepo.save(proposal);
		em.clear();
		
		return proposalRepo.findById(proposal.getId()).get();
	}

	public Proposal getById(Long id)
	{
		return proposalRepo.findById(id).get();
	}

	public void deleteById(Long id)
	{
		proposalRepo.deleteById(id);
	}

	public List<Proposal> getAll()
	{
		return proposalRepo.findAll();
	}

	public Proposal editStatus(Long id, boolean status)
	{
		Proposal prop = proposalRepo.findById(id).get();
		prop.setSTATE(status ? ProposalState.APPROVED : ProposalState.DENIED);
		proposalRepo.save(prop);
		
		return proposalRepo.findById(id).get();
	}

	public List<Proposal> getAllByUser(Long userid)
	{
		return proposalRepo.findAllByUSERID(userid);
	}

	public List<Proposal> getAllStatus(ProposalState state)
	{
		return proposalRepo.findAllBySTATE(state);
	}
}