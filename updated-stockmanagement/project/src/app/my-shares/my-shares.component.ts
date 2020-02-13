import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-shares',
  templateUrl: './my-shares.component.html',
  styleUrls: ['./my-shares.component.css']
})
export class MySharesComponent implements OnInit {

  shares: any[];
  companyData: any[];
  constructor(private userService: UserService, private router: Router) {
    this.getShares();
  }

  getShares() {
    this.userService.getAllSharesData(JSON.parse(localStorage.getItem('userDetails')).user[0].userId).subscribe(response => {
      console.log(response);
      this.shares = response.shareDetails;
      console.log(this.shares);
    }, err => {
      console.log(err);
    });
    this.userService.getAllCompaniesData().subscribe(response => {
      console.log(response);
      this.companyData = response.company;
      console.log(this.companyData);

      this.shares = this.shares.map(share => {
        this.companyData.map(company => {
          // tslint:disable-next-line: triple-equals
          if (company.companyId == share.companyId){
            share.companyDetails  = company;
          }
        })
        return share;
      });
      console.log('shares', this.shares)
    }, err => {
      console.log(err);
    });
  }

  sell(shId) {
    this.userService.selectedSharesToUpdate = this.shares.find(share => share.shareId == shId);
    this.router.navigateByUrl('/sell-share');
  }

  ngOnInit() {
  }

}
