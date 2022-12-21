package com.turkcell.TeknikServis.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TeknikServis.model.Proposal;
import com.turkcell.TeknikServis.model.ProposalState;

@Repository
public interface ProposalRepo extends JpaRepository<Proposal, Long>
{

	List<Proposal> findAllByUSERID(Long id);

	List<Proposal> findAllBySTATE(ProposalState state);
}