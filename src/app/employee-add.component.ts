import { Component } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { EmployeeAddService } from './employee-add.service';
import { Employee } from './employee';

@Component({
	selector : 'employee-add',
	templateUrl : './employee-add.component.html'
})

export class EmployeeAddComponent{
	
	formValue!: FormGroup;
	
	public employee: Employee;
	
	constructor(private employeeservice: EmployeeAddService){
		this.employee = new Employee();
	}
	
	onSubmit(form: NgForm){
		this.employeeservice.addEmployee(this.employee).subscribe();
		form.resetForm();
	}
	
}