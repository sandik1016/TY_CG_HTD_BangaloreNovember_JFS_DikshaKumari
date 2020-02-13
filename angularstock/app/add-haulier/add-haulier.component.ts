import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';


@Component({
  selector: 'app-add-haulier',
  templateUrl: './add-haulier.component.html',
  styleUrls: ['./add-haulier.component.css']
})
export class AddHaulierComponent implements OnInit {
  success: string;
  failure: string;
  constructor(private crudOperations: UserService) { }

  ngOnInit() {
  }

  addHaulier(form: NgForm) {
    console.log(form);
    this.crudOperations.addHaulierData(form.value).subscribe(data => {
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
