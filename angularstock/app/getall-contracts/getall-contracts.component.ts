import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-contracts',
  templateUrl: './getall-contracts.component.html',
  styleUrls: ['./getall-contracts.component.css']
})
export class GetallContractsComponent implements OnInit {

  success: string;

  contracts: Contract[];
  constructor(private userService: UserService, private router: Router) {
    this.getContracts();
  }

  getContracts() {
    this.userService.getAllContractsData().subscribe(response => {
      console.log(response);
      this.contracts = response.contract;
    }, err => {
      console.log(err);
    });
  }
  deleteContract(contract: Contract) {
    this.userService.deleteContractData(contract).subscribe(response => {
      console.log(response);
      if (response.status === 201) {
        this.contracts.splice(this.contracts.indexOf(contract), 1);
        this.success = response.success;
      }
    });
  }

  deleteMessage() {
    this.success = null;
  }

  selectContract(contract) {
    this.userService.selectedContractToUpdate = contract;
    this.router.navigateByUrl('/edit-contract');
  }

  ngOnInit() {
  }

}
