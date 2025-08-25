package com.wipro.employemanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.employemanagement.dto.EmployeeDTO;
import com.wipro.employemanagement.dto.ProjectDTO;
import com.wipro.employemanagement.entity.Project;
import com.wipro.employemanagement.exception.ProjectNotFoundException;
import com.wipro.employemanagement.feign.EmployeeServiceClient;
import com.wipro.employemanagement.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	public ProjectDTO createProject(ProjectDTO projectDTO) {
		Project project = convertToEntity(projectDTO);
		Project savedProject = projectRepository.save(project);
		return convertToDTO(savedProject);
	}

	public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
	    Optional<Project> existingProject = projectRepository.findById(id);
	    if (existingProject.isPresent()) {
	        Project project = existingProject.get();
	        updateProjectFields(project, projectDTO);
	        Project savedProject = projectRepository.save(project);
	        return convertToDTO(savedProject);
	    }
	    throw new ProjectNotFoundException("Project not found with id: " + id);
	}

	public void deleteProject(Long id) {
	    if (projectRepository.existsById(id)) {
	        projectRepository.deleteById(id);
	    } else {
	        throw new ProjectNotFoundException("Project not found with id: " + id);
	    }
	}

	public ProjectDTO getProjectById(Long id) {
	    Optional<Project> project = projectRepository.findById(id);
	    if (project.isPresent()) {
	        return convertToDTOWithEmployees(project.get());
	    }
	    throw new ProjectNotFoundException("Project not found with id: " + id);
	}

	public List<EmployeeDTO> getEmployeesAssignedToProject(Long projectId) {
	    Optional<Project> project = projectRepository.findById(projectId);
	    if (project.isPresent() && project.get().getEmployeeIds() != null) {
	        List<Long> employeeIds = project.get().getEmployeeIds().stream().toList();
	        return employeeServiceClient.getEmployeesByIds(employeeIds);
	    }
	    throw new ProjectNotFoundException("Project not found with id: " + projectId);
	}
	public List<ProjectDTO> getAllProjects() {
		List<Project> projects = projectRepository.findAll();
		return projects.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	

	public List<ProjectDTO> getProjectsForEmployee(Long employeeId) {
		List<Project> projects = projectRepository.findProjectsByEmployeeId(employeeId);
		return projects.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	private Project convertToEntity(ProjectDTO dto) {
		Project project = new Project();
		project.setName(dto.getName());
		project.setDescription(dto.getDescription());
		project.setStartDate(dto.getStartDate());
		project.setEndDate(dto.getEndDate());
		project.setEmployeeIds(dto.getEmployeeIds());
		return project;
	}

	private ProjectDTO convertToDTO(Project project) {
		ProjectDTO dto = new ProjectDTO();
		dto.setId(project.getId());
		dto.setName(project.getName());
		dto.setDescription(project.getDescription());
		dto.setStartDate(project.getStartDate());
		dto.setEndDate(project.getEndDate());
		dto.setEmployeeIds(project.getEmployeeIds());
		if (project.getEmployeeIds() != null && !project.getEmployeeIds().isEmpty()) {
			List<Long> employeeIds = project.getEmployeeIds().stream().toList();
			List<EmployeeDTO> employees = employeeServiceClient.getEmployeesByIds(employeeIds);
			System.out.println(employees);
			dto.setEmployees(employees);
		}
		return dto;
	}

	private ProjectDTO convertToDTOWithEmployees(Project project) {
		ProjectDTO dto = convertToDTO(project);

		// Get employee details using Feign client
		if (project.getEmployeeIds() != null && !project.getEmployeeIds().isEmpty()) {
			List<Long> employeeIds = project.getEmployeeIds().stream().toList();
			List<EmployeeDTO> employees = employeeServiceClient.getEmployeesByIds(employeeIds);
			System.out.println(employees);
			dto.setEmployees(employees);
		}

		return dto;
	}

	private void updateProjectFields(Project project, ProjectDTO dto) {
		if (dto.getName() != null)
			project.setName(dto.getName());
		if (dto.getDescription() != null)
			project.setDescription(dto.getDescription());
		if (dto.getStartDate() != null)
			project.setStartDate(dto.getStartDate());
		if (dto.getEndDate() != null)
			project.setEndDate(dto.getEndDate());
		if (dto.getEmployeeIds() != null)
			project.setEmployeeIds(dto.getEmployeeIds());
	}

	public List<ProjectDTO> findByEmployeeIdsIn(List<Long> employeeIds) {
		 List<Project> projectsByEmployeeIds = projectRepository.findProjectsByEmployeeIds(employeeIds);
		 System.out.println(projectsByEmployeeIds);
		 List<ProjectDTO> list = projectsByEmployeeIds.stream().map(this::convertToDTO).collect(Collectors.toList());
		 return list;
	}
}