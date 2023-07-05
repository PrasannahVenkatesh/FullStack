import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './employee';

@Injectable({
	providedIn:'root'
})

export class EmployeeAddService{
	
	private url: string;
	
	constructor(private http: HttpClient){
		this.url = "http://localhost:8080"
	}
	
	addEmployee(employee: Employee){
		alert("Added Successfully");
		return this.http.post<Employee>(this.url+"/createDocument",employee);
	}
}