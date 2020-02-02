import { Component, OnInit } from '@angular/core';
import { CompanyComponent } from '../company/company.component';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-companies',
  templateUrl: './getall-companies.component.html',
  styleUrls: ['./getall-companies.component.css']
})
export class GetallCompaniesComponent implements OnInit {
  success: string;

  companies: any;
  constructor(private userService: UserService, private router: Router) {
    this.getCompanies();
  }

  getCompanies() {
    this.userService.getAllCompaniesData().subscribe(response => {
      console.log(response);
      this.companies = response.company;
    }, err => {
      console.log(err);
    });
  }
  deleteCompany(company: any) {
    this.userService.deleteCompanyData(company).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.companies.splice(this.companies.indexOf(company), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  selectCompany(company) {
    this.userService.selectedCompanyToUpdate = company;
    this.router.navigateByUrl('/edit-company');
  }

  ngOnInit() {
  }

}
