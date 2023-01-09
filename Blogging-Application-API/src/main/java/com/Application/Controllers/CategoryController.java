package com.Application.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.Payloads.ApiResponse;
import com.Application.Payloads.CategoryDto;
import com.Application.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto createCategory =  this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		
		CategoryDto updatedCategory =  this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}

	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> DeleteCategory(@PathVariable Integer categoryId){
		
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully !! ", true) , HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		CategoryDto categoryDto =  this.categoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);

	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		List<CategoryDto> AllcategoryDto =  this.categoryService.getCategories();
		return ResponseEntity.ok(AllcategoryDto);
	}
	
	

	
	
}
