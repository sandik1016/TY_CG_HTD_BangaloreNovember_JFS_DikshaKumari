import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {

  success: string;
  failure: string;
  today: string;
 miniDate: string;
 deliveryDayValue = '';
  constructor(private crudOperations: UserService) { }
  ngOnInit() {
    const date = new Date();
    const month = date.getMonth() + 1;
    let monthString = '';
    if (month <= 9) {
      monthString = '0' + month.toString();
    } else {
      monthString = month.toString();
    }
    this.miniDate = date.getFullYear().toString() + '-' + monthString + '-' + ( date.getDate() + 1).toString();
    console.log(this.miniDate, typeof this.miniDate);
   // this.miniDate = this.today;
  }
  valueChanged() {
    console.log(this.today);
    const date = new Date(this.today);
    const day  = date.getDay();
    console.log(day);
    // tslint:disable-next-line: triple-equals
    if (day == 0) {
       this.deliveryDayValue = 'Sunday';
     } else if (day == 1) {
      this.deliveryDayValue = 'Monday';
    } else if (day == 2) {
      this.deliveryDayValue = 'Tuesday';
    } else if (day == 3) {
      this.deliveryDayValue = 'Wednesday';
    } else if (day == 4) {
      this.deliveryDayValue = 'Thursday';
    } else if (day == 5) {
      this.deliveryDayValue = 'Friday';
    } else {

      this.deliveryDayValue = 'Saturday';
    }
  }
  addContract(form: NgForm) {
    console.log(form);
    this.crudOperations.addContractData(form.value).subscribe(data => {
      console.log(data);
      if (data.status === 201) {
        this.success = data.message;
        setTimeout(() => {
          this.success = null;
        }, 5000);
        form.reset();
      } else {
        this.failure = data.message;
        setTimeout(() => {
          this.failure = null;
        }, 5000);
      }
    });

}

}
