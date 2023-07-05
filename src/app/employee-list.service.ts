import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Employee } from './employee';

@Injectable({
	providedIn:'root'
})

export class EmployeeListService{
	
	private url:string;
	
	constructor(private http:HttpClient){
		this.url="http://localhost:8080"
	}
	
	getDocuments(){
		return this.http.get<Employee[]>(this.url+'/allDocuments');
	}
	
}