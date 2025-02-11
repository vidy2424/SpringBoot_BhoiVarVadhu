package com.springboot.bhoivarvadhu.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bhoivarvadhu.dto.TeamMembers;

@Service
public interface TeamMemberDAO {

	TeamMembers getid(int id);

	boolean addTeamMember(TeamMembers teamMembers);

	boolean update(TeamMembers teamMembers);

	 
	boolean deleteTeamMembers(int id);
	
	List<TeamMembers> getAllTeamMembers();

	List<TeamMembers> getTeamMembersbyID(int id);

	
}
