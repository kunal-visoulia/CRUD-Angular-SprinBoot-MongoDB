import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee-service.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employee:Employee = new Employee();
  constructor(private empService:EmployeeService,private router:Router) { }

  ngOnInit(): void {
  }

addEmployee(){
this.empService.addEmployee(this.employee).subscribe(data => {
  console.log(data);
  this.router.navigate(['/employees']);
},
error=>console.log(error)
);

}

}
