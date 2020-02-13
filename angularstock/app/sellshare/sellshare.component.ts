import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sellshare',
  templateUrl: './sellshare.component.html',
  styleUrls: ['./sellshare.component.css']
})
export class SellshareComponent implements OnInit {
  failure: any;
  success: any;

  constructor(public userService: UserService, private router: Router) {
    console.log(this.userService.selectedSharesToUpdate);
   }

  ngOnInit() {
  }
  setPrice() {
    // tslint:disable-next-line: max-line-length
    this.userService.selectedSharesToUpdate.price =   this.userService.selectedSharesToUpdate.quantity *  this.userService.selectedSharesToUpdate.companyDetails.bidPrice;
  }
  sellshare(price) {

    const userDetails = JSON.parse(localStorage.getItem('userDetails'));
    console.log(userDetails);
    const rqObj = {
      userId: userDetails.user[0].userId,
      companyId: this.userService.selectedSharesToUpdate.companyId,
      totalSharesTransacted: this.userService.selectedSharesToUpdate.quantity,
      totalAmount: this.userService.selectedSharesToUpdate.price
    };
    console.log(rqObj);
    this.userService.sellShare(rqObj).subscribe(data => {

      if (data.statusCode === 201) {
        console.log(data);
        console.log(data.value);
        this.success = data.description;
        this.router.navigateByUrl('/my-shares');

      } else {
        console.log(data);
        this.failure = data.description;
      }
      setTimeout(() => {
        this.success = null;
      }, 2000);

    });
  }

}
