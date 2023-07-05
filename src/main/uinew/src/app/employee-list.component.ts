import { Component } from '@angular/core';
import {EmployeeListService } from './employee-list.service';
import { Employee } from './employee';
@Component({
	selector : 'employee-list',
	templateUrl : './employee-list.component.html'
})
export class EmployeeListComponent{
	
	employee : Employee[] = [];
	
	constructor(private employeelistservice: EmployeeListService){}
	
	ngOnInit(){
		this.employeelistservice.getDocuments().subscribe(data => {
			this.employee = data;
		})
	}
	
	
}