import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee-service.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  employee:Employee = new Employee();
  id : Number;
  constructor(private empService:EmployeeService,private route:ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.empService.getEmployeeDetails(this.id).subscribe(data=>{
      this.employee = data;
    });
  }
updateEmployee(){
this.empService.updateEmployee(this.id,this.employee).subscribe(data=>{
  console.log(data);
  this.router.navigate(["/employees"]);
});
}
}
