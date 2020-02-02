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
  failure: string;
  constructor(private userService: UserService) { }

  ngOnInit() {
  }
  addUser(form: NgForm) {
    console.log(form);
    this.userService.register(form.value).subscribe( data => {
      console.log(data);
      if (data.status === 201) {
        this.success = 'Successfully added';
        setTimeout(() => {
          this.success = null;
        }, 5000);
        form.reset();
      } else {
        this.failure = 'Failed to Add';
        setTimeout(() => {
          this.failure = null;
        }, 5000);
      }
    });
  }

}
