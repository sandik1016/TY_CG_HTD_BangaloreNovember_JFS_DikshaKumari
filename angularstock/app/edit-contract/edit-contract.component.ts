import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-edit-contract',
  templateUrl: './edit-contract.component.html',
  styleUrls: ['./edit-contract.component.css']
})
export class EditContractComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

updateContract(form: NgForm) {
this.userService.updateContractData(form.value).subscribe(response => {
console.log(response);
if (response.status === 201) {
this.router.navigateByUrl('contract/getall-contracts');
}
form.reset();
});
}

ngOnInit() {

}


}
