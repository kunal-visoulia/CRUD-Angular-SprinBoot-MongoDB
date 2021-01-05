import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import {EmployeeService} from '../employee-service.service';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Array<Employee> = [];
  constructor(private empservice:EmployeeService,private router:Router) { }

  ngOnInit(): void {
    this.empservice.getEmployees().subscribe(data=>{
      this.employees = data;
    });
  }
  updateEmp(id:Number){
    this.router.navigate(["update",id]);
  }
  empDetails(id:Number){
    this.router.navigate(["details",id]);
  }
  deleteEmp(id:Number){
    this.empservice.deleteEmployee(id).subscribe(data=>{
      console.log(data);
      this.empservice.getEmployees().subscribe(data=>{
        this.employees = data;
      });
    });
  }

}
