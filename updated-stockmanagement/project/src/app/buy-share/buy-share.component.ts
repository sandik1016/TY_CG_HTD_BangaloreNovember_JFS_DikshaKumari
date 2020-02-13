import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-buy-share',
  templateUrl: './buy-share.component.html',
  styleUrls: ['./buy-share.component.css']
})
export class BuyShareComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }
  success: any;
  failure: any;

  isMaxValid: boolean;
  isStockAvailValid: boolean;

  ngOnInit() {
  }
  setPrice() {
    // tslint:disable-next-line: max-line-length
    this.userService.selectedCompanyToUpdate.price =   this.userService.selectedCompanyToUpdate.quantity *  this.userService.selectedCompanyToUpdate.bidPrice;
    this.setQuantity();
  }

  setQuantity() {
    if(this.userService.selectedCompanyToUpdate.maxStockQuantity > this.userService.selectedCompanyToUpdate.quantity ) {
     this.isMaxValid = false;
    }else{
      this.isMaxValid = true;
    }
    if(this.userService.selectedCompanyToUpdate.stockAvailability > this.userService.selectedCompanyToUpdate.quantity ) {
      this.isStockAvailValid = false;
     }else{
       this.isStockAvailValid = true;
     }
  }

  buyshare(price) {

    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    console.log(userDetails);
    const rqObj = {
      userId: userDetails.user[0].userId,
      companyId: this.userService.selectedCompanyToUpdate.companyId,
      totalSharesTransacted: this.userService.selectedCompanyToUpdate.quantity,
      totalAmount: this.userService.selectedCompanyToUpdate.price
    };

    console.log(rqObj);
    this.userService.buyShare(rqObj).subscribe(data => {

      if (data.statusCode === 201) {
        console.log(data);
        this.success = data.description;
        // this.router.navigateByUrl('/investor-company');

      } else {
        console.log(data);
        this.failure = data.description;
      }
      setTimeout(() => {
        this.success = null;
        this.failure = null;
      }, 2000);
      this.router.navigateByUrl('/investor-company');
    });
  }
}
