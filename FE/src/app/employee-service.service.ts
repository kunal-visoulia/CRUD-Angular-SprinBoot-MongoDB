import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Employee } from './employee';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  getEmployees():Observable<Employee[]>{
    return this.http.get<Employee[]>("http://localhost:8080/api/v1/employees");
  }

  addEmployee(emp:Employee): Observable<Object>{
    return this.http.post<Employee>("http://localhost:8080/api/v1/employee",emp);
  }

  getEmployeeDetails(id:Number):Observable<Employee>{
    return this.http.get<Employee>("http://localhost:8080/api/v1/employees/"+id);
  }

  updateEmployee(id:Number,emp:Employee):Observable<Object>{
    return this.http.put("http://localhost:8080/api/v1/employee/"+id,emp);
  }

  deleteEmployee(id:Number):Observable<Object>{
    return this.http.delete("http://localhost:8080/api/v1/employee/"+id);
  }

}
