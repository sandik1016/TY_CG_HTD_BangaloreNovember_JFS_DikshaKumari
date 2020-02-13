import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-hauliers',
  templateUrl: './get-hauliers.component.html',
  styleUrls: ['./get-hauliers.component.css']
})
export class GetHauliersComponent implements OnInit {

  success: string;

  hauliers: Haulier[];
  constructor(private userService: UserService, private router: Router) {
    this.getHauliers();
  }

  getHauliers() {
    this.userService.getAllHauliersData().subscribe(response => {
      console.log(response);
      this.hauliers = response.haulier;
    }, err => {
      console.log(err);
    });
  }
  deleteHaulier(haulier: Haulier) {
    this.userService.deleteHaulierData(haulier).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.hauliers.splice(this.hauliers.indexOf(haulier), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  selectHaulier(haulier) {
    this.userService.selectedHaulierToUpdate = haulier;
    this.router.navigateByUrl('/edit-haulier');
  }

  ngOnInit() {
  }

}
