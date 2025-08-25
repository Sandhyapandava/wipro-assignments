package com.wipro.employemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.employemanagement.dto.EmployeeDTO;
import com.wipro.employemanagement.dto.ProjectDTO;
import com.wipro.employemanagement.service.ProjectService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/projects")
@Tag(name = "Project API", description = "Operations related to projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping
	public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
		ProjectDTO createdProject = projectService.createProject(projectDTO);
		return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
		ProjectDTO updatedProject = projectService.updateProject(id, projectDTO);
		return ResponseEntity.ok(updatedProject);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDTO> getProject(@PathVariable Long id) {
		ProjectDTO project = projectService.getProjectById(id);
		return ResponseEntity.ok(project);
	}

	@GetMapping
	public ResponseEntity<List<ProjectDTO>> getAllProjects() {
		List<ProjectDTO> projects = projectService.getAllProjects();
		return ResponseEntity.ok(projects);
	}

	@GetMapping("/{id}/employees")
	public ResponseEntity<List<EmployeeDTO>> getEmployeesAssignedToProject(@PathVariable Long id) {
		List<EmployeeDTO> employees = projectService.getEmployeesAssignedToProject(id);
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<ProjectDTO>> getProjectsForEmployee(@PathVariable Long employeeId) {
		List<ProjectDTO> projects = projectService.getProjectsForEmployee(employeeId);
		return ResponseEntity.ok(projects);
	}

	@GetMapping("/by-employee-ids")
	public List<ProjectDTO> getProjectsByEmployeeIds(@RequestParam List<Long> employeeIds) {
		return projectService.findByEmployeeIdsIn(employeeIds);
	}
}
