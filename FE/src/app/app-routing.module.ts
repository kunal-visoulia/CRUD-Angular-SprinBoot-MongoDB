import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {path:"employees", component:EmployeeListComponent},
  {path:"add", component:CreateEmployeeComponent},
  {path:"details/:id", component:EmployeeDetailsComponent},
  {path:"update/:id", component:UpdateEmployeeComponent},
  {path:'', redirectTo:"employees", pathMatch:"full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
