import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-haulier',
  templateUrl: './edit-haulier.component.html',
  styleUrls: ['./edit-haulier.component.css']
})
export class EditHaulierComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

updateHaulier(form: NgForm) {
this.userService.updateHaulierData(form.value).subscribe(response => {
console.log(response);
if (response.status === 201) {
this.router.navigateByUrl('haulier/getall-hauliers');
}
form.reset();
});
}

ngOnInit() {
}

}
