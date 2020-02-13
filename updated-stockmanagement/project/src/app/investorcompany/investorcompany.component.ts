import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-investorcompany',
  templateUrl: './investorcompany.component.html',
  styleUrls: ['./investorcompany.component.css']
})
export class InvestorcompanyComponent implements OnInit {

  companies: any;
  constructor(private userService: UserService, private router: Router) {
    this.getCompanies();
  }

  ngOnInit() {
  }
  getCompanies() {
    this.userService.getAllCompaniesData().subscribe(response => {
      console.log(response);
      this.companies = response.company;
    }, err => {
      console.log(err);
    });
  }
  buy(company) {
    this.userService.selectedCompanyToUpdate = company;
    this.router.navigateByUrl('/buy-share');
  }

}
