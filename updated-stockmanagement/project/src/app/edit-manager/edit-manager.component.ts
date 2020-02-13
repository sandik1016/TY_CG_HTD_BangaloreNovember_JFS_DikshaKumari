import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-manager',
  templateUrl: './edit-manager.component.html',
  styleUrls: ['./edit-manager.component.css']
})
export class EditManagerComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

updateManager(form: NgForm) {
this.userService.updateManagerData(form.value).subscribe(response => {
console.log(response);
if (response.statusCode === 201) {
this.router.navigateByUrl('/getall-managers');
}
form.reset();
});
}

ngOnInit() {
}


}
