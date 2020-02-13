import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-manager',
  templateUrl: './add-manager.component.html',
  styleUrls: ['./add-manager.component.css']
})
export class AddManagerComponent implements OnInit {
  success: string;
  user = 'manager';
  failure: string;
  constructor(private crudOperations: UserService) { }

  ngOnInit() {
  }

  addManager(form: NgForm) {
    console.log(form);
    this.crudOperations.addManagerData(form.value).subscribe(data => {

      if (data.statusCode === 201) {
        console.log(data);
        console.log(form.value);
        this.success = data.message;

      } else {
        console.log(data);
        this.failure = data.message;
      }
      setTimeout(() => {
          this.success = null;
        }, 2000);
      form.reset();
      }
    );

}

}
