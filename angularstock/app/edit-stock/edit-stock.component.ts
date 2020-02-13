import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-stock',
  templateUrl: './edit-stock.component.html',
  styleUrls: ['./edit-stock.component.css']
})
export class EditStockComponent implements OnInit {

  constructor(public userService: UserService,
              private router: Router) { }

updateStock(form: NgForm) {
this.userService.updateStockData(form.value).subscribe(response => {
console.log(response);
if (response.statusCode === 201) {
this.router.navigateByUrl('/get-all-stocks');
}
form.reset();
});
}

ngOnInit() {
}


}

