import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee-service.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
employee : Employee = new Employee();
  constructor(private empService:EmployeeService, private router:ActivatedRoute) { }

  ngOnInit(): void {
    let id = this.router.snapshot.params['id'];
    this.empService.getEmployeeDetails(id).subscribe(data=>{
      this.employee = data;
    });
  }


}
